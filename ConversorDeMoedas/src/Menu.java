import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Map<Integer, String> moedas = Map.of(
            1, "ARS",
            2, "BOB",
            3, "BRL",
            4, "CLP",
            5, "COP",
            6, "USD"
    );

    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("Escolha a moeda de origem:");
            moedas.forEach((k, v) -> System.out.printf("%d - %s%n", k, v));
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int origemOpc = scanner.nextInt();
            if (origemOpc == 0) {
                System.out.println("Saindo do conversor... Até mais!");
                break;
            }
            if (!moedas.containsKey(origemOpc)) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            System.out.println("\nEscolha a moeda de destino:");
            moedas.forEach((k, v) -> System.out.printf("%d - %s%n", k, v));
            System.out.print("Opção: ");
            int destinoOpc = scanner.nextInt();
            if (!moedas.containsKey(destinoOpc) || destinoOpc == origemOpc) {
                System.out.println("Opção inválida ou igual à moeda de origem. Tente novamente.");
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = moedas.get(origemOpc);
            String moedaDestino = moedas.get(destinoOpc);

            ConversorDeMoedas converter = new ConversorDeMoedas();
            converter.converter(moedaOrigem, moedaDestino, valor);
        }

        scanner.close();
    }
}
