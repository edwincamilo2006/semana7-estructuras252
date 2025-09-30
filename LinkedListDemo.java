class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {

    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        if (previous == null) {
            throw new IllegalArgumentException("previous no puede ser null");
        }
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        if (elementNumber < 0) return null;
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count = count + 1;
        }

        return current;
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Índice negativo: " + index);
        }

        // Special case inserting a new head node.
        if (index == 0) {
            insertAtHead(value);
            return;
        }

        Node previous = LinkedListLookUp(index - 1);

        if (previous == null) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node newNode = new Node(value);
        LinkedListInsertAfter(previous, newNode);
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/");
    }
}

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        list.printList();
        System.out.println();

        list.insertAtIndex(3, 71);
        list.printList();
        System.out.println();

        list.insertAtIndex(6, 99);
        list.printList();
        System.out.println();

        try {
            list.insertAtIndex(100, 5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción esperada: " + e.getMessage());
        }
    }
}















