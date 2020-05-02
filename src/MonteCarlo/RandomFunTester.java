package MonteCarlo;

import static MonteCarlo.RandomStrings.*;

/**
 *
 * @author Craig
 */
public class RandomFunTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*carry out multiply runs of generating increasing fixed length random 
        words until the likelihood of the random word containing 'fun' is equal
        to or exceed 50 percent
         */
        double hitrate;
        int runs = 1000000;
        long hits;

        //set initial string size
        int size = 10;

        String word = "";
        final String sub = "fun";
        double prob = Math.pow((1.0/26), 3) * (size - 2);
        System.out.printf("Math %1.9f\n", prob);
        System.out.println(1/prob);

        
            hits = 0;
            for (int i = 0; i < runs; i++) {
                word = createLower(size);
                if (findWord(word, sub)) {
                    hits++;
                }
            }
            System.out.println("For a random string of length = " + size);
            System.out.println("hits = " + hits);
            hitrate = (double) hits / runs;
            System.out.printf("Current hit rate = %1.9f\n", hitrate);

            //increase size
            //size += 1;
        
    }
}
