public class SinglyCircularLinkedList {

    private static class Node {
        int data;
        Node next;

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
        tail.next = head;
    } 
    else {
        newNode.next = head;
        head = newNode;
        tail.next = head;
        }
        size++;
        }
        
        public void insertAtTail(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
                tail.next = head;
                } 
                else {
                    tail.next = newNode;
                    tail = newNode;
                    tail.next = head;
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
                    else if (index == size) 
                    {
                        insertAtTail(data);
                    } 
                    else {
                        Node newNode = new Node(data);
                        Node current = head;
                        for (int i = 0; i < index - 1; i++) {
                            current = current.next;
                            }
                            newNode.next = current.next;
                            current.next = newNode;
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
                                    } else {
                                        head = head.next;
                                        tail.next = head;
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
                Node current = head;
                while (current.next != tail) {
                    current = current.next;
                    }
                    current.next = head;
                    tail = current;
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
                    for (int i = 0; i < index - 1; i++) {
                        current = current.next;
                    }
                    current.next = current.next.next;
                    size--;
                }
            }


           public int search(int key) {
            if (head == null) return -1;
            
            Node current = head;
            int index = 0;
            do {
                if (current.data == key) return index;
                current = current.next;
                index++;
                } 
                while (current != head);
                return -1;
                }


                public void updateAtPosition(int index, int newValue) {
                    if (index < 0 || index > size) {
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
                public void display() {
                    if (head == null) {
                        System.out.println("List is empty");
                        return;
                        }
                        
                        Node current = head;
                        System.out.print("List: ");
                        do {
                            System.out.print(current.data + " -> ");
                            current = current.next;
                            } while (current != head);
                            System.out.println("(back to head)");
                            }
                            
                            public int getSize() {
                                return size;
                                }
                                
                                public static void main(String[] args) {
                                    SinglyCircularLinkedList list = new SinglyCircularLinkedList();
                                    
list.insertAtHead(10);
list.insertAtTail(20);
list.insertAtPosition(1, 15);
list.display();

list.deleteAtHead();
list.display(); 
list.deleteAtTail();
list.display(); 

list.insertAtTail(30);
list.insertAtTail(40);
list.insertAtPosition(1, 25);
list.display();

int pos = list.search(25);
System.out.println("Position of 25: " + (pos != -1 ? pos : "Not found"));

list.updateAtPosition(1, 100);
list.display(); 

list.updateAtPosition(0, 9); 
list.updateAtPosition(3, 99); 
list.display();

list.updateAtPosition(10, 500);
}
}