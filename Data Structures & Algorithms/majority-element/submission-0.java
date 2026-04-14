class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 0;
        
        for(int n:nums){
            if(count == 0) maj = n;
            count += (n == maj) ? 1:-1;
        }
        return maj;
    }
}