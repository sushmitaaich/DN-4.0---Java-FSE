public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.executePayment(300.0);

        context.setStrategy(new PayPalPayment());
        context.executePayment(150.0);
    }
}
