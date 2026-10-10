public class PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    void addFirst(int token) {
        Node newNode = new Node(token);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast(int token) {
        Node newNode = new Node(token);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void insertAt(int index, int token) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            addFirst(token);
            return;
        }

        Node current = head;

        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(token);
        newNode.next = current.next;
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        PriorityTokenInsertion list = new PriorityTokenInsertion();

        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        list.printList();
    }
}