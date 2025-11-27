package practice.searching;

public class squareRootFinder {
    static int sqrt(int x){
    int start=0;
    int end=x;
    int ans=-1;
    while (start<=end){
        int mid=start + (end-start)/2;
        if (mid*mid==x) return mid;
        else if(mid*mid<x){
            ans=mid;
            start=mid+1;
        }
        else{
            end=mid-1;

        }
    }
    return ans;
    }

    public static void main(String[] args) {
        int x =120;
        System.out.println(sqrt(x));

    }
}
