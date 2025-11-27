package practice.Queuess;

public class QueueB {
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;
        Queue(int n){
            arr = new int[n];
            size = n;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static void add(int data){
            if(rear == arr.length-1){
                System.out.println("Queue overflow");
                return;
            }
            arr[++rear] = data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i =0 ; i<rear;i++){
                arr[i] = arr[i+1];
            }
            return front;
        }

    }
}
