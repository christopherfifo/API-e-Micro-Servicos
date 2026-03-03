package exercicios34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;

class Investimento extends Conta {
	private List<Produto> produtos;

	public Investimento(double saldo) {
		super(saldo);
		this.produtos = new ArrayList<>();
	}

	public void adicionar(Produto p) {
		produtos.add(p);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public double calcular(int dias, double taxa) {
		double lucro = 0;
		if (produtos.isEmpty()) {
			return 0;
		}

		double pedaco = getSaldo() / produtos.size();
		for (Produto p : produtos) {
			lucro += p.simular(dias, pedaco);
		}

		double desconto = lucro * taxa;
		return lucro - desconto;
	}
}
