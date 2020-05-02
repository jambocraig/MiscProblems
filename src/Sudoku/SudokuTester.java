package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Craig
 */
public class SudokuTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] mainArr = new int[9][9];

        Random rn = new Random();
           
        ArrayList <Integer> valueList = new ArrayList<>();
     
        popList(valueList);
        System.out.println(valueList);
        
        
        int position;
        int shift = 0;
        for (int k = 0; k < 3; k++) {
            for (int i = shift; i < shift + 3; i++) {
                for (int j = 0; j < 3; j++) {
                    position = rn.nextInt(valueList.size());
                    mainArr[i][j] = valueList.remove(position);
                }
            }
            popList(valueList);
            shift += 3;
        }
        printGrid(mainArr);
    
    }

    private static void printGrid(int[][] mainArr) {
        for (int[] is : mainArr) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void popList(ArrayList<Integer> valueList) {
        for (int i = 1; i < 10; i++) {
            valueList.add(i);
        }
    }

}
