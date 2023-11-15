import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a> <br>
 * Easy <br>
 * <br>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. <br>
 * <br>
 * Example 1: <br>
 * Input: nums = [1,2,3,1] <br>
 * Output: true <br>
 * <br>
 * Example 2: <br>
 * Input: nums = [1,2,3,4] <br>
 * Output: false <br>
 * <br>
 * Example 3: <br>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2] <br>
 * Output: true <br>
 * <br>
 * Constraints: <br>
 * - 1 <= nums.length <= 10^5 <br>
 * - -10^9 <= nums[i] <= 10^9 <br>
 */

public class Contains_Duplicate {


    public boolean containsDuplicate(int[] nums) {
        // Create a HashMap to store the count of each unique element in the array
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int num : nums) {
            // Retrieve the current count of the element from the map
            Integer count = map.get(num);

            // If the count is null, the element is encountered for the first time
            if (count == null) {
                // Put the element in the map with a count of 1
                map.put(num, 1);
            } else {
                // If the count is not null, the element has been encountered before, indicating a duplicate
                // Return true as soon as a duplicate is found
                return true;
            }
        }

        // If the loop completes without finding any duplicates, return false
        return false;
    }


    @Test
    public void testContainsDuplicateShouldReturnTrue() {
        int[] nums = {1, 2, 3, 1};
        boolean result = containsDuplicate(nums);
        assertTrue(result);
    }

    @Test
    public void testContainsDuplicateShouldReturnFalse() {
        int[] nums = {1, 2, 3, 4};
        boolean result = containsDuplicate(nums);
        assertFalse(result);
    }
}
