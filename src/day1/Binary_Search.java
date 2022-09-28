package day1;


/**704. Binary Search
 Easy
 https://leetcode.com/problems/binary-search/

 Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:

 Input: nums = [-1,0,3,5,9,12], target = 9
 Output: 4
 Explanation: 9 exists in nums and its index is 4
 Example 2:

 Input: nums = [-1,0,3,5,9,12], target = 2
 Output: -1
 Explanation: 2 does not exist in nums so return -1

 Constraints:

 1 <= nums.length <= 104
 -104 < nums[i], target < 104
 All the integers in nums are unique.
 nums is sorted in ascending order.

 */

public class Binary_Search {


    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
    Memory Usage: 54.9 MB, less than 14.20% of Java online submissions for Binary Search.
     */
    public static void main(String[] args) {
        int[] arrayOfSortedNumbers = {
                4, 8, 10, 15, 20, 55, 58, 69, 73, 81, 101, 400, 704, 1000, 2001
        };

        int target = 101;

        System.out.println(search(arrayOfSortedNumbers, target)
                + " : this is the resut of the iterative Search method.");

        System.out.println(recursiveSearch(arrayOfSortedNumbers, target, 0, arrayOfSortedNumbers.length - 1)
                + " : this is the resut of the recursive Search method.");

    }

    //Binary Search Approach:
    /*
 Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
 The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).

Binary Search Algorithm: The basic steps to perform Binary Search are:
* Begin with the mid element of the whole array as a search key.
*If the value of the search key is equal to the item then return an index of the search key.
*Or if the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
*Otherwise, narrow it to the upper half.
*Repeatedly check from the second point until the value is found or the interval is empty.

Binary Search Algorithm can be implemented in the following two ways:
1-Iterative Method
2-Recursive Method
 */

    /*
     * NOTE: for better understading how to calculate the middle value check out this link
     * https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
     * */

    // iterative solution :
    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] == target)
                return middle;
            else if (target > nums[middle])
                start = middle + 1;
            else
                end = middle - 1;
        }

        return -1;
    }

    // recursevie solution :
    public static int recursiveSearch(int[] arr, int tar, int start, int end) {

        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == tar) {
            return mid;
        }

        if (arr[mid] < tar) {
            return recursiveSearch(arr, tar, mid + 1, end);
        }

        return recursiveSearch(arr, tar, start, mid - 1);

    }


}
