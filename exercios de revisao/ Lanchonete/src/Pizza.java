import java.util.Date;

class Pizza extends Prato {
    private String molho;
    private String recheio;
    private String borda;

    public Pizza(double preco, Date validade, double peso, String molho, String recheio, String borda) {
        super(preco, validade, peso);
        this.molho = molho;
        this.recheio = recheio;
        this.borda = borda;
    }

@Override
public String toString() {
    return "Pizza de " + recheio + "com molho de" + molho + " (Borda: " + borda + ")" + super.dadosComuns();
}

    @Override
    public void calcularPreco() {  }
}