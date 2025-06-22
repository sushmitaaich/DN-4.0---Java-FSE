public class Forecasting {
    public static double predictValue(double current, double rate, int years) {
        if (years == 0) return current;
        return predictValue(current * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double current = 10000.0;
        double growthRate = 0.1; // 10%
        int years = 5;

        double futureValue = predictValue(current, growthRate, years);
        System.out.printf("Predicted Value after %d years: %.2f\n", years, futureValue);
    }
}
