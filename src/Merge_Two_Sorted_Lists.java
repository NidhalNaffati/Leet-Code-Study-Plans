import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a> <br>
 * Easy <br>
 * <br>
 * You are given the heads of two sorted linked lists list1 and list2. <br>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists. <br>
 * Return the head of the merged linked list. <br>
 * <br>
 * Example 1: <br>
 * Input: list1 = [1,2,4], list2 = [1,3,4] <br>
 * Output: [1,1,2,3,4,4] <br>
 * <br>
 * Example 2: <br>
 * Input: list1 = [], list2 = [] <br>
 * Output: [] <br>
 * <br>
 * Example 3: <br>
 * Input: list1 = [], list2 = [0] <br>
 * Output: [0] <br> <br>
 * Constraints: <br>
 * The number of nodes in both lists is in the range [0, 50]. <br>
 * -100 <= Node.val <= 100 <br>
 * Both list1 and list2 are sorted in non-decreasing order. <br>
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        ListNode current = this;
        while (current != null) {
            result.append(current.val);
            if (current.next != null) {
                result.append(" -> ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}

public class Merge_Two_Sorted_Lists {

    /**
     * Solution <br>
     * Runtime0 ms
     * Beats
     * 100%
     * Memory41.2 MB
     * Beats
     * 63.95%
     */
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create a dummy node to start the merged list
        ListNode dummy = new ListNode();
        // create a pointer to the current node in the merged list
        ListNode current = dummy;

        // iterate through the lists while both are not null
        while (list1 != null && list2 != null) {
            // compare values and add the smaller one to the merged list
            if (list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            // move the pointer in the merged list
            current = current.next;
        }

        // if any of the lists is not fully processed, append the remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // the merged list starts from the next of the dummy node
        return dummy.next;
    }

    @Test
    public void testMergeTwoLists() {
        // 1st list: [1 -> 2 -> 4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        System.out.println("First list: " + list1);

        // 2nd list: [1 -> 3 -> 5]
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        System.out.println("Second list: " + list2);

        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.println("Merged list: " + mergedList);

        // expected list: [1 -> 1 -> 2 -> 3 -> 4 -> 5]
        ListNode expectedList = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));

        // assert that the merged list is equal to the expected list
        assertEquals(expectedList.toString(), mergedList.toString());
    }

    @Test
    public void testMergeOneListWithAnotherEmptyOne() {
        // 1st list: [1 -> 2 -> 4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        System.out.println("First list: " + list1);

        // 2nd list: [0]
        ListNode list2 = new ListNode();
        System.out.println("Second list: " + list2);

        // expected list: [0 -> 1 -> 2 -> 4]
        ListNode expectedList = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(4))));

        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.print("Merged list: " + mergedList);

        // assert that the merged list is equal to the expected list
        assertEquals(expectedList.toString(), mergedList.toString());
    }

    @Test
    public void testMergeTwoEmptyLists() {
        // 1st list: []
        ListNode list1 = new ListNode();
        System.out.println("First list: " + list1);

        // 2nd list: []
        ListNode list2 = new ListNode();
        System.out.println("Second list: " + list2);

        // expected list: [0 -> 0]
        ListNode expectedList = new ListNode(0, new ListNode(0));

        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.println("Merged list: " + mergedList);

        // assert that the merged list is equal to the expected list
        assertEquals(expectedList.toString(), mergedList.toString());
    }

}
