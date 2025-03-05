package carro;

public class Carro {
    private boolean onOff;
    private int velocidade;
    private int marcha;

    public Carro() {
        this.marcha = 0;
        this.velocidade = 0;
        this.onOff = false;
    }


    public void ligar(){
        onOff = true;
        System.out.println("Carro ligado!!");
    }

    public void desligar(){
        if (marcha == 0 && velocidade == 0){
            onOff = false;
            System.out.println("Carro desligado!!");
        }else {
            System.out.println("Pare o carro e deixe em ponto morto");
        }
    }

    public void acelerar(int velocidade){
        if (!onOff) {
            System.out.println("O carro está desligado!!");

        } else if (marcha == 0) {
            System.out.println("O carro está no neutro!!");
        } else {
            for (int i = 0; i < velocidade && this.velocidade < 120; i++) {
                this.velocidade++;
                alterarMarcha();
                System.out.println("km/h: " + this.velocidade);
            }
        }
    }

    public void diminuir(int velocidade){
        if (onOff){
            for (int i = 0; i < velocidade && this.velocidade > 0; i++) {
                this.velocidade--;
                System.out.println("km/h: " + this.velocidade);
                alterarMarcha();
            }
        }else {
            System.out.println("O carro está desligado!!");
        }
    }

    public void verificarVelocidade() {
        System.out.println("km/h: " + velocidade);
    }

    public void verificarMarcha() {
        System.out.println("marcha: " + marcha);
    }

    public void virar(String lado){
        if (velocidade > 0 && velocidade <= 40){
            switch (lado){
                case "DIREITA":
                    System.out.println("Virando para a direita");
                    break;
                case "ESQUERDA":
                    System.out.println("Virando para a esquerda");
                    break;
                default:
                    System.out.println("Lado incorreto!!");
            }
        } else {
            System.out.println("Velocidade fora do intervalo para virar! (1-40 km/h)");
        }
    }

    public void alterarMarcha(){

        int novaMarcha = marcha;
        if (velocidade >= 0 && velocidade <= 20) {
            marcha = 1;
        } else if (velocidade >= 21 && velocidade <= 40) {
            marcha = 2;
        } else if (velocidade >= 41 && velocidade <= 60) {
            marcha = 3;
        } else if (velocidade >= 61 && velocidade <= 80) {
            marcha = 4;
        } else if (velocidade >= 81 && velocidade <= 100) {
            marcha = 5;
        } else if (velocidade >= 101 && velocidade <= 120) {
            marcha = 6;
        } else {
            System.out.println("A velocidade está fora do limite (0-120 km/h).");
        }
        
        if (novaMarcha != marcha){
            System.out.println("Marcha: " + marcha);
        }
    }

    public void neutroPrimeira(){
        if (marcha == 0 && onOff){
            marcha = 1;
            verificarMarcha();
        }else if (marcha == 1 && velocidade == 0){
            marcha = 0;
            System.out.println("Neutro");
        }else if (velocidade > 0){
            System.out.println("Diminua a velocidade para colocar no neutro");
        }
    }

}
