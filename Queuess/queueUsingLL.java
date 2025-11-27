package practice.Queuess;

public class queueUsingLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node front;
        static Node rear;

        Queue() {
            front = rear = null;
        }

        public static boolean isEmpty() {
            return (rear == null && front == null);
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("The Queue is empty");
                return -1;
            }
            if(front == rear){
                int data = front.data;
                front = rear = null;
                return data;
            }
            int data = front.data;
            front = front.next;
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return -1;
            }
            return front.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
