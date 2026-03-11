package model;

public class BasicPlan implements Plan {
	@Override
    public String getName() {
        return "Basic Plan";
    }

	@Override
    public boolean canEnroll(int activeEnrollments) {
        return activeEnrollments < 3;
    }
}