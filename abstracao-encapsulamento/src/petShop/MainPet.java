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
            System.out.println("2 - Abastecer a maquina com agua");
            System.out.println("3 - Abastecer a maquina com shampoo");
            System.out.println("4 - Verifica agua na maquina");
            System.out.println("5 - verifica shampoo na maquina");
            System.out.println("6 - verifica se tem pet no banho");
            System.out.println("7 - colocar pet na maquina");
            System.out.println("8 - retirar pet na maquina");
            System.out.println("9 - limpar maquina");
            System.out.println("0 - sair");
            option = input.nextInt();

        }while (option != 0);

        switch (option){
            case 1 -> petMachine.takeAShower();
            case 2 -> setWater();
            case 3 -> setShampoo();
            case 4 -> verifyWater();
            case 5 -> verifyShampoo();
            case 6 -> checkIfHasPetInMachine();
            case 7 -> setPetInPetMachine();
            case 8 -> petMachine.removePet();
            case 9 -> petMachine.wash();
            case 0 -> System.exit(0);
            default -> System.out.println("Opcao invalida!!");
        }
    }

    private static void setWater() {
        System.out.println("Tentando colocar agua na maquina");
        petMachine.addShampoo();
    }

    private static void setShampoo() {
        System.out.println("Tentando colocar shampoo na maquina");
        petMachine.addShampoo();
    }

    private static void verifyWater() {
        var amount = petMachine.getShampoo();
        System.out.println("A mauina esta no momento com" + amount + "litros de agua");
    }

    private static void verifyShampoo() {
        var amount = petMachine.getShampoo();
        System.out.println("A mauina esta no momento com" + amount + "litros de shammpo");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet? "tem pet na maquina" : "nao tem pet na maquina");
    }

    public static void  setPetInPetMachine(){
        var nome = "";
        while(nome == null || nome.isEmpty()){
            System.out.println("Informe o nome do Pet");
            nome =input.next();
        }
        var pet = new Pet(nome);

        petMachine.setPet(pet);
    }

    public  void getPetFromMachine(){
        petMachine.removePet();
    }
}
