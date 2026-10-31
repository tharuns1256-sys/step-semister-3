public class DeleteNthNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node deleteNthNode(Node head, int n) {
        if (n == 1) {
            return head.next;
        }

        Node current = head;

        for (int i = 1; i < n - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = deleteNthNode(head, 3);
        printList(head);

        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);

        head2 = deleteNthNode(head2, 1);
        printList(head2);
    }
}