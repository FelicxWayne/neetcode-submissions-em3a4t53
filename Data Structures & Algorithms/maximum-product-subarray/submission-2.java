class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] forw = new int[n];
        forw[0] = nums[0];
        for(int i = 1; i < n; i++){
            forw[i] = (forw[i-1] == 0 ? 1 : forw[i-1]) * nums[i];
        }
        int[] rev = new int[n];
        rev[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            rev[i] = (rev[i+1] == 0 ? 1 : rev[i+1]) * nums[i];
        }
        int maxRes = nums[0];
        for(int i = 0; i < n; i++){
            maxRes = Math.max(maxRes, Math.max(forw[i],rev[i]));
        }
        return maxRes;
    }
}
