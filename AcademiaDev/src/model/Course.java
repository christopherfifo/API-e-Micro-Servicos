package model;

public class Course {
	private static int idCounter = 1;
	private int id;
	private String title, description, instructorName;
	private int durationInHours;
	private DifficultyLevel difficultyLevel;
	private Status status;

	public Course(String title, String description, String instructorName, int durationInHours,
			DifficultyLevel difficultyLevel, Status status) {
		this.id = idCounter++;
		this.title = title;
		this.description = description;
		this.instructorName = instructorName;
		this.durationInHours = durationInHours;
		this.difficultyLevel = difficultyLevel;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("ID: %d | [%s] %s (%s) - %dh", id, status, title, difficultyLevel, durationInHours);
	}
}
