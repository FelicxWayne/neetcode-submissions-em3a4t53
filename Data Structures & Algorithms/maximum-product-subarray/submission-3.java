class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxRes = Integer.MIN_VALUE;
        int preProd = 1;
        for(int i = 0; i < n; i++){
            preProd *= nums[i];
            maxRes = Math.max(maxRes,preProd);
            if(preProd == 0) preProd = 1;
        }
        int suffProd = 1;
        for(int i = n-1; i >= 0; i--){
            suffProd *= nums[i];
            maxRes = Math.max(maxRes,suffProd);
            if(suffProd == 0) suffProd = 1;
        }
        return maxRes;
    }
}
