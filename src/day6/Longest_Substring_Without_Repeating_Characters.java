package day6;

import java.util.HashMap;

/**
 3. Longest Substring Without Repeating Characters
 Medium
 https://leetcode.com/problems/longest-substring-without-repeating-characters/

 Given a string s, find the length of the longest substring without repeating characters.

 Example 1:
 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:
 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


 Constraints:
 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.
 */

public class Longest_Substring_Without_Repeating_Characters {

    /*
    Runtime: 6 ms, faster than 88.72% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 42 MB, less than 99.38% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public static void main(String[] args) {
        String testString = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(testString));
    }

    static int lengthOfLongestSubstring(String s) {

        // we can check if String is empty so we return 0 as LongestSubstring.
        if (s.length() == 0) return 0;

        int maxLength = 0;

        // we use HashMap to store each character as key & their index as value.
        HashMap<Character, Integer> visitedCharacters = new HashMap<>();

        //looping through the string
        for (int left = 0, right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);

            // we should make sure if our currentCharacter is within the map.
            // also we should check if it is with the SubString.

            // if so we need to move the left pointer one step to the right.
            if (visitedCharacters.containsKey(currentCharacter) && visitedCharacters.get(currentCharacter) >= left) {
                left = visitedCharacters.get(currentCharacter) + 1;
            }

            // if isn't we can calculate the longestSUbString & put the currentCharacter in the map.
            maxLength = Math.max(maxLength, right - left + 1);
            visitedCharacters.put(currentCharacter, right);
        }
        return maxLength;
    }


    // These problems are easy to solve using a brute force approach in O(n^2) or O(n^3).
    // Using the 'sliding window' technique, we can reduce the time complexity to O(n).
    // for more information about 'sliding window' read this article from stackoverflow.
    // https://stackoverflow.com/questions/8269916/what-is-sliding-window-algorithm-examples


}