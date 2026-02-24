import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("SISTEMA LANCHONETE QUASE TRES LANCHES");
        System.out.print("Nome do Cliente: ");
        String nome = leitor.nextLine();
        Pedido pedido = new Pedido(nome, 5.00); 

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n--- CARDAPIO ---");
            System.out.println("1. Pizza (R$ 45,00)");
            System.out.println("2. Lanche (R$ 25,00)");
            System.out.println("3. Salgadinho (R$ 8,00)");
            System.out.println("4. Finalizar e Pagar");
            System.out.print("Escolha: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    pedido.adicionarItem(new Pizza(45.0, new Date(), 0.8, "Tomate", "Mussarela", "Catupiry")); 
                    break;
                case 2:
                    pedido.adicionarItem(new Lanche(25.0, new Date(), 0.4, "Francês", "Carne", "Maionese")); 
                    break;
                case 3:
                    pedido.adicionarItem(new Salgadinho(8.0, new Date(), 0.2, "Frango", "Frita")); 
                    break;
            }
        }

        pedido.mostrarFatura();

        double totalDaConta = pedido.getValorTotal();
        System.out.print("\nValor em dinheiro entregue pelo cliente: R$ ");
        double valorPago = leitor.nextDouble();

        if (valorPago >= totalDaConta) {
            double troco = valorPago - totalDaConta;
            System.out.printf("Troco do cliente: R$ %.2f\n", troco); 
        } else {
            System.out.println("Valor insuficiente!");
        }

        leitor.close();
    }
}