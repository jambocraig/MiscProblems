package Collatz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Craig
 */
public class CollatzTester_Basic4NoLookUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //getting testSet
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        ArrayList<Integer> testList = new ArrayList<>();
        int maxTest = -1;
        int testValue;
        for (int i = 0; i < no; i++) {
            testValue = sc.nextInt();
            testList.add(testValue);
            if (testValue > maxTest) {
                maxTest = testValue;
            }
        }

        //declare variables 
        HashMap<Integer, Integer> collMap = collMap = new HashMap<>();
        collMap.put(1, 0);
        int steps, maxSteps, maxValue;

        //populate the HashMap
        for (int i = 2; i <= maxTest; i++) {
            calcCollatz(i, collMap);
        }
        
        //get max from the HashMap
        for (Integer integer : testList) {
            maxSteps = -1;
            maxValue = 1;
            for (int i = 1; i <= integer; i++) {
                steps = collMap.get(i);
                if (steps >= maxSteps) {
                    maxSteps = steps;
                    maxValue = i;
                }
            }
            //System.out.println(maxSteps);
            System.out.println(maxValue);
        }
    }

    private static int calcCollatz(int start, HashMap collMap) {
        int value = start;

        int steps = 0;

        while (value != 1) {
            steps++;
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
        }

            collMap.put(start, steps);

        return (int) collMap.get(start);
    }

}
