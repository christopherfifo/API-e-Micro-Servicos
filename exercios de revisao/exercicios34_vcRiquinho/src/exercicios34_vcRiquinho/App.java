package exercicios34_vcRiquinho;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Db banco = new Db();
        
        // executar testes
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 9) {
        	System.out.println("Escolha uma opcao: ");
        	System.out.println("1 - Novo cliente PF ");
        	System.out.println("2 - Novo cliente PJ ");
        	System.out.println("3 - Listar clientes ");
        	System.out.println("4 - Novo produto renda fixa ");
        	System.out.println("5 - Novo produto renda variavel ");
        	System.out.println("6 - Listar produtos ");
        	System.out.println("7 - Simular rendimento ");
        	System.out.println("8 - Simular conta CDI");
        	System.out.println("9 - Sair ");
        	System.out.println("Escolha uma opcao: ");
        	
        	opcao = leitor.nextInt();
        	leitor.nextLine();
        	
        	switch (opcao) {
            case 1:
            	System.out.print("\n-- Adicao de cliente PF --\n");
                System.out.print("Nome: ");
                String nomepf = leitor.nextLine();
                System.out.print("Email: ");
                String emailpf = leitor.nextLine();
                System.out.print("CPF: ");
                String cpf = leitor.nextLine();
                
                Pf clientepf = new Pf(nomepf, emailpf, cpf);
                banco.addCliente(clientepf);
                System.out.println("Feito!\n");
                break;
            case 2:
            	System.out.print("\n-- Adicao de cliente PJ --\n");
                System.out.print("Nome: ");
                String nomepj = leitor.nextLine();
                System.out.print("Email: ");
                String emailpj = leitor.nextLine();
                System.out.print("CNPJ: ");
                String cnpj = leitor.nextLine();
                
                Pf clientepj = new Pf(nomepj, emailpj, cnpj);
                banco.addCliente(clientepj);
                System.out.println("Feito!\n");
                break;
            case 3:
            	System.out.print("\n-- Listagem de clientes --\n");
                banco.lerClientes();
                System.out.print("\n");
                break;
            case 4:
            	System.out.print("\n-- Adicao de produto renda fixa --\n");
                System.out.print("Nome: ");
                String nomeProdutorf = leitor.nextLine();
                System.out.print("Rendimento: ");
                double rendimentorf = leitor.nextDouble();
                System.out.print("Carencia (dias): ");
                int carenciarf = leitor.nextInt();
                
                RendaFixa produtorf = new RendaFixa(nomeProdutorf, rendimentorf, carenciarf);
                banco.addProduto(produtorf);
                System.out.println("Feito!\n");
                break;
            case 5:
            	System.out.print("\n-- Adicao de produto renda variavel --\n");
                System.out.print("Nome: ");
                String nomeProdutorv = leitor.nextLine();
                System.out.print("Rendimento: ");
                double rendimentorv = leitor.nextDouble();
                
                RendaVariavel produtorv = new RendaVariavel(nomeProdutorv, rendimentorv);
                banco.addProduto(produtorv);
                System.out.println("Feito!\n");
                break;
            case 6:
            	System.out.print("\n--Listagem de produtos --\n");
                banco.lerProdutos();
                System.out.print("\n");
                break;
            case 7:
            	System.out.print("\n-- Simulacao de rendimento --\n");
            	if (banco.clientes.isEmpty() || banco.produtos.isEmpty()) {
            		System.out.println("Cadastre um cliente e um produto primeiro");
            		break;
            	}
            	
            	System.out.println("Escolha o cliente: ");
            	for (int i = 0; i < banco.clientes.size(); i++) {
            		System.out.println(i+1 + " - " + banco.clientes.get(i).nome);
            	}
            	int idCli = leitor.nextInt();
            	idCli--;
            	
            	System.out.println("Escolha o produto: ");
            	for (int i = 0; i < banco.produtos.size(); i++) {
            		System.out.println(i+1 + " - " + banco.produtos.get(i).nome);
            	}
            	int idProd = leitor.nextInt();
            	idProd--;
            	
            	System.out.println("Dias (30, 60, 90, 180):");
            	int dias = leitor.nextInt();
            	
            	System.out.println("Valor a investir: ");
            	double valor = leitor.nextDouble();
            	
            	Cliente cli = banco.clientes.get(idCli);
            	Produto prod = banco.produtos.get(idProd);
            	
            	Investimento inv = new Investimento(valor);
            	inv.adicionar(prod);
            	cli.adicionar(inv);
            	
            	double lucro = inv.calcular(dias, cli.getTaxa());
            	
            	System.out.printf("Lucro estimado: %.2f\n", lucro);
            	break;
            case 8:
            	System.out.print("\n-- Simulacao de conta CDI --\n");
            	System.out.println("Valor na conta: ");
            	double saldo = leitor.nextDouble();
            	
            	System.out.println("Dias: ");
            	int prazo = leitor.nextInt();
            	
            	Cdi contaCdi = new Cdi(saldo);
            	double ganho = contaCdi.calcular(prazo, 0);
            	
            	System.out.printf("Lucro do CDI: %.2f\n", ganho);
            	break;
            case 9:
                System.out.println("\nFim\n");
                break;
            default:
                System.out.println("\nOpcao Invalida\n");
        	}
        	
        }
        leitor.close();
    }
}