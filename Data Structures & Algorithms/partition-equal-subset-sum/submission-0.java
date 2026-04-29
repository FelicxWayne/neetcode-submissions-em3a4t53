class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n:nums){
            totalSum += n;
        }
        if(totalSum % 2 != 0){
            return false;
        }
        int target = totalSum/2;
        memo = new Boolean[nums.length][target+1];
        return backTrack(0,target,nums);
    }
    public boolean backTrack(int idx,int target, int[] nums){
        if(target == 0){
            return true;
        }
        if(idx >= nums.length || target < 0){
            return false;
        }
        if(memo[idx][target] != null){
            return memo[idx][target];
        }

        boolean exclude = backTrack(idx+1,target,nums);
        boolean include = false;
        if(nums[idx] <= target){
            include = backTrack(idx+1,target-nums[idx],nums);
        }

        return memo[idx][target] = include||exclude;
    }
}
