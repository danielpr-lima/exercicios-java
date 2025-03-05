package carro;

import java.util.Scanner;

public class MainCarro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Verificar velocidade");
            System.out.println("6 - Verificar marcha");
            System.out.println("7 - Alternar marcha (Neutro/Primeira)");
            System.out.println("8 - Virar o carro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    System.out.print("Digite a quantidade de km/h para acelerar: ");
                    int acelerar = scanner.nextInt();
                    carro.acelerar(acelerar);
                    break;
                case 4:
                    System.out.print("Digite a quantidade de km/h para diminuir a velocidade: ");
                    int diminuir = scanner.nextInt();
                    carro.diminuir(diminuir);
                    break;
                case 5:
                    carro.verificarVelocidade();
                    break;
                case 6:
                    carro.verificarMarcha();
                    break;
                case 7:
                    carro.neutroPrimeira();
                    break;
                case 8:
                    System.out.print("Digite a direção (DIREITA/ESQUERDA): ");
                    scanner.nextLine(); // Consumir quebra de linha
                    String direcao = scanner.nextLine().toUpperCase();
                    carro.virar(direcao);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
