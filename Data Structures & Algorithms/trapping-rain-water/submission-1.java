class Solution {
    public int trap(int[] height) {
        int trap = 0;
        int n = height.length, left = 0,right = n-1;
        int leftMax = height[left], rightMax = height[right];
        while(left<=right){
            if(leftMax < rightMax){
                leftMax = Math.max(leftMax,height[left]);
                trap += leftMax - height[left];
                left++;
            }
            else{
                rightMax = Math.max(rightMax,height[right]);
                trap += rightMax - height[right];
                right--;
            }
        }
        return trap;
    }
}
