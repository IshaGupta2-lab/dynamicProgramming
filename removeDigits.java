import java.util.*;

public class removeDigits{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(helper(n));
    }

    public static int helper(int n){
        long[]dp=new long[(int)(n+1)];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int temp=i;
            dp[i]=Integer.MAX_VALUE;

            while(temp>0){
                int rem=temp % 10;
                dp[i]=Math.min(dp[i],1+dp[(int)(i - rem)]);
                temp=temp/10;
            }
        }
        return (int)dp[(int)n];
    }
}