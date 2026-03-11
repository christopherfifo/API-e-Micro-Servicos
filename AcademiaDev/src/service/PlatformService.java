package service;

import model.*;
import exception.EnrollmentException;
import java.util.*;
import java.util.stream.Collectors;

public class PlatformService {
	private Map<Integer, Course> courses = new HashMap<>();
	private Map<String, User> users = new HashMap<>();
	private Queue<SupportTicket> tickets = new LinkedList<>();

	public void addCourse(Course c) {
		courses.put(c.getId(), c);
	}

	public void addUser(User u) {
		users.put(u.getEmail(), u);
	}

	public User login(String email) {
		return users.get(email);
	}

	public Map<Integer, Course> getCourses() {
		return courses;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void addTicket(SupportTicket t) {
		tickets.add(t);
	}

	public SupportTicket processNextTicket() {
		return tickets.poll();
	}

	public void enroll(Student s, int courseId) {
		Course c = courses.get(courseId);
		if (c == null || c.getStatus() == Status.INACTIVE)
			throw new EnrollmentException("Curso inativo ou não existe.");
		if (!s.getSubscriptionPlan().canEnroll(s.getActiveEnrollmentCount()))
			throw new EnrollmentException("Limite do plano atingido.");
		if (s.getEnrollments().stream().anyMatch(e -> e.getCourse().getId() == courseId))
			throw new EnrollmentException("Já matriculado neste curso.");

		s.getEnrollments().add(new Enrollment(s, c));
	}

	public void cancelEnrollment(Student s, int courseId) {
		s.getEnrollments().removeIf(e -> e.getCourse().getId() == courseId);
	}

	public void updateProgress(Student s, int courseId, double progress) {
		s.getEnrollments().stream().filter(e -> e.getCourse().getId() == courseId).findFirst()
				.ifPresent(e -> e.setProgress(progress));
	}

	// --- RELATÓRIOS (STREAM API) ---
	public void printReports() {
		System.out.println("\n--- RELATÓRIOS ANALÍTICOS ---");

		List<Course> intermediateCourses = courses.values().stream()
				.filter(c -> c.getDifficultyLevel() == DifficultyLevel.INTERMEDIATE)
				.sorted(Comparator.comparing(Course::getTitle)).collect(Collectors.toList());
		System.out.println("Cursos INTERMEDIATE (Ordenados): "
				+ intermediateCourses.stream().map(Course::getTitle).collect(Collectors.joining(", ")));

		Set<String> uniqueInstructors = courses.values().stream().filter(c -> c.getStatus() == Status.ACTIVE)
				.map(Course::getInstructorName).collect(Collectors.toSet());
		System.out.println("Instrutores Ativos: " + uniqueInstructors);

		Map<String, List<Student>> studentsByPlan = users.values().stream().filter(u -> u instanceof Student)
				.map(u -> (Student) u).collect(Collectors.groupingBy(s -> s.getSubscriptionPlan().getName()));
		System.out.println("Alunos por Plano: ");
		studentsByPlan.forEach((plan, list) -> System.out
				.println("  " + plan + ": " + list.stream().map(User::getName).collect(Collectors.joining(", "))));

		double avgProgress = users.values().stream().filter(u -> u instanceof Student)
				.flatMap(u -> ((Student) u).getEnrollments().stream()).mapToDouble(Enrollment::getProgress).average()
				.orElse(0.0);
		System.out.println(String.format("Média Geral de Progresso: %.2f%%", avgProgress));

		Optional<Student> topStudent = users.values().stream().filter(u -> u instanceof Student).map(u -> (Student) u)
				.max(Comparator.comparingInt(Student::getActiveEnrollmentCount));
		topStudent.ifPresent(s -> System.out.println("Aluno com mais matrículas ativas: " + s.getName()));
	}
}