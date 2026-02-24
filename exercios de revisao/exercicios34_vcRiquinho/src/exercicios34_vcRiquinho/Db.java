package exercicios34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;

public class Db {
    List<Cliente> clientes = new ArrayList<>();
    List<Produto> produtos = new ArrayList<>();

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void lerClientes() {
        for (Cliente c : clientes) {
            System.out.println(c.nome);
        }
    }

    public void delCliente(Cliente c) {
        clientes.remove(c);
    }

    public void addProduto(Produto p) {
        produtos.add(p);
    }

    public void lerProdutos() {
        for (Produto p : produtos) {
            System.out.println(p.nome);
        }
    }

    public void delProduto(Produto p) {
        produtos.remove(p);
    }
}