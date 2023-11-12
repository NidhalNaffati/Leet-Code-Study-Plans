public class ListNode {
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
