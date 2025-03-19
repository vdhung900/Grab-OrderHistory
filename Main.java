import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input personal information
        System.out.println("=== Personal Information ===");
        System.out.print("Name: ");
        String clientName = scanner.nextLine();
        System.out.print("Phone: ");
        String clientPhone = scanner.nextLine();
        
        // Input locations
        System.out.println("\n=== Trip Information ===");
        System.out.println("Enter pickup location:");
        System.out.print("Address: ");
        String departureAddress = scanner.nextLine();
        
        System.out.println("\nEnter destination:");
        System.out.print("Address: ");
        String arrivalAddress = scanner.nextLine();
        
        // Get pickup time
        System.out.print("\nEnter pickup time (e.g., 14:30): ");
        String time = scanner.nextLine();
        
        // Select vehicle type
        System.out.println("\n=== Vehicle Selection ===");
        System.out.println("1. Bike");
        System.out.println("2. Car");
        System.out.print("Your choice (1-2): ");
        int vehicleChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        // Calculate estimated price based on vehicle type and distance (simplified)
        int basePrice = (vehicleChoice == 1) ? 10000 : 20000; // Base price for bike/car
        int estimatedPrice = basePrice * 2; // Simplified price calculation
        
        System.out.println("\nEstimated Price: " + estimatedPrice + " VND");
        System.out.print("Do you accept the price? (yes/no): ");
        String acceptance = scanner.nextLine();
        
        if (acceptance.equalsIgnoreCase("yes")) {
            // Create positions
            Position clientPos = new Position(departureAddress);
            Position driverPos = new Position("456 Le Van Viet Street"); // Simulated driver position
            
            // Create client
            Client client = new Client(clientName, clientPhone, clientPos);
            
            // Create driver with selected vehicle
            Vehicle vehicle = (vehicleChoice == 1) ? new Bike() : new Car();
            Driver driver = new Driver("John Driver", "+1234567890", driverPos, vehicle);
            
            // Create history controller
            HistoryController historyController = new HistoryController();
            
            // Create and initialize order
            System.out.println("\n=== Creating Order ===");
            Order order = client.createOrder();
            order.setType(vehicle.getType());
            historyController.addHistoryEntry(order);
            
            // Driver accepts order
            System.out.println("\n=== Driver Accepts Order ===");
            driver.assignOrder(order);
            historyController.printHistory();
            
            // Create booking record
            System.out.println("\n=== Booking Details ===");
            Position departure = new Position(departureAddress);
            Position arrival = new Position(arrivalAddress);
            Booking booking = new Booking(estimatedPrice, time, departure, arrival);
            client.book(booking);
            
            // Show booking summary
            System.out.println("\n=== Booking Summary ===");
            System.out.println("Customer: " + clientName);
            System.out.println("Phone: " + clientPhone);
            System.out.println("From: " + departureAddress);
            System.out.println("To: " + arrivalAddress);
            System.out.println("Pickup Time: " + time);
            System.out.println("Vehicle: " + vehicle.getType());
            System.out.println("Price: " + estimatedPrice + " VND");
            
            // Driver confirms after seeing booking details
            System.out.println("\n=== Driver Confirms Order ===");
            driver.confirmOrder();
            historyController.printHistory();
            
            // Simulate trip completion
            System.out.println("\n=== Trip Completed ===");
            driver.finishOrder();
            historyController.printHistory();
            
            System.out.println("\nBooking completed successfully!");
        } else {
            System.out.println("\nOrder cancelled by user.");
        }
        
        scanner.close();
    }
}