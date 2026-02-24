public class TestaCadastro {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas();

        cadastro.cadastraPessoa(new Cliente("Christopher Willians", new Data(10, 5, 2000), 101));
        cadastro.cadastraPessoa(new Funcionario("Marcos Oliveira", new Data(15, 8, 1992), 3500.0f));
        cadastro.cadastraPessoa(new Gerente("Fernanda Souza", new Data(20, 11, 1985), 9000.0f, "TI"));

        System.out.println("--- Relatório de Cadastro ---");
        cadastro.imprimeCadastro();
    }
}