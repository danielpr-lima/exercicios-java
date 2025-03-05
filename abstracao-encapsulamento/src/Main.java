import bancario.MainBancario;
import carro.MainCarro;
import petShop.MainPet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Sistema de Carro");
            System.out.println("2 - Sistema de Pet");
            System.out.println("3 - Sistema Bancário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    MainCarro.main(new String[]{});
                    break;
                case 2:
                    MainPet.main(new String[]{});
                    break;
                case 3:
                    MainBancario.main(new String[]{});
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        input.close();
    }
}
