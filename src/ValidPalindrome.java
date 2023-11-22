import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a> <br>
 * Easy <br>
 * <br>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers. <br>
 * <br>
 * Given a string s, return true if it is a palindrome, or false otherwise. <br>
 * <br>
 * Example 1: <br>
 * Input: s = "A man, a plan, a canal: Panama" <br>
 * Output: true <br>
 * Explanation: "amanaplanacanalpanama" is a palindrome. <br>
 * <br>
 * Example 2: <br>
 * Input: s = "race a car" <br>
 * Output: false <br>
 * Explanation: "raceacar" is not a palindrome. <br>
 * <br>
 * Example 3: <br>
 * Input: s = " " <br>
 * Output: true <br>
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome. <br>
 * <br>
 * Constraints: <br>
 * 1 <= s.length <= 2 * 10^5 <br>
 * s consists only of printable ASCII characters. <br>
 */

public class ValidPalindrome {

    /**
     * <p>
     * The <code>isPalindrome</code> method checks if a given phrase is a palindrome after cleaning it. A phrase is considered
     * a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward.
     * </p>
     *
     * <p>
     * <strong>Approach:</strong>
     * </p>
     * <ol>
     *   <li><strong>Clean the Phrase:</strong>
     *       <ul>
     *           <li>Non-alphanumeric characters are removed using the regular expression <code>[^a-zA-Z0-9]</code>.</li>
     *           <li>The resulting string is converted to lowercase to ensure case-insensitive comparison.</li>
     *       </ul>
     *   </li>
     *
     *   <li><strong>Two-Pointer Technique:</strong>
     *       <ul>
     *           <li>Two pointers, <code>leftPointer</code> and <code>rightPointer</code>, are used to iterate through the cleaned string.</li>
     *           <li>The pointers start from the two ends of the string and move towards the center.</li>
     *           <li>At each step, the characters at the pointers are compared.</li>
     *           <li>If the characters are not equal, the method returns <code>false</code> as the phrase is not a palindrome.</li>
     *           <li>The iteration continues until the pointers meet in the middle.</li>
     *       </ul>
     *   </li>
     *
     *   <li><strong>Return Result:</strong>
     *       <ul>
     *           <li>If the entire iteration is completed without finding any unequal characters, the method returns <code>true</code>,
     *               indicating that the original phrase is a palindrome.</li>
     *       </ul>
     *   </li>
     * </ol>
     *
     * <p>
     * <strong>Time Complexity Analysis:</strong>
     * </p>
     * <ul>
     *   <li>The time complexity is <code>O(N)</code>, where <code>N</code> is the length of the cleaned string.</li>
     *   <li>The method iterates through the string once using the two-pointer technique, performing constant-time operations
     *       at each step (character comparison, pointer movement, etc.).</li>
     * </ul>
     *
     * <p>
     * Overall, the algorithm provides an efficient solution for checking whether a phrase is a palindrome, with a linear
     * time complexity proportional to the length of the cleaned string.
     * </p>
     */


    public boolean isPalindromeUsingTwoPointer(String phrase) {
        // Clean the phrase
        String cleanPhrase = phrase
                .replaceAll("[^a-zA-Z0-9]", "") // Remove all non-alphanumeric characters
                .toLowerCase(); // Convert to lowercase

        // Use two pointers to check if the string is a palindrome
        int leftPointer = 0;
        int rightPointer = cleanPhrase.length() - 1;

        // Iterate through the string and check if the pointers are equal
        while (leftPointer < rightPointer) {
            // If the characters at the pointers are not equal, return false
            if (cleanPhrase.charAt(leftPointer) != cleanPhrase.charAt(rightPointer)) {
                return false;
            }
            // Move the pointers towards the center
            leftPointer++;
            rightPointer--;
        }

        return true;
    }

    public boolean isPalindromeByReversingTheString(String phrase) {
        // Clean the phrase
        String cleanPhrase = phrase
                .replaceAll("[^a-zA-Z0-9]", "") // Remove all non-alphanumeric characters
                .toLowerCase(); // Convert to lowercase

        // Reverse the string
        String reversedString = new StringBuilder(cleanPhrase).reverse().toString();

        // Check if the string is a palindrome
        return cleanPhrase.equals(reversedString);
    }


    @Test
    public void testPalindromeStringShouldReturnTrue() {
        String validPalindrome = "A man, a plan, a canal: Panama";
        boolean result = isPalindromeUsingTwoPointer(validPalindrome);
        boolean result2 = isPalindromeByReversingTheString(validPalindrome);
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    public void testEmptyStringShouldReturnTrue() {
        String emptyString = "";
        boolean result = isPalindromeUsingTwoPointer(emptyString);
        boolean result2 = isPalindromeByReversingTheString(emptyString);
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    public void testNonPalindromeStringShouldReturnFalse() {
        String nonPalindromeString = "Free Palestine";
        boolean result = isPalindromeUsingTwoPointer(nonPalindromeString);
        boolean result2 = isPalindromeByReversingTheString(nonPalindromeString);
        assertFalse(result);
        assertFalse(result2);

    }
}
