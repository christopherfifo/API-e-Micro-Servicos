package exercicios34_vcRiquinho;

class RendaFixa extends Produto {
    private int carencia;

    public RendaFixa(String nome, String descricao, double rendimento, int carencia) {
        super(nome, descricao, rendimento);
        this.carencia = carencia;
    }

    public int getCarencia() { 
    	return carencia; 
    }
    public void setCarencia(int carencia) { 
    	this.carencia = carencia; 
    }

    @Override
    double simular(int dias, double valor) {
        if (dias < carencia) {
            System.out.println("Aviso: O produto " + getNome() + " nao gerou rendimento. O periodo informado e menor que a carencia de " + carencia + " dias.");
            return 0;
        }
        double meses = dias / 30.0;
        return valor * (getRendimento() * meses);
    }
}