import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">283 Move Zeros</a> <br>
 * Easy <br>
 * <br>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. <br>
 * Note that you must do this in-place without making a copy of the array. <br>
 * <br>
 * Example 1: <br>
 * Input: nums = [0,1,0,3,12] <br>
 * Output: [1,3,12,0,0] <br>
 * <br>
 * Example 2: <br>
 * Input: nums = [0] <br>
 * Output: [0] <br>
 *
 * <br>
 * Constraints: <br>
 * 1 <= nums.length <= 104 <br>
 * -231 <= nums[i] <= 231 - 1 <br>
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        // Initialize two pointers: zeroIndex and nonZeroIndex
        // zeroIndex keeps track of the position where the next non-zero element should be placed
        // nonZeroIndex iterates through the array to find non-zero elements
        int zeroIndex = 0;
        int nonZeroIndex = 0;

        // Iterate through the array to move non-zero elements to the front
        while (nonZeroIndex < nums.length) {
            // If the current element is non-zero, move it to the zeroIndex position
            if (nums[nonZeroIndex] != 0) {
                nums[zeroIndex] = nums[nonZeroIndex];
                zeroIndex++;
            }
            // Move to the next element in the array
            nonZeroIndex++;
        }

        // Fill the remaining positions in the array with zeros
        while (zeroIndex < nums.length) {
            nums[zeroIndex] = 0;
            zeroIndex++;
        }
    }


    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        int[] expected = {1, 3, 12, 0, 0};
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMoveZeroesWithOneElement() {
        int[] nums = {0};
        moveZeroes(nums);
        int[] expected = {0};
        assertArrayEquals(expected, nums);
    }


    @Test
    public void testMoveZeroesWithAllZeroes() {
        int[] nums = {0, 0, 0, 0, 0};
        moveZeroes(nums);
        int[] expected = {0, 0, 0, 0, 0};
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMoveZeroesWithAllNonZeroes() {
        int[] nums = {1, 2, 3, 4, 5};
        moveZeroes(nums);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMoveZeroesWithAllZeroesAndNonZeroes() {
        int[] nums = {0, 0, 0, 1, 2, 3, 4, 5};
        moveZeroes(nums);
        int[] expected = {1, 2, 3, 4, 5, 0, 0, 0};
        assertArrayEquals(expected, nums);
    }
}
