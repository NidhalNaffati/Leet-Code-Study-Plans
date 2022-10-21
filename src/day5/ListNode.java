package day5;


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static void insertNewNodeInTheListNode(ListNode headList, int value) {
        // if the node is empty -> our new node should be the header one.
        if (headList == null)
            headList = new ListNode(value, null);
            // that mean that we have already a linked list of Nodes.
        else {
            // travelling till the last node.
            ListNode lastNode = headList;

            while (lastNode.next != null)
                lastNode = lastNode.next;

            //insert the new node in the end of the list.
            lastNode = new ListNode(value, null);
        }
    }
}
