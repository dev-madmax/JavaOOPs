public class VehicleTest {
    public static void main(String[] args) {
        // Test case 1: Create Car and verify rental cost calculation
        Car car = new Car("CAR001", "Camry", "Toyota", 50.0, 4);
        double carCost = car.calculateRentalCost(3); // 50 * 3 = 150
        assert carCost == 150.0 : "Car rental cost should be base rate * days";
        System.out.println("Test 1 passed: Car rental cost calculation");

        // Test case 2: Create Motorcycle and verify rental cost calculation
        Motorcycle bike = new Motorcycle("MOTO001", "Ninja", "Kawasaki", 30.0, 600);
        double bikeCost = bike.calculateRentalCost(2); // 30 * 2 = 60
        assert bikeCost == 60.0 : "Motorcycle rental cost should be base rate * days";
        System.out.println("Test 2 passed: Motorcycle rental cost calculation");

        // Test case 3: Create Truck and verify rental cost calculation
        Truck truck = new Truck("TRK001", "F-150", "Ford", 80.0, 1000);
        double truckCost = truck.calculateRentalCost(4); // 80 * 4 + additional fees
        // Assuming additional fee is $10 per 100 units of cargo capacity
        double expectedTruckCost = 80 * 4 + (1000 / 100) * 10; // 320 + 100 = 420
        assert truckCost == expectedTruckCost : "Truck rental cost should include additional fees";
        System.out.println("Test 3 passed: Truck rental cost calculation");

        // Test case 4: Polymorphism - store vehicles in Vehicle array and call methods
        Vehicle[] vehicles = {
            new Car("CAR002", "Civic", "Honda", 45.0, 2),
            new Motorcycle("MOTO002", "R1", "Yamaha", 35.0, 1000),
            new Truck("TRK002", "Silverado", "Chevy", 85.0, 1500)
        };
        
        for (Vehicle v : vehicles) {
            double cost = v.calculateRentalCost(5);
            assert cost > 0 : "Rental cost should be positive";
            
            String str = v.toString();
            assert str != null && !str.isEmpty() : "toString should return valid string";
        }
        System.out.println("Test 4 passed: Polymorphism verification");

        // Test case 5: Verify individual vehicle properties
        assert car.getDoors() == 4 : "Car should have 4 doors";
        assert bike.getEngineCapacity() == 600 : "Bike should have 600cc engine";
        assert truck.getCargoCapacity() == 1000 : "Truck should have 1000 unit cargo capacity";
        System.out.println("Test 5 passed: Individual vehicle properties");

        System.out.println("All tests passed!");
    }
}