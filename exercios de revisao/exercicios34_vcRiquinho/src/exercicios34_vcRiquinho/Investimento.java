package exercicios34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;

public class Investimento extends Conta {
    List<Produto> produtos;

    public Investimento(double saldo) {
        super(saldo);
        this.produtos = new ArrayList<>();
    }

    public void adicionar(Produto p) {
        produtos.add(p);
    }

    @Override
    public double calcular(int dias, double taxa) {
        double lucro = 0;
        if (produtos.isEmpty()) {
        	System.out.println("nenhum produto");
            return 0;
        }

        double pedaco = saldo / produtos.size();
        for (Produto p : produtos) {
            lucro += p.simular(dias, pedaco);
        }

        double desconto = lucro * taxa;
        return lucro - desconto;
    }
}
