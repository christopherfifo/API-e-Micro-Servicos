package exercicios34_vcRiquinho;

public class RendaVariavel extends Produto {
    public RendaVariavel(String nome, double rendimento) {
        super(nome, rendimento);
    }

    @Override
    double simular(int dias, double valor) {
        double meses = dias / 30.0;
        return valor * (rendimento * meses);
    }
}