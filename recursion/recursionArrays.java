package practice.Recursion;

import java.util.ArrayList;

class answer{
    static void printArray(int arr[],int i){
        if(i==arr.length-1){
            System.out.print(arr[i]);
            return;
        }
        System.out.print(arr[i]+", ");
        i++;
         printArray(arr,i);
    }

    int maxValueInArray(int arr[], int idx){
        if (idx== arr.length-1){           //Base Case
            if (arr[0]<arr[idx]){
                arr[0]=arr[idx];
            }
            return arr[0];
        }
        if (arr[0]<arr[idx]){
            arr[0]=arr[idx];
        }
        maxValueInArray(arr,idx+1);
        return arr[0];
    }

    static int maxValue2Approach(int arr[],int idx){
        if (idx==arr.length-1){
            return arr[idx];
        }
        int smallAns = maxValue2Approach(arr,idx+1);
        return(Math.max(arr[idx],smallAns));
    }

    int sumOfArray(int arr[],int idx){
        if (idx==arr.length-1){
            return arr[idx];
        }
        int ans= sumOfArray(arr,idx+1);
        return arr[idx]+ans;
    }

    int sumAnotherTry(int arr[], int idx,int sum){
        if (idx<=arr.length-1) {
            sum= sum + arr[idx];
           return sumAnotherTry(arr,idx+1,sum);
        }
        return sum;
    }

    boolean linearSearch(int arr[], int idx,int x){
        if (idx==arr.length-1){
            if (arr[idx]==x) return true;
            return false;
        }
        if (arr[idx]==x) return true;
        return linearSearch(arr,idx+1,x);
    }

    int [] returnAllIndices(int arr[],int idx,int x,int i,int ans[]){         // this funcion returns all the indices in array which has same value as x
        if (idx==arr.length-1){                                                 // i is the index of ans array, ans is the answer to be returned
            if (arr[idx]==x) {                                                   // logic is same as above question
                ans[i]=idx;
                i++;
            }
            return ans;
        }
        if (arr[idx]==x){
            ans[i]=idx;
            i++;
        }
       return  returnAllIndices(arr,idx+1,x,i,ans);

    }

    ArrayList<Integer> indices(int arr[], int idx, int x){
       ArrayList<Integer> ans = new ArrayList<>();
       if (idx>=arr.length) return ans;
       if (arr[idx]==x) ans.add(idx);
       ArrayList<Integer> smallAns= indices(arr,idx+1,x);
       ans.addAll(smallAns);
       return ans;
    }

    boolean isSorted(int arr[], int idx){
        if (idx==arr.length-1){
            return true;
        }
        if (idx<=arr.length-2){
            if (arr[idx]>arr[idx+1]) return false;
        }
        return isSorted(arr,idx+1);
    }

}
public class recursionArrays {
    public static void main(String[] args) {
        answer obj = new answer();
            int[] array={1,2,4,5,5,6,6};
        System.out.println(obj.isSorted(array,0));

    }
}
