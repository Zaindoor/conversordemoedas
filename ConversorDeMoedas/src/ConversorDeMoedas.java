import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorDeMoedas {

    private static final String API_KEY = Config.get("api.key");
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6";

    public void converter(String moedaOrigem, String moedaDestino, double valor) {
        HttpClient client = HttpClient.newHttpClient();
        String apiKey = Config.get("api.key");

        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, moedaOrigem);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("🔎 Resposta bruta da API:");
            System.out.println(response.body());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            if ("success".equals(json.get("result").getAsString())) {
                JsonObject rates = json.getAsJsonObject("conversion_rates");

                if (rates.has(moedaDestino)) {
                    double taxa = rates.get(moedaDestino).getAsDouble();
                    double valorConvertido = valor * taxa;
                    System.out.printf("💸 %.2f %s = %.2f %s%n", valor, moedaOrigem, valorConvertido, moedaDestino);
                } else {
                    System.out.println("❌ Moeda destino não encontrada nas taxas.");
                }
            } else {
                System.out.println("❌ Erro na resposta da API: " + json.get("error-type").getAsString());
            }

        } catch (Exception e) {
            System.out.println("❌ Erro na conversão: " + e.getMessage());
        }
    }
}