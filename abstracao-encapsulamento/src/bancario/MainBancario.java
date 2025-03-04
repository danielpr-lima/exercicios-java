package bancario;

import java.util.Scanner;

public class MainBancario {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double deposito = 0;

        System.out.println("Digite o valor que vocë ira depositar: ");
        deposito= input.nextDouble();
        ContaBancaria conta = new ContaBancaria(deposito);

                int opcao;
                do {
                    // Exibe o menu
                    System.out.println("\n--- Menu ---");
                    System.out.println("1 - Consultar Saldo");
                    System.out.println("2 - Consultar Cheque Especial");
                    System.out.println("3 - Depositar Dinheiro");
                    System.out.println("4 - Sacar Dinheiro");
                    System.out.println("5 - Pagar Boleto");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");

                    // Lê a opção do usuário
                    opcao = input.nextInt();

                    // Executa a ação com base na opção escolhida
                    switch (opcao) {
                        case 1:
                            conta.consultarSaldo();
                            break;
                        case 2:
                            conta.consultarCheque();
                            break;
                        case 3:
                            System.out.print("Digite o valor a depositar: ");
                            double valorDeposito = input.nextDouble();
                            conta.depositoDineheiro(valorDeposito);
                            break;
                        case 4:
                            System.out.print("Digite o valor a sacar: ");
                            double valorSaque = input.nextDouble();
                            conta.sacarDinheiro(valorSaque);
                            break;
                        case 5:
                            System.out.print("Digite o valor do boleto: ");
                            double valorBoleto = input.nextDouble();
                            conta.pagarBoleto(valorBoleto);
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                    }
                } while (opcao != 0);

            }
}
