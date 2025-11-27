package practice.LinkedList;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node tail;
    public static Node head;
    public static int size;

    public void addFirst(int data) {
        Node temp = new Node(data);
        size++;
        if (head == null && tail == null) {
            temp.next = head; //null
            head = temp;
            tail = head;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void addLast(int data) {
        Node temp = new Node(data);
        size++;
        if (head == null && tail == null) {
            temp.next = null; //null
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public void addAtIndex(int idx, int data) {
        Node temp = head;
        size++;
        int countLength = 0;
        for (Node calLength = head; calLength != null; calLength = calLength.next) {
            countLength++;
        }
        if (idx < 0 || idx > countLength) {
            System.out.println("Index greater than length");
            size--;
            return;
        }
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        Node nxtNode = temp.next;
        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.next = nxtNode;
    }

    public void printLinkedList() {
        for (Node temp = head; temp != null; temp = temp.next) {
            if(temp.next== null){
                System.out.print(temp.data+"->∅" );
            }else{
            System.out.print(temp.data +"->");
            }
        }
        System.out.println();
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        } else {
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        } else {
            int val = tail.data;
            for (Node temp = head; temp.next != null; temp = temp.next) {
                tail = temp;
            }
            tail.next = null;
            size--;
            return val;
        }
    }

    public static int recursiveSearch(int key, Node temp , int count){
        System.out.println("calling fn with params "+ temp +" "+ count);
        if(temp == null ){
            return -1;
        }
        else if(temp.data == key){
            return count;
        }
        else{
            count++;
            return recursiveSearch(key , temp.next , count);
        }
    }

    public static void reverseRecursive(Node prv, Node curr){
        if(size <=1){
            return;
        }
        if(curr == null){
        head = tail;
        tail = prv;
            return;
        }
        if(curr == prv){
            prv = null;
        }
        Node nxxt = curr.next;
        curr.next = prv;
        reverseRecursive(curr, nxxt);
    }

    public static void reverseIterative(){
        if(size<=1) return;
        Node curr = head;
        Node prv = null;
        while(curr != null){
            Node nxt = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nxt;
        }
        head = tail;
        tail = curr;
    }

    public void removeNthNodeFromEnd(int n){
        int idxToRemove = size - n;
        if(idxToRemove <0 || idxToRemove>=size) {
            System.out.println("Oops! Wrong index.");
        }
        Node prv=head;
        for (int i = 1; i < idxToRemove; i++) {
            prv= prv.next;
        }
        prv.next = prv.next.next;
    }

    public boolean isPalindrome(){
        Node st = head;
        Node end= tail;
        int count=0;
        while(count<size/2 +1){
            System.out.println(st.data +" "+ end.data);
            if(st.data != end.data) return false;
            count++;
            st=st.next;
            end= head;
            for (int i = 0; i < (size-count)-1 ; i++) {
                end= end.next;
//                System.out.println(end.data);
            }
        }
        return true;
    }

    public Node findMid(Node h){
        Node slow = h;
        Node fast = h.next;
        while (fast != null && fast.next  != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseHalf(Node mid){
        Node curr = mid;
        Node prv = null;
        while(curr != null){
            Node nxt = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nxt;
        }
        return prv;
    }

    public boolean isPalindromeUsingSlowFast(){
        if( head == null || head.next == null) return true;
        Node mid = findMid(head);
        System.out.println("mid is "+ mid.data);
        Node right = reverseHalf(mid);
        System.out.println("right is "+ right.data);
        Node tempHead = right;
        Node left = head;
        while(right != null){
            if(right.data != left.data) return false;
            left = left.next;
            right = right.next;
        }
        reverseHalf(tempHead);
        System.out.println("tail is "+ tail.data);
        return true;
    }

    public int detectCycle(){
        Node slow = head;
        Node fast = head;
        int distance = 0;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            distance++;
            if(slow == fast ){
                System.out.println("Cycle detected");
                return distance;
            }
        }
        System.out.println("No cycle detected");
            return -1;
    }

    public static void removeCycle(){
        //detect the cycle
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }
        //find meeting point
        slow = head;
        Node prv = fast;
        while(slow != fast){
            prv = fast;
            slow = slow.next;
            fast= fast.next;
        }
        //remove cycle
        prv.next = null;
    }

    public Node mergeSort(Node hed){
        if(hed == null || hed.next == null ) return hed;
        Node mid = findMid(hed);
        Node leftHead = hed;
        Node rightHead = mid.next;
        mid.next = null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return merge(leftHead, rightHead);
    }

    public Node merge(Node leftHead, Node rightHead){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHead != null && rightHead!= null){
            if(leftHead.data < rightHead.data){
                temp.next = leftHead;
                leftHead = leftHead.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }
        while (leftHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;

        }
        while (rightHead != null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        temp.next = null;
        return mergedLL.next;
    }

    public  Node zigZagLL(){
        //findmid
        Node mid = findMid(head);
        //reverse second half
        Node leftHead = head;
        Node curr = mid.next;
        mid.next = null;
        Node prv = null;
        while(curr != null){
            Node nxt = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nxt;
        }
        Node rightHead = prv;
        // two linked lists with heads
        //merging them
        Node temp = new Node(-1);
        temp.next = leftHead;
        Node newHead = temp;
        while(leftHead != null && rightHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp.next.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next.next;
        }
        while(leftHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
//        ll.addLast(6);
        ll.printLinkedList();
        System.out.println("after changing the list becomes");
        head = ll.zigZagLL();
        ll.printLinkedList();
    }
}

