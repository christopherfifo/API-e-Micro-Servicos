import java.util.ArrayList;

public class CadastroPessoas {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void cadastraPessoa(Pessoa pess) {
        pessoas.add(pess);
    }

    public void imprimeCadastro() {
        for (Pessoa p : pessoas) {
            p.imprimeDados();
        }
    }
}