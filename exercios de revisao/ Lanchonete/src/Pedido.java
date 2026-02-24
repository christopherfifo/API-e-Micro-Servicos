import java.util.ArrayList;

class Pedido {
    private String nomeCliente; 
    private double taxaServico; 
    private ArrayList<Prato> itensConsumidos = new ArrayList<>(); 

    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.taxaServico = taxaServico;
    }

    public void adicionarItem(Prato prato) {
        itensConsumidos.add(prato);
    }

    public double getValorTotal() {
        double totalItens = 0;
        for (Prato p : itensConsumidos) {
            totalItens += p.getPrecoVenda();
        }
        return totalItens + taxaServico;
    }

    public void mostrarFatura() { 
        System.out.println("\n--- NOTA FISCAL ---");
        System.out.println("Cliente: " + nomeCliente);
        for (Prato p : itensConsumidos) {
            System.out.println("- " + p.toString() + " | R$ " + p.getPrecoVenda());
        }
        System.out.println("Taxa de Serviço: R$ " + taxaServico);
        System.out.println("TOTAL: R$ " + getValorTotal());
        System.out.println("-------------------");
    }
}
