class SinglyLinkedList{
    private static class Node {
        int data;
        Node next;
    
        Node (int data){
            this.data=data;
        }
    }
        private Node head;
        private Node tail;
        private int size;

        public void insertAtHead (int data){
            Node newNode=new Node (data);
            if(head==null){
                head=tail=newNode;

            }
            else{
                newNode.next=head;
                head=newNode;

            }
            size++;
        }
        public void insertAtTail (int data){
            Node newNode=new Node (data);
            if(tail==null){
                head=tail=newNode;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
            size++;
            }
            public void insertAtposition (int index,int data){
                if(index<0||index>size){
                    System.out.println("Invalid position");
                    return;
                }
                if(index==0){
                    insertAtHead(data);
                }
                else if(index==size){
                    insertAtTail(data);
                }
                else{
                    Node newNode=new Node (data);
                    Node prev=head;
                    for(int i=0;i<index-1;i++){
                        prev=prev.next;
                    }
                    newNode.next=prev.next;
                    prev.next=newNode;
                    size++;
                }
            }
            public void deleteAtHead(){
                if(tail==null){
                    System.out.println("List is Empty");
                    return;
                }
                head=head.next;
                if(head==null){
                    tail=null;
                }
                size--;
            }
            public void deleteAtTail(){
                if(tail==null){
                    System.out.println("List is Empty");
                    return;
                }
                if(head==tail){
                    head=tail=null;
                }
                else{
                    Node current=head;
                    while(current.next!=tail){
                        current=current.next;
                    }
                    current.next=null;
                    tail=current;
                }
                size--;
            }
            public void deleteAtposition(int index,int data){
                if(index<0||index>=size){
                    System.out.println("Invalide index");
                    return;
                }
                if(index==0){
                    deleteAtHead();
                }
                else if(index==size-1){
                    deleteAtTail();
                }
                else{
                    Node prev=head;
                    for(int i=0;i<index-1;i++){
                        prev=prev.next;
                    }
                    prev.next =prev.next.next;
                    size--;
                }
            }
            public int search(int key){
                Node current =head;
                int index=0;
                while(current !=null){
                    if(current.data==key){
                        return index;
                    }
                    current=current.next;
                    index++;
                }
                return -1;
            }
            public void updateAtposition(int index, int newvalue){
                if(index<0||index>=size){
                    System.out.println("Invalide Position");
                    return;
                }
                Node current=head;
                for(int i=0;i<index;i++){
                    current=current.next;
                }
                int oldvalue =current.data;
                current.data=newvalue;
                System.out.println("Update position"+index+"from"+oldvalue+"to"+newvalue);
            }
                public void display(){
                    Node current=head;
                    System.out.println("List");
                    while (current!=null){
                        System.out.println(current.data+"=>");
                        current=current.next;
                    }
                    System.out.println("null");
                }
                public boolean isEmpty(){
                    return size==0;
                }
    public static void main (String []args){
        SinglyLinkedList List = new SinglyLinkedList();
        List.insertAtHead(10);
        List.insertAtTail(20);
        List.insertAtposition(1,25);

        List.deleteAtHead();
        List.display();

        List.deleteAtTail();
        List.display();

        List.insertAtTail(30);
        List.insertAtTail(40);
        List.insertAtposition(1,12);
        List.display();

        int pos=List.search(25);
        System.out.println("poition of 25 "+(pos>=0? pos:"Notfound"));
        List.updateAtposition(1,40);
        List.display();

        List.updateAtposition(0, 15);
        List.updateAtposition(2, 13);
        List.display();

        }


}