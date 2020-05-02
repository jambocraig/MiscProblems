
package DailyProblems;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Craig
 */
public class CoinToss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Average Rounds = 8.338335196
        Average Toss = 255.999974371
        BUILD SUCCESSFUL (total time: 46 minutes 7 seconds)
        */
        long totalRounds = 0L;
        long totalToss = 0L;
        double averageRounds;
        double averageToss;
        int n = 128;
        int tests = 1_000_000_000;
        
        for (int i = 0; i < tests; i++) {
            int[] dataArr;

            dataArr = calculateToss(n);
            //System.out.println(Arrays.toString(dataArr));
            totalRounds += dataArr[0];
            totalToss += dataArr[1];
        }
        averageRounds = (double)totalRounds/tests;
        averageToss = (double)totalToss/tests;
        
        System.out.println("Average Rounds = " + averageRounds);
        System.out.println("Average Toss = " + averageToss);        
    }

    private static int[] calculateToss(int n) {
        int[] dataArr = {0, 0}; 
        Random rn = new Random();
        int rounds = 0;
        int toss = 0;
        
        int coin;
        
        while (n > 0) {
            coin = 0;
            rounds++;
            for (int i = 0; i < n; i++) {
                toss++;
                coin += rn.nextInt(2);
            }
            n -= coin;
        }
        //System.out.println("Rounds = " + rounds);
        //System.out.println("Coin Toss = " + toss);
        dataArr[0] = rounds;
        dataArr[1] = toss;
        return dataArr;
    }
    
}
