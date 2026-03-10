import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook Dell", 4500.0, "Eletrônicos"));
        produtos.add(new Produto("Smartphone Samsung", 2200.0, "Eletrônicos"));
        produtos.add(new Produto("Clean Code", 90.0, "Livros"));
        produtos.add(new Produto("Monitor 24'", 850.0, "Eletrônicos"));
        produtos.add(new Produto("Java Efetivo", 120.0, "Livros"));
        produtos.add(new Produto("Mouse Gamer", 150.0, "Eletrônicos"));
        produtos.add(new Produto("O Senhor dos Anéis", 70.0, "Livros"));
        produtos.add(new Produto("Teclado Mecânico", 550.0, "Eletrônicos"));

        // a. Filtragem de Eletrônicos
        System.out.println("--- Item A: Eletrônicos (Tradicional) ---");
        for (Produto p : produtos) {
            if (p.getCategoria().equals("Eletrônicos")) {
                System.out.println(p.getNome());
            }
        }

        System.out.println("\n--- Item A: Eletrônicos (Stream/Filter) ---");
        produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .forEach(p -> System.out.println(p.getNome()));

        // b. Preços > 500.0
        List<Double> precosCaros = produtos.stream()
                .filter(p -> p.getPreco() > 500.0)
                .map(Produto::getPreco)
                .collect(Collectors.toList());
        System.out.println("\n--- Item B: Preços > 500 ---\n" + precosCaros);

        // c. Total estoque Livros
        double totalLivros = produtos.stream()
                .filter(p -> p.getCategoria().equals("Livros"))
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("\n--- Item C: Total Livros ---\nR$ " + totalLivros);

        // d e e. Buscar Produto e Optional
        System.out.println("\n--- Item E: Testando Busca ---");
        buscarProdutoPorNome(produtos, "Clean Code")
                .ifPresent(p -> System.out.println("Encontrado: " + p));

        try {
            buscarProdutoPorNome(produtos, "PlayStation 5")
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        } catch (RuntimeException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }

        // f. Map com Lambda e Method Reference
        List<String> nomesLambda = produtos.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());

        List<String> nomesMethodRef = produtos.stream()
                .map(Produto::getNome) // Refatorado
                .collect(Collectors.toList());

        System.out.println("\n--- Item F: Lista de Nomes (Method Reference) ---\n" + nomesMethodRef);
    }

    // d. Método de busca
    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}