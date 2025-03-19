import java.time.LocalDateTime;

public class HistoryEntry {
    private LocalDateTime time;
    private String message;

    public HistoryEntry(String message) {
        this.time = LocalDateTime.now();
        this.message = message;
    }

    // Getters
    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", time.toString(), message);
    }
} 