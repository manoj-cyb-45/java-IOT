/**
 * Node class represents each element in the LinkedList.
 */
class Node {
    int data;       // Value stored in the node
    Node next;      // Pointer to the next node

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Linkedlidtbasic class with insert and display methods.
 */
public class Linkedlidtbasic {
    static  Node head ,tail;  // Head (first node) of the list

    /**
     * Insert a new node at the end of the list.
     * @param data Value to insert
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;   // First node
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // Traverse till last node
        }
        temp.next = newNode;  // Link new node at end
    }

    /**
     * Display all nodes in the LinkedList.
     */
    public void display() {
        Node temp = head;
        System.out.print("LinkedList: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

/**
 * Main class to test Linkedlidtbasic insert and display.
 */
class LinkedListDemo {
    public static void main(String[] args) {
        Linkedlidtbasic list = new Linkedlidtbasic();

        // Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // Display list
        list.display();
    }
}
