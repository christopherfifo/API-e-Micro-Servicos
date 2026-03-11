package util;

import model.*;
import service.PlatformService;

public class InitialData {
    public static void populate(PlatformService ps) {
        ps.addCourse(new Course("Java Core", "Base do Java", "Nélio Alves", 40, DifficultyLevel.INTERMEDIATE, Status.ACTIVE));
        ps.addCourse(new Course("React JS", "Frontend WEB", "Diego F.", 30, DifficultyLevel.BEGINNER, Status.ACTIVE));
        ps.addCourse(new Course("Spring Boot", "APIs Rest", "Nélio Alves", 50, DifficultyLevel.ADVANCED, Status.INACTIVE));

        ps.addUser(new Admin("Admin Mestre", "admin@dev.com"));
        ps.addUser(new Student("Christopher", "chris@dev.com", new BasicPlan()));
        ps.addUser(new Student("João Premium", "joao@dev.com", new PremiumPlan()));
    }
}