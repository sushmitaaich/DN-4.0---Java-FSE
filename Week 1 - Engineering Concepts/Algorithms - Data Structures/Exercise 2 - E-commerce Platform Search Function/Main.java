public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("101", "Shoes", "Footwear"),
            new Product("102", "Shirt", "Apparel"),
            new Product("103", "Mobile", "Electronics")
        };

        int idx1 = SearchAlgorithms.linearSearch(products, "Shirt");
        System.out.println("Linear Search Result: " + (idx1 >= 0 ? products[idx1] : "Not Found"));

        int idx2 = SearchAlgorithms.binarySearch(products, "Mobile");
        System.out.println("Binary Search Result: " + (idx2 >= 0 ? products[idx2] : "Not Found"));
    }
}
