import java.io.*;
// LinkedListNode class
class LinkedListNode {
    Bank data;
    LinkedListNode next;

    public LinkedListNode(Bank data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {
    private LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void add(Bank data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Bank find(double accountNumber) {
        LinkedListNode current = head;
        while (current != null) {
            if (current.data.account_num == accountNumber) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(double accountNumber) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        // If the node to be deleted is the head
        if (head.data.account_num == accountNumber) {
            head = head.next;
            System.out.println("Account deleted successfully.");
            return;
        }
        LinkedListNode current = head;
        LinkedListNode previous = null;

        // Traverse the list to find the node to be deleted
        while (current != null && current.data.account_num != accountNumber) {
            previous = current;
            current = current.next;
        }
        // If the node with the specified account number is found, delete it
        if (current != null) {
            previous.next = current.next;
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}