package exercicios34_vcRiquinho;

class ContaCorrente extends Conta {
	public ContaCorrente(double saldo) {
		super(saldo);
	}

	@Override
	public double calcular(int dias, double taxa) {
		return 0;
	}
}