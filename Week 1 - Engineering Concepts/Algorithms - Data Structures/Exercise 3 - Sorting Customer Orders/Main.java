public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O1", "Alice", 250.0),
            new Order("O2", "Bob", 150.0),
            new Order("O3", "Charlie", 500.0)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        System.out.println("\nBubble Sort:");
        SortingAlgorithms.bubbleSort(orders);
        for (Order o : orders) System.out.println(o);

        System.out.println("\nQuick Sort:");
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) System.out.println(o);
    }
}
