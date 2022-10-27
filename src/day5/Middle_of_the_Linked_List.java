package day5;

import static day5.ListNode.insertNodeInTheList;
import static day5.ListNode.printList;

/** 876. Middle of the Linked List
 Easy
 https://leetcode.com/problems/middle-of-the-linked-list/

 Given the head of a singly linked list, return the middle node of the linked list.
 If there are two middle nodes, return the second middle node.

 Example 1:
 Input: head = [1,2,3,4,5]
 Output: [3,4,5]
 Explanation: The middle node of the list is node 3.

 Example 2:
 Input: head = [1,2,3,4,5,6]
 Output: [4,5,6]
 Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

 Constraints:
 The number of nodes in the list is in the range [1, 100].
 1 <= Node.val <= 100
 */

public class Middle_of_the_Linked_List {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    Memory Usage: 41.5 MB, less than 51.89% of Java online submissions for Middle of the Linked List.
     */

    public static void main(String[] args) {
        /* Start with the empty list. */
        ListNode list = new ListNode();


        // Insert some values
        for(int i = 1 ; i<12 ; i++)
            insertNodeInTheList(list, i);

        // print the middle list.
        printList(middleNode(list));

    }


    /*
    We will use 2 pointers ( fastPointer & slowPointer )
    they both starts from the head of the list.
    the fastPointer will move 2x then the slowPointer.
    --> when fastPointer reach the end of the list the slowPointer will be exactly in the middle.
    */
    public static ListNode middleNode(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode fasterPointer = head ;

        ListNode slowerPointer = head ;

        while(fasterPointer != null && fasterPointer.next != null){
            slowerPointer = slowerPointer.next ;
            fasterPointer = fasterPointer.next.next ;
        }

        return slowerPointer;
    }

}
