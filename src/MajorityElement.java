import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a> <br>
 * Easy <br>
 * <br>
 * Given an array nums of size n, return the majority element. <br>
 * <br>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array. <br>
 * <br>
 * Example 1: <br>
 * Input: nums = [3,2,3] <br>
 * Output: 3 <br>
 * <br>
 * Example 2: <br>
 * Input: nums = [2,2,1,1,1,2,2] <br>
 * Output: 2 <br>
 * <br>
 * Constraints: <br>
 * - n == nums.length <br>
 * - 1 <= n <= 5 * 10^4 <br>
 * - -10^9 <= nums[i] <= 10^9 <br>
 */
public class MajorityElement {

    /**
     * <b>Approach 1: Sorting </b><br>
     * <br>
     * <b>Intuition:</b> <br>
     * The intuition behind this approach is that if an element occurs more than n/2 times in the array (where n is the size of the array), it will always occupy the middle position when the array is sorted. Therefore, we can sort the array and return the element at index n/2. <br>
     * <br>
     * <b>Explanation:</b> <br>
     * <ol>
     *   <li>The code begins by sorting the array nums in non-decreasing order using the sort function from the C++ Standard Library. This rearranges the elements such that identical elements are grouped together.</li>
     *   <li>Once the array is sorted, the majority element will always be present at index n/2, where n is the size of the array.</li>
     *   <li>This is because the majority element occurs more than n/2 times, and when the array is sorted, it will occupy the middle position.</li>
     *   <li>The code returns the element at index n/2 as the majority element.</li>
     * </ol>
     * <br>
     * <b>Complexity:</b> <br>
     * <ul>
     *     <li><b>Time:</b> O(n log n) (sorting the array).</li>
     *     <li><b>Space:</b> O(log n) (sorting the array).</li>
     */

    public int majorityElementUsingSortingApproach(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    /**
     * <b>Approach 2: Hash Map</b> <br>
     * <br>
     * <b>Intuition:</b> <br>
     * <ol>
     *   <li>The solution efficiently finds the majority element in an array by leveraging a HashMap to count occurrences.</li>
     *   <li>It checks if an element appears more than n/2 times, where n is the array size.</li>
     * </ol>
     * <br>
     * <b>Explanation:</b> <br>
     * <ol>
     *   <li>Return the single element if the array has only one.</li>
     *   <li>Calculate the majority threshold 'majority' based on the array length.</li>
     *   <li>Use a HashMap 'map' to store element occurrences.</li>
     *   <li>Iterate 'nums':
     *     <ol>
     *       <li>Increment count if the number exists in 'map'.</li>
     *       <li>Return the number if count exceeds the majority threshold.</li>
     *       <li>Add the number to 'map' with a count of 1 if not present.</li>
     *     </ol>
     *   </li>
     *   <li>Return 0 if no majority element is found.</li>
     * </ol>
     * <br>
     * <b>Complexity:</b> <br>
     * <ul>
     *   <li><b>Time:</b> O(n) (iteration through the array).</li>
     *   <li><b>Space:</b> O(n) (HashMap storage, where n is array size).</li>
     * </ul>
     */
    public int majorityElementUsingHashMapApproach(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int majority = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            if (++count > majority)
                return num;
            map.put(num, count);
        }
        return 0;
    }


