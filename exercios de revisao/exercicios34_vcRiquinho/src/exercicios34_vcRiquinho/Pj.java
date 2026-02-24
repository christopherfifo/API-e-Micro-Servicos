package exercicios34_vcRiquinho;

public class Pj extends Cliente {
    String cnpj;

    public Pj(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    @Override
    double getTaxa() {
        return 0.0015;
    }
}