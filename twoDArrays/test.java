package practice.twoDarrays;

public class test {

        public int reverse(int x) {
            int sum=0;
            int num=x;
            do{

                sum=sum*10;
                sum=sum+(num%10);
                num=num/10;
                if (sum>214748364 || sum<-214748364){
                    return 0;
                }

            }
            while(num>0 || num<0);
            return sum;
        }

    public static void main(String[] args) {
        test obj = new test();
        int a=obj.reverse(1534236469);
        System.out.println(a);
    }
}
