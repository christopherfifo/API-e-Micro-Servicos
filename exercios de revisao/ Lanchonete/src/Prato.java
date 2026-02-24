import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Prato {
    protected double precoVenda;
    protected Date dataValidade;
    protected double peso;

    public Prato(double precoVenda, Date dataValidade, double peso) {
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    public abstract void calcularPreco();

    public String dadosComuns() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return " | Peso: " + peso + "kg | Validade: " + sdf.format(dataValidade);
    }

    public double getPrecoVenda() { return precoVenda; }
}