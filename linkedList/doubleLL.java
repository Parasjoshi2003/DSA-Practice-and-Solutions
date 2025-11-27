package practice.LinkedList;

public class doubleLL {
    static class Node{
        int data;
        Node next;
        Node prv;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prv = null;
        }
    }

    public static Node tail;
    public static Node head;
    public static int size;

    public void addLast(int data){
        Node temp = new Node(data);
        size++;
        if(head == null && tail == null){
            head = temp ;
            tail= temp;
        }else{
            tail.next = temp;
            temp.prv = tail;
            temp.next = null;
            tail = temp;
        }
    }

    public void removeLast(){
        size--;
        if(head == null && tail== null){
            System.out.println("Nothing to remove as doubly linked list is empty");
            return;
        }
        else if(tail.prv == null){
            head = tail = null;
        }
        else{
            tail = tail.prv;
            tail.next = null;
        }
    }

    public static void print(){
        Node temp = head;
        if(head == null){
            System.out.println("linked list is empty");
            return;
        }
        while(temp.next!=null){
            System.out.print(temp.data +" <-> ");
            temp = temp.next;
        }
        System.out.print(temp.data + "<-> ∅");
        System.out.println();
    }

    public static void reverse(){
        Node prvNode = null ;
        Node currNode = head;
        tail = head;
        while(currNode != null){
        Node nextNode = currNode.next ;
            currNode.next= prvNode;
            currNode.prv = nextNode;
            prvNode = currNode;
            currNode = nextNode;
        }
//        currNode.prv = null;
//        currNode.next = prvNode;
        head = prvNode;

    }

    public static void main(String[] args) {
        doubleLL ll = new doubleLL();
        ll.addLast(1);
        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(5);
        ll.print();
//        ll.reverse();
        ll.reverse();
        ll.print();
        System.out.println(tail.data);
        System.out.println(tail.prv.data);
//        System.out.println(tail.prv.prv.data);
//        System.out.println(tail.prv.prv.prv.data);
    }
}
