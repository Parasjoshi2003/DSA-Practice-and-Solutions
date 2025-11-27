package practice.Queuess;
import java.util.LinkedList;
import java.util.*;

public class queuqQUES {
    //Queue using two stacks
//    static class queue {
//        static Stack<Integer> s1 = new Stack<>();
//        static Stack<Integer> s2 = new Stack<>();
//        public static boolean isEmpty(){return s1.isEmpty();}
//        public static void add(int data){
//                while(!s1.isEmpty()){
//                    s2.push(s1.pop());
//                }
//                s1.push(data);
//                while(!s2.isEmpty()){
//                    s1.push(s2.pop());
//                }
//        }
//        public static int pop(){
//            return s1.pop();
//        }
//        public static int peek(){
//            return s1.peek();
//        }
//    }
    class MyStack {
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            if(!q1.isEmpty()){
                q1.add(x);
            }else{
                q2.add(x);
            }
        }

        public int pop() {
            int top=-1 ;
            if(q2.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()) break;
                q2.add(top);
            }
            }else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()) break;
                    q1.add(top);
                }
            }
            return top;
        }

        public int top() {
            int top=-1 ;
            if(q2.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.peek();
//                    if(q1.isEmpty()) break;
                    q2.add(q1.remove());
                }
            }else{
                while(!q2.isEmpty()){
                    top = q2.peek();
//                    if(q2.isEmpty()) break;
                    q1.add(q2.remove());
                }
            }
            return top;
        }

        public boolean empty() {
            return q1.isEmpty() || q2.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    public static void main(String[] args) {
        queuqQUES q  = new queuqQUES();
        MyStack s = q.new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.top());

    }
}
