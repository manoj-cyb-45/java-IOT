/**
 * Node1 class represents each element in the LinkedList.
 */
class Node1 {
    int data;       // Value stored in the node
    Node1 next;     // Pointer to the next node

    // Constructor
    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Linkedlidtbasic class with insert, display, and reverse methods.
 */
public class Linkedlidtbasic {
    static Node1 head;   // Head (first node) of the list
    static Node1 tail;   // Tail (last node) of the list

    /**
     * Insert a new node at the end of the list.
     * @param data Value to insert
     */
    public void insert(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;   // First node
            return;
        }
        Node1 temp = head;
        while (temp.next != null) {
            temp = temp.next; // Traverse till last node
        }
        temp.next = newNode;  // Link new node at end
    }

    /**
     * Display all nodes in the LinkedList.
     */
    public void display() {
        Node1 temp = head;
        System.out.print("LinkedList: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /**
     * Reverse the LinkedList using a temp variable.
     * Steps:
     * 1. Keep track of previous, current, and next nodes.
     * 2. Reverse the links one by one.
     * 3. Update head to the last node.
     */
    public void reverse() {
        Node1 prev = null;   // Previous node
        Node1 current = head; // Current node
        Node1 temp;          // Temporary variable to store next node

        while (current != null) {
            temp = current.next;   // Save next node
            current.next = prev;   // Reverse link
            prev = current;        // Move prev forward
            current = temp;        // Move current forward
        }
        head = prev;  // Update head to new first node
    }
}

/**
 * Main class to test Linkedlidtbasic insert, display, and reverse.
 */
class LinkedListDemo {
    public static void main(String[] args) {
        Linkedlidtbasic list = new Linkedlidtbasic();

        // Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // Display original list
        list.display();

        // Reverse the list
        list.reverse();

        // Display reversed list
        list.display();
    }
}
