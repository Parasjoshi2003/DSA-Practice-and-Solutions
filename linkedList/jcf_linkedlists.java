package practice.LinkedList;
import java.util.LinkedList;
public class jcf_linkedlists {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(2);
        ll.addLast(1);
        ll.addFirst(0);
        
        System.out.println(ll);
    }
}
