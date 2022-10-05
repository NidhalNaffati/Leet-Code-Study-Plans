package day3;

/**
 167. Two Sum II - Input Array Is Sorted
 Medium
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

 Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 find two numbers such that they add up to a specific target number.
 Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 Return the indices of the two numbers, index1 and index2,
 added by one as an integer array [index1, index2] of length 2.
 The tests are generated such that there is exactly one solution. You may not use the same element twice.
 Your solution must use only constant extra space.

 Example 1:
 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

 Example 2:
 Input: numbers = [2,3,4], target = 6
 Output: [1,3]
 Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

 Example 3:
 Input: numbers = [-1,0], target = -1
 Output: [1,2]
 Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


 Constraints:
 2 <= numbers.length <= 30000
 -1000 <= numbers[i] <= 1000
 numbers is sorted in non-decreasing order.
 -1000 <= target <= 1000
 The tests are generated such that there is exactly one solution.
 */



public class Input_Array_Is_Sorted {
    /*
    Runtime: 3 ms, faster than 55.27% of Java online submissions for Two Sum II - Input Array Is Sorted.
    Memory Usage: 49.6 MB, less than 76.54% of Java online submissions for Two Sum II - Input Array Is Sorted.
    */
    public static void main(String[] args) {
        int[] arrayOfSortedNumbers = {
                4,7,9,11,16,20,47,55,60,75,79,86,90
        };

        System.out.println(twoSum(arrayOfSortedNumbers,20)[0]);
        System.out.println(twoSum(arrayOfSortedNumbers,20)[1]);
    }

    //Two Pointer approach:
    /*
    Two pointers is really an easy and effective technique that is typically used for searching pairs in a sorted array.
    Given a sorted array A (sorted in ascending order), having N integers,
    find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
    Let us do discuss the working of two pointer algorithm in brief which is as follows.
    The algorithm basically uses the fact that the input array is sorted.
    We start the sum of extreme values (smallest and largest) and conditionally move both pointers.
    We move left pointer ‘i’ when the sum of A[i] and A[j] is less than X.
    We do not miss any pair because the sum is already smaller than X. Same logic applies for right pointer j.

     */


    public static int[] twoSum(int[] numbers, int target) {
        // Array of size 2 to store two index.
        int nums[] = new int[2];

        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {

            //1st condition if adding numbers are less than target we increase left pointer.
            if (numbers[leftPointer] + numbers[rightPointer] < target) {
                leftPointer++;
            }
            //2nd condition if adding numbers are greater than target we decrease right pointer.
            if (numbers[leftPointer] + numbers[rightPointer] > target) {
                rightPointer--;
            }
            //if we found the target and two element then assign both index and return the result.
            if (numbers[leftPointer] + numbers[rightPointer] == target) {
                nums[0] = leftPointer + 1;
                nums[1] = rightPointer + 1;
                //return the result
                return nums;
            }
        }
        //then return as empty
        return nums;
    }


    // TODO: 05/10/2022 reduce the time complexity.
    /*
        this result was accepted from the leetcode,
        but we can amprove id by adding another method.
        THis new method should reduce the searching time,
         all what we will do is find the target index if its exist or where it should be in the array
         and then assign the the result to the rightPointer.
    */


}
