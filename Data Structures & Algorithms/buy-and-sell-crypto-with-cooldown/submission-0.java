class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return solve(0,1,prices);
    }
    public int solve(int idx,int buyState,int[] prices){
        if(idx >= prices.length){
            return 0;
        }

        if(memo[idx][buyState] != null){
            return memo[idx][buyState];
        }
        int buy = 0;
        if(buyState == 1){
            buy = Math.max(solve(idx+1,1,prices),-prices[idx]+solve(idx+1,0,prices));
        }
        int sell = 0;
        if(buyState == 0){
            sell = Math.max(solve(idx+1,0,prices),prices[idx]+solve(idx+2,1,prices));
        }

        return memo[idx][buyState] = buy+sell;
    }
}
