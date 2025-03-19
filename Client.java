public class Client extends User {
    private String name;

    public Client(String name, String phone, Position position) {
        super(phone, position);
        this.name = name;
    }

    public Order createOrder() {
        Order order = new Order();
        order.setClient(this);
        return order;
    }

    public void book(Booking booking) {
        // Booking logic for client
        System.out.println("Booking confirmed for departure: " + booking.getDeparture().getAddress() 
            + " to arrival: " + booking.getArrival().getAddress());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} 