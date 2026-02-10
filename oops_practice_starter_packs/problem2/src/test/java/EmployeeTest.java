public class EmployeeTest {
    public static void main(String[] args) {
        // Test case 1: Create FullTimeEmployee and verify salary calculation
        FullTimeEmployee ftEmp = new FullTimeEmployee(1, "John Doe", "john@example.com", 60000);
        assert ftEmp.calculateSalary() == 5000.0 : "Monthly salary should be 5000.0";
        assert ftEmp.getName().equals("John Doe") : "Name should be John Doe";
        System.out.println("Test 1 passed: Full-time employee creation and salary calculation");

        // Test case 2: Create PartTimeEmployee and verify salary calculation
        PartTimeEmployee ptEmp = new PartTimeEmployee(2, "Jane Smith", "jane@example.com", 25.0, 80);
        assert ptEmp.calculateSalary() == 2000.0 : "Part-time salary should be 2000.0 (25 * 80)";
        assert ptEmp.getEmail().equals("jane@example.com") : "Email should match";
        System.out.println("Test 2 passed: Part-time employee creation and salary calculation");

        // Test case 3: Verify toString methods
        String ftStr = ftEmp.toString();
        assert ftStr.contains("John Doe") : "toString should contain employee name";
        assert ftStr.contains("5000.0") : "toString should contain calculated salary";
        
        String ptStr = ptEmp.toString();
        assert ptStr.contains("Jane Smith") : "toString should contain employee name";
        assert ptStr.contains("2000.0") : "toString should contain calculated salary";
        System.out.println("Test 3 passed: toString methods");

        // Test case 4: Modify employee information
        ftEmp.setEmail("john.doe@example.com");
        assert ftEmp.getEmail().equals("john.doe@example.com") : "Email should be updated";
        System.out.println("Test 4 passed: Employee information update");

        // Test case 5: Edge case - zero hour part-time employee
        PartTimeEmployee zeroHourEmp = new PartTimeEmployee(3, "Bob Johnson", "bob@example.com", 30.0, 0);
        assert zeroHourEmp.calculateSalary() == 0.0 : "Zero hour employee should have zero salary";
        System.out.println("Test 5 passed: Zero hour part-time employee");

        System.out.println("All tests passed!");
    }
}