public class DeleteLastNodeDoubly {

    static class DNode {
        int data;
        DNode prev;
        DNode next;

        DNode(int data) {
            this.data = data;
        }
    }

    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
        current.prev = null;

        return head;
    }

    static void printList(DNode head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        while (head != null) {
            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" <-> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        head = deleteLastNodeDoubly(head);
        printList(head);

        DNode head2 = new DNode(5);
        head2 = deleteLastNodeDoubly(head2);
        printList(head2);
    }
}