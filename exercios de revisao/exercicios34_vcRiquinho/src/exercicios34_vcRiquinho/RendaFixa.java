package exercicios34_vcRiquinho;

public class RendaFixa extends Produto {
    int carencia;

    public RendaFixa(String nome, double rendimento, int carencia) {
        super(nome, rendimento);
        this.carencia = carencia;
    }

    @Override
    double simular(int dias, double valor) {
        if (dias < carencia) {
            return 0;
        }
        double meses = dias / 30.0;
        return valor * (rendimento * meses);
    }
}