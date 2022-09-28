package day1;
/**278. First Bad Version
 Easy

 https://leetcode.com/problems/first-bad-version/

 You are a product manager and currently leading a team to develop a new product.
 Unfortunately, the latest version of your product fails the quality check.
 Since each version is developed based on the previous version,
 all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which returns whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.


 Example 1:

 Input: n = 5, bad = 4
 Output: 4
 Explanation:
 call isBadVersion(3) -> false
 call isBadVersion(5) -> true
 call isBadVersion(4) -> true
 Then 4 is the first bad version.
 Example 2:

 Input: n = 1, bad = 1
 Output: 1


 Constraints:

 1 <= bad <= n <= 231 - 1
 */

/**
 Since we don't have the isBadVersion API we will do the next:
 N = 1 2 3 4 5 6 7 8 9 10 11 ... 31 32 33 34 35 ... 50
 lest suppose that the bad versions began from the version 32,
 So all the next version are bad versions, all the previous versions aren't bad versions.
 So in our isBadVersion method we will check if the version is before or after the first bad version (version 32).

 */
public class First_Bad_Version {

    /*
    Runtime: 33 ms, faster than 18.96% of Java online submissions for First Bad Version.
    Memory Usage: 38.8 MB, less than 96.04% of Java online submissions for First Bad Version.
     */
    public static void main(String[] args) {
        int n = 50;
        System.out.println("the first bad version: " + firstBadVersion(50));
    }


    public static int firstBadVersion(int n) {

        int start = 0;
        int middle;

        while (start <= n) {
            middle = start + (n - start) / 2;

            if (isBadVersion(middle) == true && isBadVersion(middle - 1) == false)
                return middle;
            else if (isBadVersion(middle) == true)
                n = middle - 1;
            else
                start = middle + 1;
        }

        return start;
    }

    private static boolean isBadVersion(int version) {
        if (version < 32)
            return false;
        else // version is equal or bigger than 32
            return true;
    }


}
