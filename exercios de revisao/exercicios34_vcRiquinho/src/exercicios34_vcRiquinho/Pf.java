package exercicios34_vcRiquinho;

class Pf extends Cliente {
	private String cpf;

	public Pf(String nome, String email, String cpf) {
		super(nome, email);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	double getTaxa() {
		return 0.001;
	}
}