package model;

public class Course {
    private String title;
    private String instructorName;
    private DifficultyLevel difficultyLevel;
    private Status status;

    public Course(String title, String instructorName, DifficultyLevel difficultyLevel, Status status) {
        this.title = title;
        this.instructorName = instructorName;
        this.difficultyLevel = difficultyLevel;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getInstructorName() { return instructorName; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public DifficultyLevel getDifficultyLevel() { return difficultyLevel; }
}
