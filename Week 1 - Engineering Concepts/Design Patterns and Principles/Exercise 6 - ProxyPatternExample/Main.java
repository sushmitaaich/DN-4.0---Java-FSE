public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display(); // Loads and displays
        image.display(); // Displays from cache
    }
}
