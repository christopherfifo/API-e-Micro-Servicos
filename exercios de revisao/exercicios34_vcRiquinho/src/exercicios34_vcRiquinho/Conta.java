package exercicios34_vcRiquinho;

public abstract class Conta implements Simulador {
    double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }
}
