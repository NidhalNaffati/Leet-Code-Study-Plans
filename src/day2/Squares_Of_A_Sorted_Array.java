package day2;

import java.util.Arrays;

/**977. Squares of a Sorted Array
 Easy
 https://leetcode.com/problems/squares-of-a-sorted-array/

 Given an integer array nums sorted in non-decreasing order,
 return an array of the squares of each number sorted in non-decreasing order.

 Example 1:
 Input: nums = [-4,-1,0,3,10]
 Output: [0,1,9,16,100]
 Explanation: After squaring, the array becomes [16,1,0,9,100].
 After sorting, it becomes [0,1,9,16,100].

 Example 2:
 Input: nums = [-7,-3,2,3,11]
 Output: [4,9,9,49,121]


 Constraints:

 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums is sorted in non-decreasing order.


 Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */

public class Squares_Of_A_Sorted_Array {

    /*
    Runtime: 5 ms, faster than 48.41% of Java online submissions for Squares of a Sorted Array.
    Memory Usage: 44.1 MB, less than 89.84% of Java online submissions for Squares of a Sorted Array.
     */
    public static void main(String[] args) {
        int[] sortedArray =
                {-9, -4, -3, 0, 1, 2, 3, 4, 9, 7};

        System.out.println("before:");
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }

        sortedArray=sortedSquares(sortedArray) ;

        System.out.println("after:");
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }

    }


    //this method here so simple justwe do the square fir each element in the array
    // and after that we sort the array.
    public static int[] sortedSquares(int[] nums) {

        //squaring each element
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] * nums[i];

        //sorting the array
        Arrays.sort(nums);

        return nums;
    }
}
