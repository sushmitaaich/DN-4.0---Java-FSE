public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("P101", "Monitor", 15, 7999.0));
        manager.addProduct(new Product("P102", "Keyboard", 30, 1499.0));
        manager.addProduct(new Product("P103", "Mouse", 50, 499.0));

        System.out.println("Initial Inventory:");
        manager.displayInventory();

        System.out.println("\nUpdating P103...");
        manager.updateProduct("P103", 60, 450.0);
        manager.displayInventory();

        System.out.println("\nDeleting P102...");
        manager.deleteProduct("P102");
        manager.displayInventory();
    }
}
