class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int trap = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottom = stack.pop();
                if(stack.isEmpty()) continue;
                int left = stack.peek();
                int waterLen = Math.min(height[left],height[i]) - height[bottom];
                int width = i - left - 1;
                if(waterLen > 0) trap += waterLen * width;
            }
            stack.push(i);
        }
        return trap;
    }
}
