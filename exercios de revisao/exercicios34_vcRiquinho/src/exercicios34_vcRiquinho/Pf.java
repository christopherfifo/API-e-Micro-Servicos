package exercicios34_vcRiquinho;

public class Pf extends Cliente {
    String cpf;

    public Pf(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    @Override
    double getTaxa() {
        return 0.001;
    }
}
