public class DoublyCircularLinkedList {
// Node class
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

// Insert at head
public void insertAtHead(int data) {
Node newNode = new Node(data);
if (head == null) {
head = tail = newNode;
head.next = head.prev = head;
} else {
newNode.next = head;
newNode.prev = tail;
head.prev = newNode;
tail.next = newNode;
head = newNode;
}
size++;
}

// Insert at tail
public void insertAtTail(int data) {
Node newNode = new Node(data);
if (tail == null) {
insertAtHead(data);
} else {
newNode.prev = tail;
newNode.next = head;
tail.next = newNode;
head.prev = newNode;
tail = newNode;
size++;
}
}

// Insert at a specific position

public void insertAtPosition(int index, int data) {
if (index < 0 || index > size) {
System.out.println("Invalid position");
return;
}
if (index == 0) {
insertAtHead(data);
} else if (index == size) {
insertAtTail(data);
} else {
Node newNode = new Node(data);
Node current = head;
for (int i = 0; i < index; i++) {
current = current.next;
}
Node prevNode = current.prev;
prevNode.next = newNode;
newNode.prev = prevNode;
newNode.next = current;
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
} else {
head = head.next;
head.prev = tail;
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
} else {
tail = tail.prev;
tail.next = head;
head.prev = tail;
}
size--;
}

// Delete at a specific position
public void deleteAtPosition(int index) {
if (index < 0 || index >= size) {
System.out.println("Invalid position");
return;
}

if (index == 0) {
deleteAtHead();
} else if (index == size - 1) {
deleteAtTail();
} else {
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
if (head == null) return -1;

Node current = head;
int index = 0;
do {
if (current.data == key) {
return index;
}
current = current.next;
index++;
} while (current != head);
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
if (head == null) {
System.out.println("List is empty");
return;
}

Node current = head;
System.out.print("Forward: ");
do {
System.out.print(current.data + " <-> ");
current = current.next;
} while (current != head);
System.out.println("(back to head)");
}


public void displayBackward() {
if (tail == null) {
System.out.println("List is empty");
return;
}

Node current = tail;
System.out.print("Backward: ");
do {
System.out.print(current.data + " =>");
current = current.prev;
} while (current != tail);
System.out.println("(back to tail)");
}



public int getSize() {
return size;
}


public static void main(String[] args) {
DoublyCircularLinkedList list = new DoublyCircularLinkedList();

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
System.out.println("Position of 30: " + (pos != -1 ? pos : "Not found"));

list.updateAtPosition(1, 100); 
list.updateAtPosition(3, 99); 
list.displayForward();

list.updateAtPosition(10, 500);
}
}