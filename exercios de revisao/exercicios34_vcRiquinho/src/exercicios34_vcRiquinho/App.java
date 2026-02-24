package exercicios34_vcRiquinho;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Db banco = new Db();
        
        // executar testes
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 5) {
        	System.out.println("Escolha uma opcao: ");
        	System.out.println("1 - novo cliente PF: ");
        	System.out.println("2 - listar clientes: ");
        	System.out.println("3 - novo produto renda fixa: ");
        	System.out.println("4 - listar produtos: ");
        	System.out.println("5 - sair: ");
        	System.out.println("Escolha uma opcao: ");
        	
        	opcao = leitor.nextInt();
        	leitor.nextLine();
        	
        	switch (opcao) {
            case 1:
            	System.out.print("\n");
                System.out.print("Nome: ");
                String nome = leitor.nextLine();
                System.out.print("Email: ");
                String email = leitor.nextLine();
                System.out.print("CPF: ");
                String cpf = leitor.nextLine();
                
                Pf cliente = new Pf(nome, email, cpf);
                banco.addCliente(cliente);
                System.out.println("Feito!\n");
                break;
            case 2:
            	System.out.print("\n");
                banco.lerClientes();
                System.out.print("\n");
                break;
            case 3:
            	System.out.print("\n");
                System.out.print("Nome: ");
                String nomeProduto = leitor.nextLine();
                System.out.print("Rendimento: ");
                double rendimento = leitor.nextDouble();
                System.out.print("Carencia (dias): ");
                int carencia = leitor.nextInt();
                
                RendaFixa produto = new RendaFixa(nomeProduto, rendimento, carencia);
                banco.addProduto(produto);
                System.out.println("Feito!\n");
                break;
            case 4:
            	System.out.print("\n");
                banco.lerProdutos();
                System.out.print("\n");
                break;
            case 5:
                System.out.println("\nFim\n");
                break;
            default:
                System.out.println("\nInvalido\n");
        	}
        	
        }
        leitor.close();
    }
}