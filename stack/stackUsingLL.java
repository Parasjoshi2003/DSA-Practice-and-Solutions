package practice.Stack;
import java.util.ArrayList;
import java.util.Stack;

public class stackUsingLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class StackLL {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) return -1;
            Node delNode = head;
            head = head.next;
            return delNode.data;
        }

        public static int peek() {
            return head.data;
        }
    }

    public static Stack pushAtBottom(Stack s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return s;
        }
        int top = (int) s.pop();
        pushAtBottom(s, data);
        s.push(top);
        return s;

    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder gtr = new StringBuilder("");
        while (!s.isEmpty()) {
            gtr.append(s.pop());
        }
        return gtr.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
        return;
    }

    public static void stockSpan(int stocks[], int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currValue = stocks[i];
            while (!s.isEmpty() && currValue > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
                s.push(i);
            } else {
                span[i] = i - s.peek();
                s.push(i);
            }
        }
    }

    static class StockSpanner {
        public ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        public StockSpanner() {
        }

        public int next(int price) {
            int i = list.size();
            list.add(price);
            while (!s.isEmpty() && price >= list.get(s.peek())) {
                s.pop();
            }
            int span;
            if (s.isEmpty()) {
                span = i + 1;
            } else {
                span = i - s.peek();
            }
            s.push(i);
            return span;
        }
    }

    public static int[] nextGreaterElement(int arr[]) {
        StackLL s = new StackLL();
        int nextGreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return nextGreater;
    }

    public static boolean validParenthesis(String str) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String val = str.charAt(i) + "";
            if (!s.isEmpty()) System.out.println(s.peek());
            if (val.equals("{") || val.equals("[") || val.equals("(")) {
                s.push(val);
            } else if (val.equals("}") || val.equals("]") || val.equals(")")) {
                if (s.isEmpty()) return false;
                if (val.equals("}") && s.peek().equals("{")) {
                    s.pop();
                } else if (val.equals("]") && s.peek().equals("[")) {
                    s.pop();
                } else if (val.equals(")") && s.peek().equals("(")) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean duplicateParenthesis(String str) {
        Stack<String> s = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String val = str.charAt(i) + "";
            if (!s.isEmpty()) System.out.println(s.peek());
            if (val.equals("{") || val.equals("[") || val.equals("(")) {
                s.push(val);
                count++;
            } else if (val.equals("}") || val.equals("]") || val.equals(")")) {
                if (s.isEmpty()) return false;
                if (val.equals("}") && s.peek().equals("{")) {
                    count--;
                    s.pop();
                } else if (val.equals("]") && s.peek().equals("[")) {
                    s.pop();
                    count--;
                } else if (val.equals(")") && s.peek().equals("(")) {
                    s.pop();
                    count--;
                } else {
                    return false;
                }
                if (count == 0 && str.charAt(i) == str.charAt(i - 1)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean balDuplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
//            if(!s.isEmpty()) System.out.println( "Top is: "+s.peek());
            if (ch != ')') {
                s.push(ch);
            } else {
                while (s.peek() != '(') {
//                    System.out.println("deleted "+ s.pop());
                    s.pop();
                    count++;
//                    System.out.println(count);
                }
                s.pop();
                if(count == 0){
                    return true;
                }else{
                    count = 0;
                }

            }
        }
        return false;
    }

    public static int maxAreaHistogram(int height[]){
        int maxArea  = 0;
        for (int i = 0; i < height.length; i++) {
            int leftWidth = 0;
            int rightWidth = 0 ;
            //left checker
            for(int j = i;j>0;j--){
                if(height[j-1] < height[i]) {
                    break;
                }
                leftWidth++;
            }
            //right checker
            for (int j = i; j < height.length-1 ; j++) {
//                System.out.println(height[j+1]);
                if (height[j+1]< height[i]){
                    break;
                }
                rightWidth++;

            }
            int area = height[i] * (1+rightWidth+leftWidth);
//            System.out.println(area +" "+ rightWidth+" " + leftWidth);
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }

    public static int[] nextSmallerLeft(int arr[]){
        Stack<Integer> s = new Stack<>();
        int nextSmallerLeft[] = new int[arr.length];
        for (int i = 0; i<arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1 ;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }
        return nextSmallerLeft;
    }

    public static int[] nextSmallerRight(int arr[]){
        Stack<Integer> s = new Stack<>();
        int nextSmallerRight[] = new int[arr.length];
        for (int i = arr.length -1 ; i>=0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerRight[i] = arr.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }
        return nextSmallerRight;
    }

    public static int maxAreaHistogramOptimised(int height[]){
        int[] nextSR = nextSmallerRight(height);
        int[] nextSL = nextSmallerLeft(height);
        for (int i = 0; i < nextSL.length; i++) {
            System.out.println(nextSL[i]);
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int area = height[i] *((nextSR[i] -i)+(i-nextSL[i]) -1);
            System.out.println("Area for bar:"+ height[i]+ " is: " + area + " nextSL is "+ nextSL[i] + " small right " +nextSR[i]);
            if (area> maxArea) maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(maxAreaHistogram(heights));
        System.out.println(maxAreaHistogramOptimised(heights));
//        int[] nextSmallerLeft = nextSmallerLeft(heights);
//        for(int i=0; i<nextSmallerLeft.length;i++){
//            System.out.println(nextSmallerLeft[i]);
//        }
    }
}
