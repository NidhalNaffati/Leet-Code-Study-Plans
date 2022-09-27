package day4;

public class Revese_String {

    public static void main(String[] args) {
        String str = "hello man i hope u are well";

        //converting the String str to  a char array because strings are a little difficult to handle as they are immutable

        char[] words = str.toCharArray();

        reverseString(words);

        System.out.println(words);

    }

/*
The approach used in Java implementation differs because strings are a little difficult to handle as they are immutable in Java.
 So, instead of using a string,
 we will convert it into a char array and find the first and last index of each word present in the sentence and reverse it.

* Traverse the given string.
 */
    public static void reverseString(char[] s) {


        int left = 0;
        int right = s.length - 1;
        char temp;

        while (left <= right) {

            if (s[left] != s[right]) {
                temp = s[right];
                s[right] = s[left];
                s[left] = temp;
            }

            right--;
            left++;
        }

    }
}

