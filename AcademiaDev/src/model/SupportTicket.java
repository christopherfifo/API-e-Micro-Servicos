package model;

public class SupportTicket {
    private String title;
    private String message;
    private User creator;

    public SupportTicket(String title, String message, User creator) {
        this.title = title;
        this.message = message;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return String.format("Ticket: %s | De: %s | Mensagem: %s", title, creator.getName(), message);
    }
}