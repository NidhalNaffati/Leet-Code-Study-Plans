import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a> <br>
 * Easy <br>
 * <br>
 * Given the head of a singly linked list, return the middle node of the linked list. <br>
 * If there are two middle nodes, return the second middle node. <br>
 * <br>
 * Example 1: <br>
 * Input: head = [1,2,3,4,5] <br>
 * Output: [3,4,5] <br>
 * Explanation: The middle node of the list is node 3. <br>
 * <br>
 * Example 2: <br>
 * Input: head = [1,2,3,4,5,6] <br>
 * Output: [4,5,6] <br>
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one. <br>
 * <br>
 * Constraints: <br>
 * The number of nodes in the list is in the range [1, 100]. <br>
 * 1 <= Node.val <= 100 <br>
 */


public class Middle_of_the_Linked_List {

    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode fastPointer = head;

        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }


    @Test
    public void testMiddleNodeWithOddNodes() {
        // list: [1 -> 2 -> 3 -> 4 -> 5]
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int middleNodeValue = middleNode(list).val;
        int expected = 3;
        assertEquals(expected, middleNodeValue);
    }

    @Test
    public void testMiddleNodeWithEvenNodes() {
        // list: [1 -> 2 -> 3 -> 4 -> 5 -> 6]
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        int middleNodeValue = middleNode(list).val;
        int expected = 4;
        assertEquals(expected, middleNodeValue);
    }

    @Test
    public void testMiddleNodeWithSingleNode() {
        // list: [1]
        ListNode list = new ListNode(1);
        int middleNodeValue = middleNode(list).val;
        int expected = 1;
        assertEquals(expected, middleNodeValue);
    }

    @Test
    public void testMiddleNodeWithTwoNodes() {
        // list: [1 -> 2]
        ListNode list = new ListNode(1, new ListNode(2));
        int middleNodeValue = middleNode(list).val;
        int expected = 2;
        assertEquals(expected, middleNodeValue);
    }

    @Test
    public void testMiddleNodeWithThreeNodes() {
        // list: [1 -> 2 -> 3]
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3)));
        int middleNodeValue = middleNode(list).val;
        int expected = 2;
        assertEquals(expected, middleNodeValue);
    }

}
