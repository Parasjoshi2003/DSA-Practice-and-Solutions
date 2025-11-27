package practice;

public class test {
    public  static int  find( int nums []) {
        int n = nums.length;
        int i = 0;
        while (i<n){
            if(i == nums[i] || nums[i] == n){
                i++;
                System.out.println("i is " + i);
            }
            else if(i != nums[i]){
                System.out.println("i is "+i + " inside else block");
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        for(i =0 ; i<n ;i++){
            if(nums[i]!=i) return i;
        }
        return n;
    }
    public static void main(String[] args) {
         int arr[ ] = {3,0,1};
        System.out.println(find(arr));

        }
}
