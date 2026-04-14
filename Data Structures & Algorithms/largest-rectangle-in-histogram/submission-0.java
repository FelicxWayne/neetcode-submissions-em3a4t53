class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int width = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int mid = stack.pop();
                int left = (stack.isEmpty()) ? -1:stack.peek();
                width = i-left-1;
                max = Math.max(max,width*heights[mid]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int mid = stack.pop();
            int left = (stack.isEmpty()) ? -1:stack.peek();
            width = heights.length - left - 1;
            max = Math.max(max,width*heights[mid]);
        }
        return max;
    }
}
