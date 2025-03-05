package petShop;

public class PetMachine {
    private boolean clean;
    private int water;
    private int shampoo;
    private Pet pet;


    public PetMachine() {
        this.clean = true;
        this.water = 30;
        this.shampoo = 10;
    }

    public void takeAShower(){
        if(this.pet == null){
            System.out.println("Coloque o pet na maquina para iniciar o banho");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet "+ pet.getName() + " esta limpo");
    }

    public void addWater(){
        if (water == 30){
            System.out.println("A capacidade de agua da maquina esta no maximo");
            return;
        }
    }

    public void addShampoo(){
        if (shampoo == 10){
            System.out.println("A capacidade de shampoo da maquina esta no maximo");
            return;
        }
        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean){
            System.out.println("A maquina esta suja, para colocar o pet");
            return;
        }

        if (hasPet()){
            System.out.println("O pet" + this.pet.getName() + "esta na maquina nesse momento");
            return;
        }
        System.out.println("O pet" +pet.getName() + "foi colocado na maquina" );
        this.pet = pet;
    }

    public void removePet(){
        this.clean = this.pet.isClean();
        System.out.println("O pet " + pet.getName() + "esta limpo");
        this.pet = null;

    }

    public void wash(){
        this.water -=10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.printf("A maquina esta limpa");
    }

}
