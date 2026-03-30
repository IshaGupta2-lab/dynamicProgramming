import java.util.Arrays;
import java.util.Scanner;

public class boredom {
    static long[] freq=new long[100001];
    static long[] dp=new long[100001];
    static long solve(int i){
        if(i<=0) return 0;
        if(dp[i]!=-1) return dp[i];
        long notTake=solve(i-1);
        long take=solve(i-2)+(long)i*freq[i];
        return dp[i]=Math.max(take, notTake);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            freq[x]++;
        }
        Arrays.fill(dp, -1);
        System.out.println(solve(100000));
        
    }
}
