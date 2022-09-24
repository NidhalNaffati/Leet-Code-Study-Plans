package day1;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

public class Binary_Search {

    public static void main(String[] args) {
        int[] arrayOfPositiveNumbers = {
                4,8,10,15,20,55,58,69,73,81,101,400,704,1000,2001
        } ;
        int target = 101 ;

        int targetPositionInTheArray=search(arrayOfPositiveNumbers,target);

        System.out.println(targetPositionInTheArray);
    }
    public static int search(int[] nums, int target) {


        int start = 0;
        int stop = nums.length - 1;
        int middle;


        while (start <= stop) {
            middle = (start + stop) / 2;
            if (nums[middle] == target)
                return middle;
            else if (target > nums[middle])
                start = middle + 1;
            else
                stop = middle - 1;
        }

        return -1;
    }
}
