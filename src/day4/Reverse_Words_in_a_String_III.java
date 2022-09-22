package day4;


public class Reverse_Words_in_a_String_III {

    /**
     *  557. Reverse Words in a String III
     *  https://leetcode.com/problems/reverse-words-in-a-string-iii/
     * Easy
     *
     * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Example 2:
     *
     * Input: s = "God Ding"
     * Output: "doG gniD"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 5 * 104
     * s contains printable ASCII characters.
     * s does not contain any leading or trailing spaces.
     * There is at least one word in s.
     * All the words in s are separated by a single space.
     */


    public static void main(String[] args) {
        String s1 = "lets get a leet code challanges";
        System.out.println(s1);
        System.out.println(reverseWords(s1));

        String s2  = "God Ding" ;
        System.out.println(s2);
        System.out.println(reverseWords(s2));

    }


    //after knowing the first index of the word and the last one
    // we call the reverseGivenWord() to reverse that word
    public static String reverseWords(String s) {

        if (s.length() == 1)
            return s;

        char[] words = s.toCharArray();

        int firstIndexOfTheWord = 0;
        int lastIndexOfTheWord ;

        for (int i = 1; i < s.length(); i++) {

            if (words[i] == ' ') {

                lastIndexOfTheWord = i - 1;

                reverseGivenWord(words, firstIndexOfTheWord, lastIndexOfTheWord);

                firstIndexOfTheWord = i + 1;
            }
        }

        reverseGivenWord(words,firstIndexOfTheWord,s.length()-1);


        return String.valueOf(words) ;

    }


    //this method reverse a given word
    public static void reverseGivenWord(char[] word, int left, int right) {

        char temp;

        while (left <= right) {

            if (word[left] != word[right]) {
                temp = word[right];
                word[right] = word[left];
                word[left] = temp;
            }

            right--;
            left++;
        }
    }
}
