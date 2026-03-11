package model;

import java.util.*;

public class Student extends User {
	private Plan subscriptionPlan;
	private List<Enrollment> enrollments = new ArrayList<>();

	public Student(String name, String email, Plan plan) {
		super(name, email);
		this.subscriptionPlan = plan;
	}

	public Plan getSubscriptionPlan() {
		return subscriptionPlan;
	}

	public void setSubscriptionPlan(Plan plan) {
		this.subscriptionPlan = plan;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public int getActiveEnrollmentCount() {
        return (int) enrollments.stream()
                .filter(e -> e.getCourse().getStatus() == Status.ACTIVE)
                .count();
    }
}