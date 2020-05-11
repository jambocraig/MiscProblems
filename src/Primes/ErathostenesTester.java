package Primes;

import java.util.ArrayList;

/**
 *
 * @author Craig
 */
public class ErathostenesTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        step 1 - create list of integers from 2 to n
        step 2 - let p equal 2 (the first prime number)
        step 3 - Starting from p^2, count up in increments of p and mark each of 
        these numbers greater than or equal to p2 itself in the list. 
        These numbers will be p(p+1), p(p+2), p(p+3), etc.. 
        step 4 - Find the first number greater than p in the list that is 
        not marked. If there was no such number, stop. Otherwise, let p now 
        equal this number (which is the next prime), and repeat from step 3.
         */

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> marks = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();
        int n = 1_000_000;
        int p = 2;

        popIList(numbers, n);
        popMList(marks, n);

        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) != 'x') {
                mark(marks, numbers, numbers.get(i), n);
            }

        }
        //printCombined(numbers, marks);
        
        createPrimeList(numbers, marks, primes);
        System.out.println("\nPrimes");
        printIList(primes);

    }

    private static void popIList(ArrayList<Integer> numbers, int n) {
        for (int i = 2; i < n + 1; i++) {
            numbers.add(i);
        }
    }

    private static void printIList(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + "\t");
        }
    }

    private static void printMList(ArrayList<Character> marks) {
        for (Character mark : marks) {
            System.out.print(mark + "\t");
        }
    }

    private static void popMList(ArrayList<Character> marks, int n) {
        for (int j = 2; j < n + 1; j++) {
            marks.add(' ');
        }
    }

    private static void printCombined(ArrayList<Integer> numbers, ArrayList<Character> marks) {
        int length = numbers.size();
        int tester = marks.size();
        for (int i = 0; i < length; i++) {
            System.out.print(numbers.get(i) + String.valueOf(marks.get(i)) + "\t");
        }
    }

    private static void mark(ArrayList<Character> marks, ArrayList<Integer> numbers,
            int p, int n) {
        int temp = (int) Math.pow(p, 2);
        while (temp <= n) {
            marks.set(numbers.indexOf(temp), 'x');
            temp += p;
        }
    }

    private static void createPrimeList(ArrayList<Integer> numbers, ArrayList<Character> marks, ArrayList<Integer> primes) {
        for (int i = 0; i < numbers.size(); i++) {
            if (marks.get(i) == ' ') {
                primes.add(numbers.get(i));
            }
        }
    }

}
