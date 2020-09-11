/*
Loop through the string items
Append each character to a temporary variable until they are four characters
For every complete temporary variable, add it to an array, and then soon after empty the temporary variable
In the Array:
Loop through the items (strings) in the array
For every item, reverse the order of the characters
Put them in another array
From the items in this new array, make a statement of reversed  characters in groups of four.
*/

import java.lang.Math;

public class ReverseCharacters {

    /*
    Method that:
    1. Groups string into 4s and appends in an array
    2. Takes every string from the array and reverses its characters
    3. Appends the revesed array strings in another array
    4. Takes the new array items and places in a single sentence.
    */
    static String reverseCharacters(String stringValue){
        String groupOfFour = "";
        int numberOfPossibleGroupsInString = (int) Math.ceil(stringValue.length() / 4);
        String[] arrayOfGouppedStrings = new String[(int) numberOfPossibleGroupsInString];
        int index2 = 0;
        for (int index = 0; index < stringValue.length(); index++){
            groupOfFour += stringValue.charAt(index);
            if (groupOfFour.length() == 4){
                index2 += 3;
                arrayOfGouppedStrings[index - index2] = groupOfFour;
                groupOfFour = "";
            }
            if (groupOfFour.length() < 4 && index == (stringValue.length() - 1)){
                break;
            }
        }

        String reversedGroupOfFour = "";
        String[] arrayOfReversedStrings = new String[numberOfPossibleGroupsInString];

        for (int index = 0; index < arrayOfGouppedStrings.length; index++){
            String eachItem = arrayOfGouppedStrings[index];
            int charsInString = 3;
            while (charsInString >= 0) {
                reversedGroupOfFour += eachItem.charAt(charsInString);
                if (reversedGroupOfFour.length() == 4){
                    arrayOfReversedStrings[index] = reversedGroupOfFour;
                    reversedGroupOfFour = "";
                }
                charsInString--;
            }
        }

        String newSentence = "";
        for(String thestrings : arrayOfReversedStrings){
            newSentence += thestrings;
        }
        
        System.out.println(newSentence);
        return newSentence;
    }
    

    // Main method
    public static void main(String[] args) {
        // String  aStringS= "They are new every morning!!";
        String  aStringS= "Lorem at";
        reverseCharacters(aStringS);
    }
}