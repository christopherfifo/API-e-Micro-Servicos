package model;

public interface Plan {
    String getName();

    boolean canEnroll(int activeEnrollments);
}