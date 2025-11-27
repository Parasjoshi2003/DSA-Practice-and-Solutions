package practice.arrays;


import java.util.Arrays;

public class arraySorting {

    static int[] smallAndLarge(int arr[])
    {
        Arrays.sort(arr);
        System.out.println("Sorted array is: ");
        printArray(arr);
        int arr2[]={arr[0],arr[arr.length-1]};
                return arr2;
    }
    static void printArray(int arr[])
    {
        System.out.print("{ ");
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+", ");
        }
        System.out.println("}");
//        System.out.println();
    }
    static boolean sortCheck(int arr[])
    {
        boolean ans=true;
        for (int i=1;i<arr.length;i++)
        {
            if (arr[i]>arr[i-1]){
                 ans=true;
            }
            else {
                ans=false;
            }
        }
//        System.out.println(arr+ " is sorted: "+ ans);
        return ans;
    }



    public static void main(String[] args)
    {
        int arr[]={5,3,5,6,7,2,34,5,};
        System.out.println("Unsorted array is: ");
        printArray(arr);
        int arr1[]={1,2,3,4,5,6,7,8};
        System.out.println("Sorted array is: ");
        printArray(arr1);
        System.out.println("is arr"+ " sorted: " + sortCheck(arr));
        System.out.println("is arr1"+ " sorted: " + sortCheck(arr1));

        int ansArray[]=smallAndLarge(arr);
        System.out.println("Hence the least and greatest value is: ");
        printArray(ansArray);
    }

}
