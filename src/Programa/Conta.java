package Programa;

public class Conta {

    private static int contadorDeContas = 1;

    private int numeroConta;
    private final Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas +=1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ",\n pessoa=" + pessoa +
                ",\n saldo=" + saldo +
                '}';
    }

    public void depositar(Double valor){
        if(valor>0){
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito bem sucedido");
        } else {
            System.out.println("Depósito não realizado");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque bem sucedido");
        } else {
            System.out.println("Saque não realizado");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência bem sucedida");
        } else {
            System.out.println("Transferência não realizada");
        }
    }
}
