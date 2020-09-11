/*
For any given array, sort the integers in an ascending order.
Looping through the array(two times simultaneously).
Subtract an item from the proceeding item:
    If the result is not 1; the missing array is between the two items,
     i.e for  [3, 5, 4, 1] the => missingInteger is 2
    If it seems all intergers are present, then the missing integer is the very next after the last,
     i.e for [1, 2, 3] => missingInteger is 4
 */

public class MissingInteger{

    // Method that sorts array items in ascending order; 
    static int[] sortItemsInArray(int[] inputArray){
        int swapVariable = 0;
            for(int items = 0; items < inputArray.length; items++){
                for(int items2 = items + 1; items2 < inputArray.length; items2++){
                    if (inputArray[items] > inputArray[items2]){
                        swapVariable=  inputArray[items];
                        inputArray[items] = inputArray[items2];
                        inputArray[items2] = swapVariable;
                    }
                }
            }
        return inputArray;
    }

    // A method that returns the missing interger
    static int missingIntegerIs(int[] sortedArray){
        int missingInt = 0;
        int loops = 0;
        while (loops < sortedArray.length) {

            if(sortedArray[0] != 1){
                missingInt = 1;
                break;
            }

            if (loops != sortedArray.length - 1 && sortedArray[loops + 1] - sortedArray[loops] != 1) {
                missingInt = sortedArray[loops] + 1;
                break;
            } else if(loops == sortedArray.length - 1){
                missingInt = sortedArray[loops] + 1;
                break;
            }
            loops++;
        }
        return missingInt;
    }


    public static void main(String[] args){
        int[] integers = {9, 4, 2, 7, 8, 6, 10, 1, 5}; // 3 is missing
        int[]sortedArray = sortItemsInArray(integers);
        int missingInteger = missingIntegerIs(sortedArray);
        System.out.println(missingInteger); // Output is 3
    }
}