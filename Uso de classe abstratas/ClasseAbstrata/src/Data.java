public class Data {
    public int dia;
    public int mes;
    public int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }
}