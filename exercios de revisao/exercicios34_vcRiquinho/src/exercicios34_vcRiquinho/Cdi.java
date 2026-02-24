package exercicios34_vcRiquinho;

public class Cdi extends Conta {
    public Cdi(double saldo) {
        super(saldo);
    }

    @Override
    public double calcular(int dias, double taxa) {
        double cdi = 0.01;
        double diario = cdi / 30.0;
        double lucro = saldo * (diario * dias);
        double desconto = lucro * 0.0007;
        return lucro - desconto;
    }
}
