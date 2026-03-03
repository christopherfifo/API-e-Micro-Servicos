package exercicios34_vcRiquinho;

abstract class Produto {
	private String nome;
	private String descricao;
	private double rendimento;

	public Produto(String nome, String descricao, double rendimento) {
		this.nome = nome;
		this.descricao = descricao;
		this.rendimento = rendimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	abstract double simular(int dias, double valor);
}