public class User {
    protected String phone;
    protected Position position;

    public User(String phone, Position position) {
        this.phone = phone;
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
} 