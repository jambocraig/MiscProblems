package SquareRoot;

/**
 *
 * @author Craig
 */
public class SquareRootMainVersion2 {
    public static void main(String[] args) {
        double value = 332.564567346734745; 
        double answer = calcSqrRoot(value);
        System.out.println("Answer = " + answer);
        System.out.println(answer * answer);       
        
    }

    private static double calcSqrRoot(double value) {
        double high = value;
        double low = 0;
        double mid = (high + low)/2;
                
        do {       
            System.out.println(mid);
            if (mid * mid > value) {
                high = mid;
            } else if (mid * mid < value){
                low = mid;
            }
            mid = (high + low)/2;
            
        } while (mid * mid != value);    
    return mid;
    }
}
