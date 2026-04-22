class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int n:nums){
            totalSum += n;
        }
        if(Math.abs(target) > totalSum) return 0;
        Integer[][] memo = new Integer[nums.length][2*totalSum+1];
        
        return backTrack(0,0,target,nums,memo,totalSum);
    }
    public int backTrack(int idx,int currSum,int target,int[] nums,Integer[][] memo,int totalSum){
        if(idx == nums.length){
            return currSum == target ? 1:0;
        }
        int col = currSum+totalSum;

        if(memo[idx][col]!=null){
            return memo[idx][col];
        }

        int add = backTrack(idx+1,currSum+nums[idx],target,nums,memo,totalSum);
        int sub = backTrack(idx+1,currSum-nums[idx],target,nums,memo,totalSum);

        int total = add+sub;
        memo[idx][col] = total;
        return total;
    }
}
