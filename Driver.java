public class Driver extends User {
    private String name;
    private String status;
    private Vehicle vehicle;
    private Order currentOrder;

    public Driver(String name, String phone, Position position, Vehicle vehicle) {
        super(phone, position);
        this.name = name;
        this.status = "AVAILABLE";
        this.vehicle = vehicle;
    }

    public void confirmOrder() {
        if (currentOrder != null) {
            currentOrder.setStatus("CONFIRMED");
            this.status = "BUSY";
        }
    }

    public void finishOrder() {
        if (currentOrder != null) {
            currentOrder.setStatus("COMPLETED");
            this.status = "AVAILABLE";
            this.currentOrder = null;
        }
    }

    public void assignOrder(Order order) {
        this.currentOrder = order;
        order.setDriver(this);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
} 