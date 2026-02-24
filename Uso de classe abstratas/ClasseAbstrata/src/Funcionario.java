public class Funcionario extends Pessoa {
    protected float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    public float calculaImposto() {
        return salario * 0.03f;
    }

    @Override
    public void imprimeDados() {
        System.out.printf("[Funcionário] Nome: %s | Salário: R$%.2f | Imposto: R$%.2f\n", nome, salario, calculaImposto());
    }
}