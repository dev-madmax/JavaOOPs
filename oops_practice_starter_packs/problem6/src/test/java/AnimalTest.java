public class AnimalTest {
    public static void main(String[] args) {
        // Test case 1: Create Dog and verify properties and sound
        Dog dog = new Dog("D001", "Buddy", 3, "Golden Retriever", true);
        assert dog.makeSound().equals("Woof!") : "Dog should make 'Woof!' sound";
        assert dog.getName().equals("Buddy") : "Dog name should match";
        assert dog.isTrained() : "Dog should be trained according to constructor";
        System.out.println("Test 1 passed: Dog creation and properties");

        // Test case 2: Create Cat and verify properties and sound
        Cat cat = new Cat("C001", "Whiskers", 2, "Persian", true);
        assert cat.makeSound().equals("Meow!") : "Cat should make 'Meow!' sound";
        assert cat.getAge() == 2 : "Cat age should match";
        assert cat.isIndoor() : "Cat should be indoor according to constructor";
        System.out.println("Test 2 passed: Cat creation and properties");

        // Test case 3: Create Bird and verify properties and sound
        Bird bird = new Bird("B001", "Tweety", 1, "Canary", true);
        assert bird.makeSound().equals("Tweet!") : "Bird should make 'Tweet!' sound";
        assert bird.getBreed().equals("Canary") : "Bird breed should match";
        assert bird.canFly() : "Bird should be able to fly according to constructor";
        System.out.println("Test 3 passed: Bird creation and properties");

        // Test case 4: Polymorphism - store animals in array and call methods
        Animal[] animals = {
            new Dog("D002", "Max", 5, "Labrador", false),
            new Cat("C002", "Fluffy", 4, "Maine Coon", false),
            new Bird("B002", "Robin", 2, "Robin", true)
        };
        
        for (Animal animal : animals) {
            String sound = animal.makeSound();
            assert sound != null && !sound.isEmpty() : "Animal sound should not be null or empty";
            
            String str = animal.toString();
            assert str != null && !str.isEmpty() : "toString should return valid string";
        }
        System.out.println("Test 4 passed: Polymorphism verification");

        // Test case 5: Verify toString methods return meaningful information
        String dogStr = dog.toString();
        assert dogStr.contains("Buddy") : "Dog toString should contain name";
        assert dogStr.contains("Golden Retriever") : "Dog toString should contain breed";
        
        String catStr = cat.toString();
        assert catStr.contains("Whiskers") : "Cat toString should contain name";
        assert catStr.contains("Persian") : "Cat toString should contain breed";
        
        String birdStr = bird.toString();
        assert birdStr.contains("Tweety") : "Bird toString should contain name";
        assert birdStr.contains("Canary") : "Bird toString should contain breed";
        System.out.println("Test 5 passed: toString methods");

        System.out.println("All tests passed!");
    }
}