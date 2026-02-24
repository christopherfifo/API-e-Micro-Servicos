import java.util.Date;

class Salgadinho extends Prato {
    private String recheio;
    private String massa;

    public Salgadinho(double preco, Date validade, double peso, String recheio, String massa) {
        super(preco, validade, peso);
        this.recheio = recheio;
        this.massa = massa;
    }

    @Override
public String toString() {
    return "Salgadinho " + massa + " de " + recheio + super.dadosComuns();
}

    @Override
    public void calcularPreco() { }
}