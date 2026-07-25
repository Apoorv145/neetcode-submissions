class Solution {
    int t[]=new int[46];
    int solve(int n)
    {
        if(n<0)
        return 0;
        if(t[n]!=-1)
        return t[n];
        if(n==0)
        {
            return 1;

        }
        int one_step=solve(n-1);
        int two_step=solve(n-2);
        return t[n]=one_step+two_step;
    }
    public int climbStairs(int n) {
        Arrays.fill(t, -1);
        return solve(n);
    }
}
