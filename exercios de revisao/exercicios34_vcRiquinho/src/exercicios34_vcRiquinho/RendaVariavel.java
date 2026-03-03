package exercicios34_vcRiquinho;

class RendaVariavel extends Produto {
    public RendaVariavel(String nome, String descricao, double rendimento) {
        super(nome, descricao, rendimento);
    }

    @Override
    double simular(int dias, double valor) {
        double meses = dias / 30.0;
        return valor * (getRendimento() * meses);
    }
}