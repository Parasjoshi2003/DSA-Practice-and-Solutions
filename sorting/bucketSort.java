package practice.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class bucketSort {
    static void BucketSort(float arr[]){
        //buckets
        int n=arr.length;
        ArrayList<Float> buckets[]= new ArrayList[n];
        //create buckets
        for (int i=0;i<n;i++){
            buckets[i]=new ArrayList<Float>();
        }
        //filling the buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex= (int) arr[i]*n;
            buckets[bucketIndex].add(arr[i]);
        }
        //sort each bucket
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
        }
        //merge buckets
        int index=0;
        for (int i = 0; i <buckets.length ; i++) {
            ArrayList<Float> currBucket = buckets[i];
            for (int j =0;j<currBucket.size();j++){
                arr[index++]=currBucket.get(j);
            }
        }

    }



    public static void main(String[] args) {
    float []arr={0.1f,0.3f,0.2f,0.8f,0.5f};
    BucketSort(arr);
    for (float val : arr){
        System.out.print(val + " ");
    }
    }
}
