package Collatz;

class Main {

    public static void main(String[] args) {
        //initialise counts
        int maxCount = 0;
        int loopCount = 1;
        int maxValue = 0;

        for (int value = 1; value < 1000; value++) {
            //call method
            loopCount = collatz(value);

            //determine the highest count
            if (loopCount > maxCount) {
                maxCount = loopCount;
                maxValue = value;
                //if both counts are the same
            } else if (loopCount == maxCount) {
                if (value > maxValue) {
                    //change the value to the larger one
                    maxValue = value;
                }
            }
        }

        //print out the value with the highest count
        System.out.println(maxValue);
        System.out.println(maxCount);
    }
    //method

    public static int collatz(int value) {
        //to count the number of steps
        int count = 0;
        while (value != 1) {
            if (value % 2 == 0) {
                value /= 2;
            } else {
                value = (3 * value) + 1;
            }
            count += 1;
        }
        return count;
    }
}
