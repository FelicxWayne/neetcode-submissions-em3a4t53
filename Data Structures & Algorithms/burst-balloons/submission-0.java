class Solution {
    Integer[][] memo;
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0] = 1;
        for(int i = 0; i < nums.length; i++){
            arr[i+1] = nums[i];
        }
        int n = arr.length;
        arr[n-1] = 1;
        memo = new Integer[n][n];
        return solve(1,nums.length,arr);
    }
    public int solve(int i,int j,int[] arr){
        if(i > j){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        int cost = Integer.MIN_VALUE;

        for(int idx = i; idx <= j; idx++){
            cost = Math.max(cost,arr[i-1]*arr[idx]*arr[j+1]+solve(i,idx-1,arr)+solve(idx+1,j,arr));
        }
        return memo[i][j] = cost;
    }
}
