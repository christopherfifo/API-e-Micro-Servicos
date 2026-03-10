

import model.*;
import service.PlatformService;
import util.GenericCsvExporter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PlatformService platform = new PlatformService();

        // Dados Iniciais
        platform.addCourse(new Course("Java", "Nélio", DifficultyLevel.INTERMEDIATE, Status.ACTIVE));
        platform.addUser(new Admin("Admin", "a@a.com"));
        platform.addUser(new Student("Christopher", "c@c.com", PlanType.BASIC));

        Scanner sc = new Scanner(System.in);
        System.out.println("Plataforma AcademiaDev Online");

        System.out.print("Login (email): ");
        String email = sc.nextLine();
        User user = platform.login(email);

        if (user instanceof Admin) {
            System.out.println("Bem-vindo Admin. Gerando CSV de Cursos...");
            String csv = GenericCsvExporter.export(platform.getAllCourses(), List.of("title", "instructorName"));
            System.out.println(csv);
            platform.printReports();
        } else if (user instanceof Student) {
            System.out.println("Olá Student! Cursos disponíveis: Java");
            platform.enroll((Student)user, "Java");
            System.out.println("Matrícula realizada!");
        }
    }
}