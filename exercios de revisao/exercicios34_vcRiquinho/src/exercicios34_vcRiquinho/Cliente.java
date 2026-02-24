package exercicios34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    String nome;
    String email;
    List<Conta> contas;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.contas = new ArrayList<>();
    }

    public void adicionar(Conta c) {
        contas.add(c);
    }

    abstract double getTaxa();
}
