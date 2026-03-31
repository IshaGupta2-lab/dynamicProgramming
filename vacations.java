import java.util.*;
public class vacations{
    static int n;
    static int[] a;
    static int[][] dp;

    public static int solve(int i,int last){
        if(i==n) return 0;
        if(dp[i][last]!=-1) return dp[i][last];
        int ans=1+solve(i+1,0);
        if((a[i]==1 || a[i]==3) && last!=1){
            ans=Math.min(ans, solve(i+1,1));
        }
        if((a[i]==2 || a[i]==3) && last!=2){
            ans=Math.min(ans, solve(i+1,2));
        }
        return dp[i][last]=ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        dp=new int[n][3];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(0,0));
    }
}