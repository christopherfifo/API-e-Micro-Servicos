import java.util.Date;

class Lanche extends Prato {
    private String pao;
    private String recheio;
    private String molho;

    public Lanche(double preco, Date validade, double peso, String pao, String recheio, String molho) {
        super(preco, validade, peso);
        this.pao = pao;
        this.recheio = recheio;
        this.molho = molho;
    }

    @Override
public String toString() {
    return "Lanche no pão: " + pao + " com " + molho + "e" + recheio + super.dadosComuns();
}

    @Override
    public void calcularPreco() {  }
}