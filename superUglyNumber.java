class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
      long[] ugly=new long[n];
      int[] idx=new int[primes.length];

      ugly[0]=1;

      for(int i=1;i<n;i++){
        ugly[i]=helper(ugly,idx,primes);
      }  
      return (int)ugly[n-1];
    }
    public long helper(long[] ugly,int[] idx,int[] primes){
        long next=Long.MAX_VALUE;
        for(int i=0;i<primes.length;i++){
            next=Math.min(next,ugly[idx[i]]*primes[i]);

        }
        for(int i=0;i<primes.length;i++){
            if(ugly[idx[i]]*primes[i]==next){
                idx[i]++;
            }
        }
        return next;
    }
}