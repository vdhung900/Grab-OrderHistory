import java.util.ArrayList;
import java.util.List;

public class Order implements IObservable {
    private String type;
    private String status;
    private Client client;
    private Driver driver;
    private List<IObserver> observers;

    public Order() {
        this.observers = new ArrayList<>();
        this.status = "CREATED";
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        notifyObservers();
    }

    public void setClient(Client client) {
        this.client = client;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifyObservers();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }
} 