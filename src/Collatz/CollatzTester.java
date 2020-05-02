package Collatz;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Craig
 */
public class CollatzTester {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //declare variables 
        int start = 1;
        HashMap<Integer, Integer> collMap = collMap = new HashMap<>();
        collMap.put(1, 0);
        
        int stepValue = calCollSteps(start, collMap);
        
        stepValue = calCollSteps(100, collMap);
    }

    private static int calCollSteps(int start, HashMap collMap) {
        int value = start;
        ArrayList<Integer> intermediateList = new ArrayList<>();
        System.out.println("Start point");
        System.out.println(collMap);

        int steps = 0;
        while (value != 1) {
            steps++;
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
            System.out.println("value = " + value);
            intermediateList.add(value);
        }
        if (!collMap.containsKey(start)) {
            collMap.put(start, steps);
        }

        for (Integer intermediate : intermediateList) {
            steps--;
            collMap.put(intermediate, steps);
        }

        System.out.println(collMap);
        return steps;
    }

}
