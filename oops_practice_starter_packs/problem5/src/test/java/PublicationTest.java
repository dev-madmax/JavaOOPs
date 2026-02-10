public class PublicationTest {
    public static void main(String[] args) {
        // Test case 1: Create Book and verify properties
        Book book = new Book("B001", "Java Programming", "John Smith", "2022-01-15", "ISBN123456", 500);
        assert book.getPublicationType().equals("Book") : "Book should return 'Book' as publication type";
        assert book.getTitle().equals("Java Programming") : "Book title should match";
        assert book.getIsbn().equals("ISBN123456") : "Book ISBN should match";
        assert book.getNumberOfPages() == 500 : "Book page count should match";
        System.out.println("Test 1 passed: Book creation and properties");

        // Test case 2: Create Magazine and verify properties
        Magazine magazine = new Magazine("M001", "Tech Today", "Tech Publications", "2022-02-01", 45);
        assert magazine.getPublicationType().equals("Magazine") : "Magazine should return 'Magazine' as publication type";
        assert magazine.getIssueNumber() == 45 : "Magazine issue number should match";
        System.out.println("Test 2 passed: Magazine creation and properties");

        // Test case 3: Create Newspaper and verify properties
        Newspaper newspaper = new Newspaper("N001", "Daily News", "News Corp", "2022-02-10", 50000);
        assert newspaper.getPublicationType().equals("Newspaper") : "Newspaper should return 'Newspaper' as publication type";
        assert newspaper.getCirculation() == 50000 : "Newspaper circulation should match";
        System.out.println("Test 3 passed: Newspaper creation and properties");

        // Test case 4: Polymorphism - store publications in array and call methods
        Publication[] publications = {
            new Book("B002", "Python Guide", "Jane Doe", "2022-03-01", "ISBN987654", 400),
            new Magazine("M002", "Science Weekly", "Science Inc", "2022-03-05", 22),
            new Newspaper("N002", "City Herald", "Herald Publishing", "2022-03-10", 30000)
        };
        
        for (Publication pub : publications) {
            String type = pub.getPublicationType();
            assert type != null && !type.isEmpty() : "Publication type should not be null or empty";
            
            String str = pub.toString();
            assert str != null && !str.isEmpty() : "toString should return valid string";
        }
        System.out.println("Test 4 passed: Polymorphism verification");

        // Test case 5: Verify toString methods return meaningful information
        String bookStr = book.toString();
        assert bookStr.contains("Java Programming") : "Book toString should contain title";
        assert bookStr.contains("John Smith") : "Book toString should contain author";
        
        String magStr = magazine.toString();
        assert magStr.contains("Tech Today") : "Magazine toString should contain title";
        assert magStr.contains("45") : "Magazine toString should contain issue number";
        
        String newsStr = newspaper.toString();
        assert newsStr.contains("Daily News") : "Newspaper toString should contain title";
        assert newsStr.contains("50000") : "Newspaper toString should contain circulation";
        System.out.println("Test 5 passed: toString methods");

        System.out.println("All tests passed!");
    }
}