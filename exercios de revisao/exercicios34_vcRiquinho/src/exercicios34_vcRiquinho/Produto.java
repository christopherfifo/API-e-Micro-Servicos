package exercicios34_vcRiquinho;

public abstract class Produto {
    String nome;
    double rendimento;

    public Produto(String nome, double rendimento) {
        this.nome = nome;
        this.rendimento = rendimento;
    }

    abstract double simular(int dias, double valor);
}
