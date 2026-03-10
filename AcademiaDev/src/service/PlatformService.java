package service;

import model.*;
import exception.EnrollmentException;
import java.util.*;
import java.util.stream.Collectors;

public class PlatformService {
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Queue<String> tickets = new LinkedList<>();

    public void addCourse(Course c) { courses.put(c.getTitle(), c); }
    public void addUser(User u) { users.put(u.getEmail(), u); }
    public User login(String email) { return users.get(email); }

    public void enroll(Student s, String courseTitle) {
        Course c = courses.get(courseTitle);
        if (c == null || c.getStatus() == Status.INACTIVE) throw new EnrollmentException("Curso Inativo!");
        if (s.getSubscriptionPlan() == PlanType.BASIC && s.getActiveEnrollmentCount() >= 3)
            throw new EnrollmentException("Limite Basic excedido!");

        s.getEnrollments().add(new Enrollment(s, c));
    }

    // RELATÓRIOS USANDO STREAM API
    public void printReports() {
        System.out.println("\n--- RELATÓRIOS ---");

        // Instrutores únicos
        Set<String> instructors = courses.values().stream()
                .filter(c -> c.getStatus() == Status.ACTIVE)
                .map(Course::getInstructorName).collect(Collectors.toSet());
        System.out.println("Instrutores Ativos: " + instructors);

        // Aluno com mais matrículas
        users.values().stream()
                .filter(u -> u instanceof Student).map(u -> (Student) u)
                .max(Comparator.comparingLong(Student::getActiveEnrollmentCount))
                .ifPresent(s -> System.out.println("Top Aluno: " + s.getName()));
    }

    public List<Course> getAllCourses() { return new ArrayList<>(courses.values()); }
}