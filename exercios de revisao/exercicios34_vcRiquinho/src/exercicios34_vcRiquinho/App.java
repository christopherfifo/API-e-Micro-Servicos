package exercicios34_vcRiquinho;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Db banco = new Db();
		Scanner leitor = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 11) {
			System.out.println("\n--- VcRiquinho ---");
			System.out.println("1 - Novo Cliente");
			System.out.println("2 - Ler Clientes");
			System.out.println("3 - Atualizar Cliente");
			System.out.println("4 - Excluir Cliente");
			System.out.println("5 - Novo Produto");
			System.out.println("6 - Ler Produtos");
			System.out.println("7 - Atualizar Produto");
			System.out.println("8 - Excluir Produto");
			System.out.println("9 - Simular Rendimento");
			System.out.println("10 - Simular Conta CDI");
			System.out.println("11 - Sair");
			System.out.print("Escolha: ");

			opcao = leitor.nextInt();
			leitor.nextLine();

			switch (opcao) {
			case 1: {
				System.out.print("Tipo (1-PF 2-PJ): ");
				int tipoCliente = leitor.nextInt();
				leitor.nextLine();

				System.out.print("Nome: ");
				String nome = leitor.nextLine();
				System.out.print("Email: ");
				String email = leitor.nextLine();

				Cliente cliente;
				if (tipoCliente == 1) {
					System.out.print("CPF: ");
					String doc = leitor.nextLine();
					cliente = new Pf(nome, email, doc);
				} else {
					System.out.print("CNPJ: ");
					String doc = leitor.nextLine();
					cliente = new Pj(nome, email, doc);
				}

				System.out.print("Conta inicial (1-Corrente 2-CDI 3-Investimento): ");
				int tipoConta = leitor.nextInt();
				System.out.print("Saldo: ");
				double saldo = leitor.nextDouble();

				if (tipoConta == 1) {
					cliente.adicionar(new ContaCorrente(saldo));
				} else if (tipoConta == 2) {
					cliente.adicionar(new Cdi(saldo));
				} else {
					cliente.adicionar(new Investimento(saldo));
				}

				banco.addCliente(cliente);
				System.out.println("Feito!");
				break;
			}
			case 2: {
				for (int i = 0; i < banco.getClientes().size(); i++) {
					System.out.println((i + 1) + " - " + banco.getClientes().get(i).getNome() + " ("
							+ banco.getClientes().get(i).getEmail() + ")");
				}
				break;
			}
			case 3: {
				System.out.print("Numero do cliente: ");
				int pos = leitor.nextInt();
				leitor.nextLine();

				Cliente atual = banco.getClientes().get(pos - 1);

				System.out.print("Novo nome (" + atual.getNome() + ") ou Enter para manter: ");
				String novoNome = leitor.nextLine();
				if (!novoNome.isEmpty()) {
					atual.setNome(novoNome);
				}

				System.out.print("Novo email (" + atual.getEmail() + ") ou Enter para manter: ");
				String novoEmail = leitor.nextLine();
				if (!novoEmail.isEmpty()) {
					atual.setEmail(novoEmail);
				}

				System.out.println("Feito!");
				break;
			}
			case 4: {
				System.out.print("Numero do cliente: ");
				int remover = leitor.nextInt();
				banco.delCliente(remover - 1);
				System.out.println("Feito!");
				break;
			}
			case 5: {
				System.out.print("Tipo (1-Fixo 2-Variavel): ");
				int tipoProduto = leitor.nextInt();
				leitor.nextLine();

				System.out.print("Nome: ");
				String nome = leitor.nextLine();
				System.out.print("Descricao: ");
				String texto = leitor.nextLine();
				System.out.print("Rendimento: ");
				double ganho = leitor.nextDouble();

				if (tipoProduto == 1) {
					System.out.print("Carencia: ");
					int limite = leitor.nextInt();
					RendaFixa produto = new RendaFixa(nome, texto, ganho, limite);
					banco.addProduto(produto);
				} else {
					RendaVariavel produto = new RendaVariavel(nome, texto, ganho);
					banco.addProduto(produto);
				}
				System.out.println("Feito!");
				break;
			}
			case 6: {
				for (int i = 0; i < banco.getProdutos().size(); i++) {
					System.out.println((i + 1) + " - " + banco.getProdutos().get(i).getNome() + " | "
							+ banco.getProdutos().get(i).getDescricao() + " (Rendimento: "
							+ banco.getProdutos().get(i).getRendimento() + ")");
				}
				break;
			}
			case 7: {
				System.out.print("Numero do produto: ");
				int lugar = leitor.nextInt();
				leitor.nextLine();

				Produto prod = banco.getProdutos().get(lugar - 1);

				System.out.print("Novo nome (" + prod.getNome() + ") ou Enter para manter: ");
				String novoNome = leitor.nextLine();
				if (!novoNome.isEmpty()) {
					prod.setNome(novoNome);
				}

				System.out.print("Nova descricao (" + prod.getDescricao() + ") ou Enter para manter: ");
				String novaDesc = leitor.nextLine();
				if (!novaDesc.isEmpty()) {
					prod.setDescricao(novaDesc);
				}

				System.out.print("Novo rendimento (" + prod.getRendimento() + ") ou Enter para manter: ");
				String novoGanho = leitor.nextLine();
				if (!novoGanho.isEmpty()) {
					prod.setRendimento(Double.parseDouble(novoGanho));
				}

				System.out.println("Feito!");
				break;
			}
			case 8: {
				System.out.print("Numero do produto: ");
				int apagar = leitor.nextInt();
				banco.delProduto(apagar - 1);
				System.out.println("Feito!");
				break;
			}
			case 9: {
				System.out.print("Numero do cliente: ");
				int posCli = leitor.nextInt();
				System.out.print("Numero do produto: ");
				int posProd = leitor.nextInt();
				System.out.print("Dias: ");
				int dias = leitor.nextInt();
				System.out.print("Valor: ");
				double valor = leitor.nextDouble();

				Cliente c = banco.getClientes().get(posCli - 1);
				Produto p = banco.getProdutos().get(posProd - 1);

				Investimento conta = new Investimento(valor);
				conta.adicionar(p);
				c.adicionar(conta);

				double lucro = conta.calcular(dias, c.getTaxa());
				System.out.println("Lucro liquido: " + lucro);
				break;
			}
			case 10: {
				System.out.print("Valor na conta: ");
				double dinheiro = leitor.nextDouble();
				System.out.print("Dias: ");
				int prazo = leitor.nextInt();

				Cdi conta = new Cdi(dinheiro);
				double resultado = conta.calcular(prazo, 0);

				System.out.println("Lucro liquido do CDI: " + resultado);
				break;
			}
			case 11: {
				System.out.println("Fim");
				break;
			}
			default: {
				System.out.println("Invalido");
			}
			}
		}
		leitor.close();
	}
}