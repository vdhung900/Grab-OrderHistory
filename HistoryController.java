import java.util.ArrayList;
import java.util.List;

public class HistoryController implements IObserver {
    private List<HistoryEntry> history;
    private Order observedOrder;

    public HistoryController() {
        this.history = new ArrayList<>();
    }

    public void addHistoryEntry(Order order) {
        if (this.observedOrder != order) {
            this.observedOrder = order;
            order.registerObserver(this);
        }
        String message = String.format("Order status changed to: %s", order.getStatus());
        history.add(new HistoryEntry(message));
    }

    @Override
    public void update() {
        if (observedOrder != null) {
            addHistoryEntry(observedOrder);
        }
    }

    public List<HistoryEntry> getHistory() {
        return new ArrayList<>(history);
    }

    public void printHistory() {
        for (HistoryEntry entry : history) {
            System.out.println(entry);
        }
    }
} 