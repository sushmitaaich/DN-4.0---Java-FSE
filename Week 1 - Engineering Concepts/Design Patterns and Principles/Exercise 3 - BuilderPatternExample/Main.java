public class Main {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder()
                .setCpu("Intel i7")
                .setRam("16GB")
                .setStorage("1TB SSD")
                .build();

        pc.displaySpecs();
    }
}
