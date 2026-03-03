package exercicios34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;

class Db {
	private List<Cliente> clientes = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();

	public void addCliente(Cliente c) {
		clientes.add(c);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void delCliente(int posicao) {
		clientes.remove(posicao);
	}

	public void addProduto(Produto p) {
		produtos.add(p);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void delProduto(int posicao) {
		produtos.remove(posicao);
	}
}