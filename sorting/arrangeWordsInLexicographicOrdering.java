package practice.sorting;

public class arrangeWordsInLexicographicOrdering {
    public static void main(String[] args) {
        String arr[]={"Paras","rahul","Lokesh","Rohit"};
        for(int i=0;i<arr.length-1;i++){
           for (int j=i+1;j<arr.length;j++){
               if (arr[i].compareTo(arr[j])>0){
                   String temp=arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;
               }
           }
        }

        for (String i:arr){
            System.out.print(i+" ");
        }
    }
}
