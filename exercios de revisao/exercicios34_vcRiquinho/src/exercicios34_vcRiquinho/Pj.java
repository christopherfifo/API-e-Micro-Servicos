package exercicios34_vcRiquinho;

class Pj extends Cliente {
	private String cnpj;

	public Pj(String nome, String email, String cnpj) {
		super(nome, email);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	double getTaxa() {
		return 0.0015;
	}
}