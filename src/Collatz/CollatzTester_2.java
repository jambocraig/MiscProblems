package Collatz;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Craig
 */
public class CollatzTester_2 {

    /**
     * @param args the command line arguments
     */
    static HashMap collMap;
    public static void main(String[] args) {
        //declare variables 
        int start = 10;
        collMap = collMap = new HashMap<>();
        collMap.put(1, 0);
        int maxSteps = -1;
        int stepValue;
        
        for (int i = 2; i <= start; i++) {
            System.out.println("Calculating for value = " + i);
            stepValue = calCollSteps(i);
            System.out.println("Step Value = " + stepValue);
            if (stepValue > maxSteps) {
                maxSteps = stepValue;
            }
        }        
        System.out.println("Maximum Steps = " + maxSteps);
    }

    private static int calCollSteps(int start) {
        int value = start;
        ArrayList<Integer> intermediateList = new ArrayList<>();
        
        System.out.println(collMap);

        int steps = 0;
        while (value != 1) {            
            if (collMap.containsKey(value)) {
                System.out.println("Found in Map");
                return (int)collMap.get(value);
            }
            intermediateList.add(value);
            steps++;
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
            System.out.println("value = " + value);
            
        }
        /*
        if (!collMap.containsKey(value)) {
            collMap.put(value, steps);
        }
*/

        for (Integer intermediate : intermediateList) {
            
            collMap.put(intermediate, steps);
            steps--;
        }

        System.out.println(collMap);
        return (int)collMap.get(start);
    }

}
