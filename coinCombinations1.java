// import java.util.*;
// public class coinCombinations1 {
//   static final int mod=1000000007;
//   static int[] dp;
//   static int[] coins;
//   public static int solve(int x){
//     if(x==0) return 1;
//     if(x<0) return 0;
//     if(dp[x]!=-1) return dp[x];
//     int res=0;
//     for(int coin:coins){
//         res=(res+solve(x-coin))%mod;
//     }
//     return dp[x]=res;

//   }
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int x=sc.nextInt();
//         coins=new int[n];
//         for(int i=0;i<n;i++){
//             coins[i]=sc.nextInt();
//         }
//         dp=new int[x+1];
//         Arrays.fill(dp,-1);
//         System.out.println(solve(x));
//     }

// }
import java.io.*;
import java.util.*;

public class coinCombinations1 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        
        int n = Integer.parseInt(first[0]);
        int x = Integer.parseInt(first[1]);

        int[] coins = new int[n];
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(arr[i]);
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }
}