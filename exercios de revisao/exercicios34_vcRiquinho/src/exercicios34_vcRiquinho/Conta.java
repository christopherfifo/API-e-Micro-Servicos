package exercicios34_vcRiquinho;

abstract class Conta implements Simulador {
	private double saldo;

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}