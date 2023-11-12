import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a> <br>
 * Easy <br>
 * <br>
 * Given the head of a singly linked list, reverse the list, and return the reversed list. <br>
 * <br>
 * Example 1: <br>
 * Input: head = [1,2,3,4,5] <br>
 * Output: [5,4,3,2,1] <br>
 * <br>
 * Example 2: <br>
 * Input: head = [1,2] <br>
 * Output: [2,1] <br>
 * <br>
 * Example 3: <br>
 * Input: head = [] <br>
 * Output: [] <br>
 * <br>
 * Constraints: <br>
 * The number of nodes in the list is in the range [0, 5000]. <br>
 * -5000 <= Node.val <= 5000 <br>
 */


public class Reverse_Linked_List {

    /**
     * Iterative Solution <br>
     * Runtime: 0ms --
     * Beats:
     * 100% --
     * Memory 41.3 MB --
     * Beats:
     * 42.95%
     */

    public ListNode reverseListIterative(ListNode head) {
        // Initialize the tail of the reversed list to null
        ListNode tail = null;
        // Start iterating through the original list
        ListNode current = head;

        // Iterate through the original list
        while (current != null) {
            // Save the next node in the original list
            ListNode nextNode = current.next;
            // Reverse the link to the tail
            current.next = tail;
            // Move the tail to the current node
            tail = current;
            // Move to the next node in the original list
            current = nextNode;
        }

        // Return the reversed list
        return tail;
    }

    /**
     * Recursive Solution <br>
     * Runtime: 0ms --
     * Beats:
     * 100% --
     * Memory 41.3 MB --
     * Beats:
     * 42.95%
     */
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: if the list is empty or has only one node, return it
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);
        // Update the next pointer of the current node to reverse the link
        head.next.next = head;
        // Set the next pointer of the current node to null to break the link
        head.next = null;

        // Return the new head of the reversed list
        return newHead;
    }


    @Test
    public void testReversingTwoLists1() {
        // list: [1, 2, 3, 4, 5]
        ListNode listForIterativeSolution = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listForRecursiveSolution = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Given list: " + listForIterativeSolution);

        ListNode reversedListFromIterativeSolution = reverseListIterative(listForIterativeSolution);
        System.out.println("Reversed list from iterative solution: " + reversedListFromIterativeSolution);

        ListNode reversedListFromRecursiveSolution = reverseListRecursive(listForRecursiveSolution);
        System.out.println("Reversed list from recursive solution: " + reversedListFromRecursiveSolution);


        ListNode expectedListNode = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        assertEquals(expectedListNode.toString(), reversedListFromIterativeSolution.toString());
        assertEquals(expectedListNode.toString(), reversedListFromRecursiveSolution.toString());

    }

    @Test
    public void testReversingTwoLists2() {
        ListNode list = new ListNode(1, new ListNode(2));
        System.out.println("Given list: " + list);

        ListNode reversedListFromIterativeSolution = reverseListIterative(list);
        System.out.println("Reversed list from iterative solution: " + reversedListFromIterativeSolution);

        ListNode reversedListFromRecursiveSolution = reverseListRecursive(list);
        System.out.println("Reversed list from recursive solution: " + reversedListFromRecursiveSolution);

        ListNode expectedListNode = new ListNode(2, new ListNode(1));
        assertEquals(expectedListNode.toString(), reversedListFromIterativeSolution.toString());
        assertEquals(expectedListNode.toString(), reversedListFromRecursiveSolution.toString());

    }

    @Test
    public void testReversingTwoEmptyLists() {
        ListNode list = null; // empty list
        ListNode reversedListFromIterativeSolution = reverseListIterative(list);
        ListNode reversedListFromRecursiveSolution = reverseListRecursive(list);
        assertNull(reversedListFromIterativeSolution);
        assertNull(reversedListFromRecursiveSolution);
    }

    @Test
    public void testReversingTwoListsContainingOnlyOneElement() {
        ListNode list = new ListNode(1);
        System.out.println("Given list: " + list);


        ListNode reversedListFromIterativeSolution = reverseListIterative(list);
        System.out.println("Reversed list from iterative solution: " + reversedListFromIterativeSolution);

        ListNode reversedListFromRecursiveSolution = reverseListRecursive(list);
        System.out.println("Reversed list from recursive solution: " + reversedListFromRecursiveSolution);

        assertEquals("[1]", reversedListFromIterativeSolution.toString());
        assertEquals("[1]", reversedListFromRecursiveSolution.toString());
    }
}
