package practice.Queuess;
import java.util.LinkedList;
import java.util.*;
public class queueQuestions {
    public static int firstNonRepetingChar(String s){ // return index of char
        int freq[] = new int[26];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            q.add(i);
            while( !q.isEmpty() && freq[s.charAt(q.peek()) -'a'] >=2 ){ // increase frequency of an character in freq array using index of char in string
                q.remove();
            }
        }
        if (q.isEmpty()){
            return -1;
        }
        return q.peek();
    }

    public static void rearrangeQueue(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<>();
        int size = q.size()/2;
        System.out.println(size +" size is ");
        for (int i = 0; i < size; i++) {
            System.out.println("value of i is "+i+ " size is "+ size);
            q2.add(q.remove());
        }
        while (!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }


    static class stackUsingDeque {
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
            return dq.isEmpty();
        }
        public void push(int data){
            dq.addLast(data);
        }
        public int pop(){
            return dq.removeLast();
        }
        public int peek(){
            return dq.peekLast();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        stackUsingDeque s = new stackUsingDeque();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
//        q.add(8);
//        q.add(12);
//        q.add(13);
//        q.add(15);//8 12 13 15 9 14 2 4 20 12
//        q.add(9);
//        q.add(14);
//        q.add(2);
//        q.add(4);
//        q.add(20);
//        q.add(12);

//        q.add(2);
//        q.add(4);
//        q.add(3);
//        q.add(1);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//
//        rearrangeQueue(q);
//        while (!q.isEmpty()){
//            System.out.println(q.remove());
//        }
    }
}
