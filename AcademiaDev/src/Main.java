
import model.*;
import service.PlatformService;
import util.*;
import exception.EnrollmentException;
import java.util.*;

public class Main {
	private static PlatformService platform = new PlatformService();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		InitialData.populate(platform);

		while (true) {
			System.out.println("\n=== ACADEMIA DEV ===");
			System.out.println("Dica -> Admin: admin@dev.com | Aluno: chris@dev.com");
			System.out.print("Digite seu email para login (ou 'sair'): ");
			String email = sc.nextLine();

			if (email.equalsIgnoreCase("sair"))
				break;

			User loggedUser = platform.login(email);
			if (loggedUser == null) {
				System.out.println("Erro: Usuário não encontrado no sistema!");
				continue;
			}

			if (loggedUser instanceof Admin)
				menuAdmin((Admin) loggedUser);
			else if (loggedUser instanceof Student)
				menuStudent((Student) loggedUser);
		}
	}

	private static void menuAdmin(Admin admin) {
		while (true) {
			System.out.println("\n--- MENU ADMIN: " + admin.getName() + " ---");
			System.out.println(
					"1. Ativar/Inativar Cursos | 2. Alterar Plano de Aluno | 3. Atender Ticket | 4. Relatórios | 5. Exportar CSV | 0. Logout");
			System.out.print("Escolha uma opção: ");
			String op = sc.nextLine();

			if (op.equals("1")) {
				platform.getCourses().values().forEach(System.out::println);
				System.out.print("Digite o ID do curso para inverter status: ");
				try {
					int id = Integer.parseInt(sc.nextLine());
					Course c = platform.getCourses().get(id);
					if (c != null) {
						c.setStatus(c.getStatus() == Status.ACTIVE ? Status.INACTIVE : Status.ACTIVE);
						System.out.println("Status atualizado!");
					} else {
						System.out.println("Curso não encontrado com esse ID.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Erro: Digite apenas números.");
				}

			} else if (op.equals("2")) {
				System.out.print("Email do Aluno: ");
				User u = platform.login(sc.nextLine());
				if (u instanceof Student) {
					System.out.print("Novo plano (1-Basic, 2-Premium): ");
					((Student) u).setSubscriptionPlan(sc.nextLine().equals("2") ? new PremiumPlan() : new BasicPlan());
					System.out.println("Plano alterado!");
				} else {
					System.out.println("Aluno não encontrado.");
				}
			} else if (op.equals("3")) {
				SupportTicket t = platform.processNextTicket();
				if (t != null) {
					System.out.println(t);
					System.out.print("Digite a resposta para o aluno: ");
					String resposta = sc.nextLine();
					System.out.println("Ticket finalizado e removido da fila com a resposta: " + resposta);
				} else {
					System.out.println("A fila de tickets está vazia.");
				}
			} else if (op.equals("4")) {
				platform.printReports();
			} else if (op.equals("5")) {
				System.out.print("Colunas separadas por vírgula (ex: id,title,instructorName): ");
				List<String> colunas = Arrays.asList(sc.nextLine().split(","));
				System.out.println(
						"\n" + GenericCsvExporter.export(new ArrayList<>(platform.getCourses().values()), colunas));
			} else if (op.equals("0"))
				break;
		}
	}

	private static void menuStudent(Student student) {
		while (true) {
			System.out.println("\n--- MENU ALUNO: " + student.getName() + " (" + student.getSubscriptionPlan().getName()
					+ ") ---");
			System.out.println(
					"1. Catálogo | 2. Matricular | 3. Meus Cursos | 4. Atualizar Progresso | 5. Cancelar Matrícula | 6. Suporte | 0. Logout");
			System.out.print("Escolha uma opção: ");
			String op = sc.nextLine();

			if (op.equals("1")) {
				platform.getCourses().values().stream().filter(c -> c.getStatus() == Status.ACTIVE)
						.forEach(System.out::println);
			} else if (op.equals("2")) {
				System.out.print("Digite o ID do Curso: ");
				try {
					int id = Integer.parseInt(sc.nextLine());
					platform.enroll(student, id);
					System.out.println("Matrícula efetuada com sucesso!");
				} catch (NumberFormatException e) {
					System.out.println("Erro: Digite um ID numérico válido.");
				} catch (EnrollmentException e) {
					System.out.println("Erro: " + e.getMessage());
				}
			} else if (op.equals("3")) {
				if (student.getEnrollments().isEmpty())
					System.out.println("Nenhum curso matriculado.");
				else
					student.getEnrollments().forEach(e -> System.out.println("- ID: " + e.getCourse().getId() + " | "
							+ e.getCourse().getTitle() + " | Progresso: " + e.getProgress() + "%"));
			} else if (op.equals("4")) {
				System.out.print("ID do Curso: ");
				try {
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("Novo Progresso (0 a 100): ");
					double p = Double.parseDouble(sc.nextLine());
					platform.updateProgress(student, id, p);
					System.out.println("Progresso salvo!");
				} catch (NumberFormatException e) {
					System.out.println("Erro: Digite apenas números.");
				}
			} else if (op.equals("5")) {
				System.out.print("ID do Curso para cancelar: ");
				try {
					int id = Integer.parseInt(sc.nextLine());
					platform.cancelEnrollment(student, id);
					System.out.println("Matrícula cancelada!");
				} catch (NumberFormatException e) {
					System.out.println("Erro: Digite apenas números.");
				}
			} else if (op.equals("6")) {
				System.out.print("Assunto do Ticket: ");
				String titulo = sc.nextLine();
				System.out.print("Mensagem detalhada: ");
				String msg = sc.nextLine();
				platform.addTicket(new SupportTicket(titulo, msg, student));
				System.out.println("Ticket enviado para a fila!");
			} else if (op.equals("0"))
				break;
		}
	}
}