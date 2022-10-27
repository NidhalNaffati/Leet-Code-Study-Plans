package day5;

// Java program to implement a Singly Linked List
public class ListNode {

    // head of list
    // Linked list Node.
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

    // Method to insert a new node
    public static void insertNodeInTheList(ListNode head, int data) {
        // Create a new node with given data
        ListNode newNode = new ListNode(data);

        newNode.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = newNode;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            ListNode lastNode = head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            // Insert the new_node at last node
            lastNode.next = newNode;
        }

    }

    // Method to print the listNode.
    public static void printList(ListNode head) {
        ListNode currNode = head;

        System.out.print("listNode: ");

        // Traverse through the listNode
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + " ");
            // Go to next node
            currNode = currNode.next;
        }

        System.out.println();
    }


    // **************MAIN METHOD**************

    // method to create a Singly linked list with n nodes
    public static void main(String[] args) {
        /* Start with the empty list. */
        ListNode list = new ListNode();

        // ******INSERTION******
        // Insert the values
        insertNodeInTheList(list, 1);
        insertNodeInTheList(list, 2);
        insertNodeInTheList(list, 3);
        insertNodeInTheList(list, 4);
        insertNodeInTheList(list, 5);
        insertNodeInTheList(list, 6);
        insertNodeInTheList(list, 7);
        insertNodeInTheList(list, 8);

        // Print the listNode
        printList(list);

    }
}
