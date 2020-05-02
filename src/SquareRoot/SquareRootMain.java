package SquareRoot;

/**
 *
 * @author Craig
 */
public class SquareRootMain {

    public static void main(String[] args) {
        double value = 2332.5645673467347;
        double tolerance = 0.0000000000000001;
        double answer = calcSqrRoot(value, tolerance);
        System.out.println("Answer = " + answer);
        System.out.println(answer * answer);
    }

    private static double calcSqrRoot(double value, double tolerance) {
        double high = value;
        double low = 0;
        double mid = (high + low) / 2;

        do {
            System.out.println(mid);
            if (mid * mid > value) {
                high = mid;
            } else if (mid * mid < value) {
                low = mid;
            }
            mid = (high + low) / 2;

        } while (mid * mid > value * (1 + tolerance) || 
                mid * mid < value * (1 - tolerance));
        return mid;
    }
}
