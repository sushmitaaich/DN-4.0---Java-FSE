public class AppLogger {
    private static AppLogger instance;

    private AppLogger() {
        System.out.println("Logger initialized.");
    }

    public static AppLogger getInstance() {
        if (instance == null) {
            instance = new AppLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

