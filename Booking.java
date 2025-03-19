public class Booking {
    private int price;
    private String time;
    private Position departure;
    private Position arrival;

    public Booking(int price, String time, Position departure, Position arrival) {
        this.price = price;
        this.time = time;
        this.departure = departure;
        this.arrival = arrival;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Position getDeparture() {
        return departure;
    }

    public void setDeparture(Position departure) {
        this.departure = departure;
    }

    public Position getArrival() {
        return arrival;
    }

    public void setArrival(Position arrival) {
        this.arrival = arrival;
    }
} 