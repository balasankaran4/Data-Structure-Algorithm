public class DoublyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
        }
        }
        private Node head, tail;
        private int size;

        public void insertAtHead(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            }
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }
        public void insertAtTail(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
            }
            else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }
        public void insertAtPosition(int index, int data) {
            if (index < 0 || index > size) {
                System.out.println("Invalid position");
                return;
            }
            if (index == 0) {
                insertAtHead(data);
            }
            else if (index == size) {
                insertAtTail(data);
            }
            else {
                Node newNode = new Node(data);
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                Node prevNode = current.prev;
                newNode.prev = prevNode;
                newNode.next = current;
                prevNode.next = newNode;
                current.prev = newNode;
                size++;
            }
        }

        public void deleteAtHead() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head == tail) {
                head = tail = null;
            }
            else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
        public void deleteAtTail() {
            if (tail == null) {
                System.out.println("List is empty");
                return;
            }
            if (head == tail) {
                head = tail = null;
            }
            else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
        public void deleteAtPosition(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Invalid position");
                return;
            }
            if (index == 0) {
                deleteAtHead();
            }
            else if (index == size - 1) {
                deleteAtTail();
            }
            else {
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                Node prevNode = current.prev;
                Node nextNode = current.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                size--;
            }
        }
        public int search(int key) {
            Node current = head;
            int index = 0;
            while (current != null) {
                if (current.data == key) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
        public void updateAtPosition(int index, int newValue) {
            if (index < 0 || index >= size) {
                System.out.println("Invalid position");
                return;
            }

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            int oldValue = current.data;
            current.data = newValue;
            System.out.println("Updated position " + index + " from " + oldValue + " to " + newValue);
        }
        public void displayForward() {
            Node current = head;
            System.out.print("Forward:");
            while (current != null) {
                System.out.print(current.data + "=>");
                current = current.next;
            }
            System.out.println("null");
        }
        public void displayBackward() {
            Node current = tail;
            System.out.print("Backward: ");
            while (current != null) {
                System.out.print(current.data + "=>");
                current = current.prev;
            }
            System.out.println("null");
        }

        public int getSize() {
            return size;
        }
        public static void main(String[] args) {
            DoublyLinkedList list = new DoublyLinkedList();

            list.insertAtHead(10);
            list.insertAtTail(20);
            list.insertAtPosition(1, 15);
            list.displayForward();
            list.displayBackward();

            list.deleteAtHead();
            list.displayForward();
            list.deleteAtTail();
            list.displayForward();
            list.insertAtTail(30);
            list.insertAtTail(40);

            list.insertAtPosition(1, 25);
            list.displayForward(); 


            int pos = list.search(30);
            System.out.println("Position of 30:" + (pos != -1 ? pos : "Not found"));

            list.updateAtPosition(1, 100); 
            list.updateAtPosition(3, 99);
            list.displayForward(); 
            list.updateAtPosition(10, 500); 

        }

        }