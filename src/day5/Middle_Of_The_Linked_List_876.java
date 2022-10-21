package day5;


import static day5.ListNode.insertNewNodeInTheListNode;

public class Middle_Of_The_Linked_List_876 {

    public static void main(String[] args) {

        ListNode headerNoder = new ListNode(4,null);

        insertNewNodeInTheListNode(headerNoder, 5);
        insertNewNodeInTheListNode(headerNoder, 6);
        insertNewNodeInTheListNode(headerNoder, 7);
        insertNewNodeInTheListNode(headerNoder, 8);
        insertNewNodeInTheListNode(headerNoder, 9);
        insertNewNodeInTheListNode(headerNoder, 10);


        ListNode currentNode = headerNoder ;

        while(currentNode != null){
            System.out.print(currentNode.val+" ");
            currentNode = currentNode.next;
        }

    }


    /** this the leet code solution:
     public ListNode middleNode(ListNode head) {

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

     */

}
