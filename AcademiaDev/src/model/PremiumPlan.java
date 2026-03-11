package model;

public class PremiumPlan implements Plan {
	@Override
    public String getName() {
        return "Premium Plan";
    }
	
	
	@Override
    public boolean canEnroll(int activeEnrollments) {
        return true;
    } // ilimitado
}