public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "Data Structures", "John Doe"),
            new Book("B002", "Algorithms", "Jane Smith"),
            new Book("B003", "Java Programming", "James Brown")
        };

        int idx1 = BookSearch.linearSearch(books, "Algorithms");
        System.out.println("Linear Search: " + (idx1 >= 0 ? books[idx1] : "Not Found"));

        int idx2 = BookSearch.binarySearch(books, "Java Programming");
        System.out.println("Binary Search: " + (idx2 >= 0 ? books[idx2] : "Not Found"));
    }
}
