package petShop;

import java.util.Scanner;

public class MainPet {
    private final static Scanner input = new Scanner(System.in);
    private final static PetMachine petMachine = new PetMachine();

    public static void main(String[] args) {
        int option;
        input.useDelimiter("\\n");

        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água na máquina");
            System.out.println("5 - Verificar shampoo na máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Sair");
            option = input.nextInt();

            switch (option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0); // O loop do menu continua até a opção 0 ser escolhida.
    }

    private static void setWater() {
        System.out.println("Tentando colocar água na máquina...");
        petMachine.addWater(); // Chamando a função correta para adicionar água.
    }

    private static void setShampoo() {
        System.out.println("Tentando colocar shampoo na máquina...");
        petMachine.addShampoo(); // Mantendo o comportamento para adicionar shampoo.
    }

    private static void verifyWater() {
        var amount = petMachine.getWater(); // Chamando a função correta para verificar água.
        System.out.println("A máquina está com " + amount + " litros de água.");
    }

    private static void verifyShampoo() {
        var amount = petMachine.getShampoo(); // Mantendo a verificação de shampoo.
        System.out.println("A máquina está com " + amount + " litros de shampoo.");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina." : "Não tem pet na máquina.");
    }

    public static void setPetInPetMachine() {
        input.nextLine(); // Consumir a quebra de linha pendente
        String nome = "";
        while (nome == null || nome.isEmpty()) {
            System.out.println("Informe o nome do pet:");
            nome = input.nextLine();
        }
        Pet pet = new Pet(nome);
        petMachine.setPet(pet);
    }
}