    /**
     * <b>Approach 3: Moore Voting Algorithm</b> <br>
     * <br>
     * <b>Intuition:</b> <br>
     * The algorithm assumes that if a majority element exists in an array, it will maintain a lead in the count, even after encountering other elements. <br>
     * <br>
     * <b>Explanation:</b> <br>
     * <ol>
     *   <li>Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.</li>
     *   <li>Iterate through the array nums:
     *     <ol>
     *       <li>If count is 0, assign the current element as the new candidate and increment count by 1.</li>
     *       <li>If the current element is the same as the candidate, increment count by 1.</li>
     *       <li>If the current element is different from the candidate, decrement count by 1.</li>
     *     </ol>
     *   </li>
     *   <li>After the iteration, the candidate variable will hold the majority element.</li>
     * </ol>
     * <br>
     * <b>Explanation of Correctness:</b> <br>
     * The algorithm relies on the assumption that the majority element occurs more than n/2 times in the array. This ensures that even if the count is reset to 0 by other elements, the majority element will eventually regain the lead. <br>
     * <br>
     * Let's consider two cases: <br>
     * <ol>
     *   <li>If the majority element has more than n/2 occurrences:
     *     <ul>
     *       <li>The algorithm ensures that the count remains positive for the majority element, guaranteeing its selection as the final candidate.</li>
     *     </ul>
     *   </li>
     *   <li>If the majority element has exactly n/2 occurrences:
     *     <ul>
     *       <li>In this case, there will be an equal number of occurrences for the majority element and the remaining elements combined.</li>
     *       <li>However, the majority element is still selected as the final candidate because it always maintains a lead over any other element.</li>
     *     </ul>
     *   </li>
     * </ol>
     * In both cases, the algorithm correctly identifies the majority element. <br>
     * <br>
     * <b>Complexity:</b>
     * <ul>
     *     <li><b>Time:</b> (single pass through the array).</li>
     *     <li><b>Space:</b> O(1) (constant space).</li>
     * </ul>
     */
    public int majorityElementUsingMooreVotingAlgorithmApproach(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }


    @Test
    public void testMajorityElementShouldReturn3() {
        int[] nums = {3, 2, 3};
        int resultUsingSortingApproach = majorityElementUsingSortingApproach(nums);
        int resultUsingHashMapApproach = majorityElementUsingHashMapApproach(nums);
        int resultUsingMooreVotingAlgorithmApproach = majorityElementUsingMooreVotingAlgorithmApproach(nums);
        assertEquals(3, resultUsingSortingApproach);
        assertEquals(3, resultUsingHashMapApproach);
        assertEquals(3, resultUsingMooreVotingAlgorithmApproach);
    }


    @Test
    public void testMajorityElementShouldReturn2() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int resultUsingSortingApproach = majorityElementUsingSortingApproach(nums);
        int resultUsingHashMapApproach = majorityElementUsingHashMapApproach(nums);
        int resultUsingMooreVotingAlgorithmApproach = majorityElementUsingMooreVotingAlgorithmApproach(nums);
        assertEquals(2, resultUsingSortingApproach);
        assertEquals(2, resultUsingHashMapApproach);
        assertEquals(2, resultUsingMooreVotingAlgorithmApproach);
    }

    @Test
    public void testMajorityElementShouldReturn5() {
        int[] nums = {5};
        int resultUsingSortingApproach = majorityElementUsingSortingApproach(nums);
        int resultUsingHashMapApproach = majorityElementUsingHashMapApproach(nums);
        int resultUsingMooreVotingAlgorithmApproach = majorityElementUsingMooreVotingAlgorithmApproach(nums);
        assertEquals(5, resultUsingSortingApproach);
        assertEquals(5, resultUsingHashMapApproach);
        assertEquals(5, resultUsingMooreVotingAlgorithmApproach);
    }

    @Test
    public void testMajorityElementShouldReturn1() {
        int[] nums = {0, 0, 0, 0, 1, 1, 1, 1, 1};
        int resultUsingSortingApproach = majorityElementUsingSortingApproach(nums);
        int resultUsingHashMapApproach = majorityElementUsingHashMapApproach(nums);
        int resultUsingMooreVotingAlgorithmApproach = majorityElementUsingMooreVotingAlgorithmApproach(nums);
        assertEquals(1, resultUsingSortingApproach);
        assertEquals(1, resultUsingHashMapApproach);
        assertEquals(1, resultUsingMooreVotingAlgorithmApproach);
    }

}
