package model;
import java.util.*;

public class Student extends User {
    private PlanType subscriptionPlan;
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student(String name, String email, PlanType plan) {
        super(name, email);
        this.subscriptionPlan = plan;
    }

    public PlanType getSubscriptionPlan() { return subscriptionPlan; }
    public List<Enrollment> getEnrollments() { return enrollments; }

    public long getActiveEnrollmentCount() {
        return enrollments.stream()
                .filter(e -> e.getCourse().getStatus() == Status.ACTIVE)
                .count();
    }
}