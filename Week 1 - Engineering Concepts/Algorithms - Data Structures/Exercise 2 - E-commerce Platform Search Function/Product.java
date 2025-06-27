public class Product {
    String productId;
    String productName;
    String category;

    public Product(String id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return productId + ": " + productName + " [" + category + "]";
    }
}
