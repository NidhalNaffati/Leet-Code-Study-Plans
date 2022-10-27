package day5;

import static day5.ListNode.insertNodeInTheList;
import static day5.ListNode.printList;

/**19. Remove Nth Node From End of List
 Medium
 https://leetcode.com/problems/remove-nth-node-from-end-of-list/

 Given the head of a linked list, remove the nth node from the end of the list and return its head.

 Example 1:
 Input: head = [1,2,3,4,5], n = 2
 Output: [1,2,3,5]

 Example 2:
 Input: head = [1], n = 1
 Output: []

 Example 3:
 Input: head = [1,2], n = 1
 Output: [1]


 Constraints:
 The number of nodes in the list is sz.
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz

 */

public class Remove_Nth_Node_From_End_of_List {

    /*
    Runtime: 1 ms, faster than 81.10% of Java online submissions for Remove Nth Node From End of List.
    Memory Usage: 41.6 MB, less than 80.21% of Java online submissions for Remove Nth Node From End of List.
    */

    public static void main(String[] args) {
        /* Start with the empty list. */
        ListNode list = new ListNode();


        // Insert some values
        insertNodeInTheList(list, 1);
        insertNodeInTheList(list, 2);
        insertNodeInTheList(list, 3);
        insertNodeInTheList(list, 4);
        insertNodeInTheList(list, 5);
        insertNodeInTheList(list, 6);
        insertNodeInTheList(list, 7);
        insertNodeInTheList(list, 8);
        insertNodeInTheList(list, 9);
        insertNodeInTheList(list, 10);


        // Print the listNode
        System.out.print("the initial ");
        printList(list);


        removeNthFromEnd(list, 4);


        System.out.print("the  final  ");
        printList(list);

    }


    /*
     We will use 2 pointers ( pointerOne & pointerTwo )
     they both starts from the head of the list.
     the fast one will move n steps.
     then they will both move together till fast reach the end of the list.
     --> the slow pointer will be exactly requires n steps to reach the end-list.
     --> delete that node & congratulation we had the job done.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode start = new ListNode(0);

        ListNode pointerOne = start, pointerTwo = start;

        pointerOne.next = head;

        //Move fast in front so that the gap between slow and fast becomes n nodes.
        for (int i = 0; i <= n; i++) {
            pointerTwo = pointerTwo.next;
        }

        //Move fast to the end, maintaining the gap
        while (pointerTwo != null) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }


        //Skip the desired node
        pointerOne.next = pointerOne.next.next;

        return start.next;
    }
}