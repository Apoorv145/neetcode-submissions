class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int sell=0;
        int profit =0;
        for (int i =0;i<prices.length;i++)
        {
            int currbuy=prices[i];
            buy=Math.min(currbuy,buy);
            int currsell=prices[i];
            sell=Math.max(currsell,sell);
            profit = Math.max(profit, currsell - buy);
        }
        if(profit<0)
        {
            return 0;
        }
        else
        {
            return profit;
        }
        
    }
}
