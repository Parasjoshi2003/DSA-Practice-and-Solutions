package practice.arrays;

public class arrayGreater {
    public static void main(String[] args) {
        int arr[]={1,23,4,5,6,77,4};
        int t=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>10){
                t++;
            }
        }
        System.out.println("Number of element greater than 10 is: " + t);
    }
}
