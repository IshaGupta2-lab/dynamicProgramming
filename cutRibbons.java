import java.util.*;
public class cutRibbons {
   static int a,b,c;
   static int[] dp;
   public static int solve(int n){
    if(n==0) return 0;
    if(n<0) return Integer.MIN_VALUE;
    if(dp[n]!=-1) return dp[n];
    int cutA=solve(n-a)+1;
    int cutB=solve(n-b)+1;
    int cutC=solve(n-c)+1;
    return dp[n]=Math.max(cutA,Math.max(cutB,cutC));
   }
   public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    a=sc.nextInt();
    b=sc.nextInt();
    c=sc.nextInt();
    dp=new int[n+1];
    Arrays.fill(dp,-1);
    System.out.println(solve(n));
   }
   
}
