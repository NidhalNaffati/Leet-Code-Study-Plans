package day1;

/**35. Search Insert Position
 Easy
 https://leetcode.com/problems/search-insert-position/

 Given a sorted array of distinct integers and a target value,
 return the index if the target is found. If not,
 return the index where it would be if it were inserted in order.

 You must write an algorithm with O(log n) runtime complexity.


 Example 1:
 Input: nums = [1,3,5,6], target = 5
 Output: 2

 Example 2:
 Input: nums = [1,3,5,6], target = 2
 Output: 1

 Example 3:
 Input: nums = [1,3,5,6], target = 7
 Output: 4


 Constraints:
 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums contains distinct values sorted in ascending order.
 -104 <= target <= 104
 */


public class Search_Insert {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
    Memory Usage: 43.3 MB, less than 58.73% of Java online submissions for Search Insert Position.
     */
    public static void main(String[] args) {
        //test for an existing target.
        int[] arrayOfSortedNumbers =
                {4,7,9,11,16,23,47,55,60,75,79,86,90} ;

        int target =86 ;
        System.out.println("the position of the target:"+target+" should be :"+searchInsert(arrayOfSortedNumbers,target));

        //test for a non-existing target.
        target=12 ;
        System.out.println("the position of the target:"+" should be :"+searchInsert(arrayOfSortedNumbers,target));
    }



    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start <= end) {

            middle = start + (end - start) / 2;

            if (nums[middle] == target)
                return middle;

            else if (nums[middle] > target)
                end = middle - 1;
            else
                start = middle + 1;

        }
        return start;
    }
}
