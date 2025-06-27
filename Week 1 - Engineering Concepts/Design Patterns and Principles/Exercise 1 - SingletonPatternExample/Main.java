public class Main {
    public static void main(String[] args) {
        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();

        logger1.log("This is the first log.");
        logger2.log("This is the second log.");

        System.out.println("Same instance? " + (logger1 == logger2));
    }
}
