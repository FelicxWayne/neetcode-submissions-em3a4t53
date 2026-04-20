class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        int res1 = dp(nums,0,n-2);
        int res2 = dp(nums,1,n-1);

        return Math.max(res1,res2);
    }
    public int dp(int[] nums,int start,int end){
        
        int[] dpArr = new int[nums.length];

        if(start == end) return nums[start];

        dpArr[start] = nums[start];
        dpArr[start+1] = Math.max(nums[start],nums[start+1]);

        for(int i = 2; i <= end; i++){
            dpArr[i] = Math.max(dpArr[i-1],dpArr[i-2]+nums[i]);
        }

        return dpArr[end];
    }
}
