public class Main {
    public static void main(String[] args) {
        // Tạo client và driver
        Client client = new Client("Nguyen Van A", "0123456789");
        Driver driver = new Driver("Tran Van B", "0987654321");
        
        // Tạo history controller
        HistoryController historyController = new HistoryController();
        
        // Client tạo order
        Order order = client.createOrder();
        order.setType("BIKE");
        
        // Thêm order vào history
        historyController.addHistoryEntry(order);
        
        // Driver nhận và xác nhận order
        order.setDriver(driver);
        order.setStatus("CONFIRMED");
        
        // Driver hoàn thành order
        order.setStatus("COMPLETED");
        
        // In lịch sử
        System.out.println("Order History:");
        historyController.printHistory();
    }
} 