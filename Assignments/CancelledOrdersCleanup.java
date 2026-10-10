public class CancelledOrdersCleanup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node removeAll(Node head, int code) {

        while (head != null && head.data == code) {
            head = head.next;
        }

        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    static Node addLast(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        head = addLast(head, 5);
        head = addLast(head, 3);
        head = addLast(head, 5);
        head = addLast(head, 8);
        head = addLast(head, 5);

        int code = 5;

        head = removeAll(head, code);

        printList(head);
    }
}