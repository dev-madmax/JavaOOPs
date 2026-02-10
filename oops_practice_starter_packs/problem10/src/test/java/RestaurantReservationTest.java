import java.time.LocalDateTime;

public class RestaurantReservationTest {
    public static void main(String[] args) {
        try {
            // Test case 1: Creating a table with valid capacity
            Table table1 = new Table(1, 4);
            assert table1.getTableNumber() == 1 : "Table number should be 1";
            assert table1.getCapacity() == 4 : "Table capacity should be 4";
            assert table1.getReservations().isEmpty() : "New table should have no reservations";
            System.out.println("Test 1 passed: Table creation");

            // Test case 2: Creating a table with invalid capacity should throw exception
            boolean invalidCapacity = false;
            try {
                Table invalidTable = new Table(2, 1); // Below minimum capacity
            } catch (IllegalArgumentException e) {
                invalidCapacity = true;
            }
            assert invalidCapacity : "Should throw exception for capacity below minimum";
            
            invalidCapacity = false;
            try {
                Table invalidTable = new Table(3, 15); // Above maximum capacity
            } catch (IllegalArgumentException e) {
                invalidCapacity = true;
            }
            assert invalidCapacity : "Should throw exception for capacity above maximum";
            System.out.println("Test 2 passed: Table capacity validation");

            // Test case 3: Creating a reservation with valid parameters
            LocalDateTime now = LocalDateTime.now();
            Reservation reservation1 = new Reservation(3, now, 120);
            assert reservation1.getPartySize() == 3 : "Reservation party size should be 3";
            assert reservation1.getStartTime().equals(now) : "Reservation start time should match";
            assert reservation1.getDurationMinutes() == 120 : "Reservation duration should be 120 minutes";
            assert reservation1.getEndTime().equals(now.plusMinutes(120)) : "Reservation end time should be start + duration";
            System.out.println("Test 3 passed: Reservation creation");

            // Test case 4: Creating a reservation with invalid party size should throw exception
            boolean invalidPartySize = false;
            try {
                Reservation invalidRes = new Reservation(0, now, 60);
            } catch (IllegalArgumentException e) {
                invalidPartySize = true;
            }
            assert invalidPartySize : "Should throw exception for zero party size";
            
            invalidPartySize = false;
            try {
                Reservation invalidRes = new Reservation(-1, now, 60);
            } catch (IllegalArgumentException e) {
                invalidPartySize = true;
            }
            assert invalidPartySize : "Should throw exception for negative party size";
            System.out.println("Test 4 passed: Reservation party size validation");

            // Test case 5: Table availability check - initially available
            assert table1.isAvailable(now.plusHours(1), 90) : "Table should be available when no reservations exist";
            System.out.println("Test 5 passed: Initial table availability");

            // Test case 6: Making a reservation and checking availability
            table1.reserve(now.plusHours(1), 90, 3); // Reserve from now+1hr for 90 mins
            assert !table1.isAvailable(now.plusHours(1), 90) : "Table should not be available during existing reservation";
            assert table1.isAvailable(now.plusHours(3), 60) : "Table should be available outside existing reservation";
            
            // Check that reservation overlaps are properly detected
            assert !table1.isAvailable(now.plusMinutes(30), 120) : "Table should not be available for overlapping reservation (starts before, ends after)";
            assert !table1.isAvailable(now.plusHours(1).plusMinutes(30), 60) : "Table should not be available for overlapping reservation (starts during)";
            assert !table1.isAvailable(now.plusMinutes(45), 60) : "Table should not be available for overlapping reservation (ends during)";
            System.out.println("Test 6 passed: Reservation overlap detection");

            // Test case 7: Making a reservation with party size exceeding capacity should throw exception
            Table smallTable = new Table(2, 2);
            boolean capacityExceeded = false;
            try {
                smallTable.reserve(now.plusHours(2), 60, 5); // 5 people for 2-person table
            } catch (InvalidPartySizeException e) {
                capacityExceeded = true;
            }
            assert capacityExceeded : "Should throw exception when party size exceeds capacity";
            System.out.println("Test 7 passed: Capacity validation during reservation");

            // Test case 8: Making a reservation on an unavailable time should throw exception
            Table table2 = new Table(3, 6);
            table2.reserve(now.plusHours(2), 60, 4);
            
            boolean unavailable = false;
            try {
                table2.reserve(now.plusHours(2).plusMinutes(30), 45, 4); // Overlaps with existing reservation
            } catch (TableUnavailableException e) {
                unavailable = true;
            }
            assert unavailable : "Should throw exception when trying to reserve unavailable time";
            System.out.println("Test 8 passed: Availability validation during reservation");

            // Test case 9: Creating a restaurant and adding tables
            Restaurant restaurant = new Restaurant("Gourmet Corner");
            assert restaurant.toString().contains("Gourmet Corner") : "Restaurant name should match";
            
            restaurant.addTable(table1);
            restaurant.addTable(smallTable);
            restaurant.addTable(table2);
            assert restaurant.getTables().size() == 3 : "Restaurant should have 3 tables";
            System.out.println("Test 9 passed: Restaurant table management");

            // Test case 10: Finding available table
            Table availableTable = restaurant.findAvailableTable(3, now.plusHours(5), 60);
            assert availableTable != null : "Should find an available table";
            assert availableTable.getCapacity() >= 3 : "Found table should accommodate party size";
            
            // Ensure the found table is actually available
            assert availableTable.isAvailable(now.plusHours(5), 60) : "Found table should be available at requested time";
            System.out.println("Test 10 passed: Table finding functionality");

            // Test case 11: Edge case - boundary time overlap
            Table boundaryTable = new Table(4, 4);
            LocalDateTime start1 = now.plusHours(4);
            boundaryTable.reserve(start1, 60, 2); // Occupies [start1, start1+60)
            
            // A reservation that starts exactly when the previous one ends should be allowed
            assert boundaryTable.isAvailable(start1.plusMinutes(60), 30) : "Should allow reservation starting when previous ends";
            
            // A reservation that ends exactly when the next one starts should be allowed
            assert boundaryTable.isAvailable(start1.minusMinutes(30), 30) : "Should allow reservation ending when next starts";
            System.out.println("Test 11 passed: Boundary time overlap handling");

            // Test case 12: Table selection preference (smallest suitable)
            Restaurant restaurant2 = new Restaurant("Fine Dining");
            Table table4person = new Table(5, 4);
            Table table6person = new Table(6, 6);
            Table table8person = new Table(7, 8);
            
            restaurant2.addTable(table8person);
            restaurant2.addTable(table4person);
            restaurant2.addTable(table6person);
            
            // With no existing reservations, should select smallest suitable table
            Table selectedTable = restaurant2.findAvailableTable(4, now.plusHours(6), 90);
            assert selectedTable != null : "Should find a suitable table";
            assert selectedTable.getTableNumber() == 5 : "Should select smallest suitable table (4-person)";
            System.out.println("Test 12 passed: Smallest suitable table selection");

            System.out.println("All tests passed!");
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}