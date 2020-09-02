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

    // Method that sorts array items in ascending order; and returns the missing interger
    static int sortItemsInArray(int[] inputArray){
        int missingValue = 0;
        int swapVariable = 0;
            for(int items = 0; items < inputArray.length; items++){
                for(int items2 = items + 1; items2 < inputArray.length; items2++){
                    if (inputArray[items] > inputArray[items2]){
                        swapVariable=  inputArray[items];
                        inputArray[items] = inputArray[items2];
                        inputArray[items2] = swapVariable;

                        missingValue = inputArray[inputArray.length - 1] + 1;

                        if(inputArray[items2] - inputArray[items] != 1){
                            missingValue = inputArray[items] + 1;
                        }
                    }
                }
            }
            
        return missingValue;
    }


    public static void main(String[] args){
        int[] integers = {3, 5, 4, 1};
        System.out.println(sortItemsInArray(integers));
    }
}