package practice.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

class problems{
    static void reverseArraylist(ArrayList list){
        int j=list.size()-1;
        for (int i=0;i<j;i++){
            Object a = list.get(i);
            list.set(i,list.get(j));
            list.set(j,a);
            j--;
        }
    }
}

public class arraylist {
    public static void main(String[] args) {
//        Integer i= Integer.valueOf(1);
//        System.out.println(i);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(9);
//        System.out.println(list.get(0));
//        for (int i=0;i<list.size();i++){
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
//        System.out.println(list.remove(Integer.valueOf(4)));
//        System.out.println(list);
//        list.remove(0);
//        boolean ans = list.contains(4);
//        System.out.println(ans);
        problems obj = new problems();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("Original list is: "+list);
        obj.reverseArraylist(list);
        System.out.println("Reversed list is: "+ list);
        Collections.reverse(list);
        System.out.println("Reversed by collections framework: "+ list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
