package bancario;

public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double deposito) {
        this.saldo = deposito;
        criacaoCheque(deposito);
    }

    private void criacaoCheque(double deposito) {
        if (deposito <= 500) {
            chequeEspecial = 50.00;
        } else {
            chequeEspecial = deposito * 0.5;
        }
    }

    private void cobrarChequeEspecial() {
        if (chequeEspecialUsado > 0) {
            double taxa = chequeEspecialUsado * 0.2; // 20% de taxa sobre o cheque especial usado
            double totalCobranca = chequeEspecialUsado + taxa;

            if (saldo >= totalCobranca) {
                saldo -= totalCobranca; // Quita o cheque especial e a taxa com o saldo disponível
                chequeEspecialUsado = 0;
            } else {
                chequeEspecialUsado -= saldo; // Deduz o saldo disponível
                saldo = 0;
            }
        }
    }

    public void consultarSaldo() {
        cobrarChequeEspecial();
        double valorConta = saldo + chequeEspecial - chequeEspecialUsado;
        System.out.println("saldo + cheque especial: " + valorConta);
    }

    public void consultarCheque() {
        System.out.println("valor usado: " + chequeEspecialUsado);
    }

    public void depositoDineheiro(double deposito) {
        saldo += deposito;
        System.out.println("Seu depósito foi feito no valor: " + deposito);
        cobrarChequeEspecial();
    }

    public void sacarDinheiro(double sacar) {
        double saldoDisponivel = saldo + chequeEspecial - chequeEspecialUsado;

        if (saldoDisponivel < sacar) {
            System.out.println("Saldo insuficiente");
        } else {
            if (sacar > saldo) {
                chequeEspecialUsado += (sacar - saldo);
                saldo = 0;
            } else {
                saldo -= sacar;
            }
        }
        cobrarChequeEspecial();
    }

    public void pagarBoleto(double valor) {
        sacarDinheiro(valor);
    }
}
