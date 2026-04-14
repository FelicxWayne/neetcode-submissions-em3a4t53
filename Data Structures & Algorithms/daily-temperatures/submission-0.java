class Solution {
    public int[] dailyTemperatures(int[] temp) {
       Stack<Integer> stack = new Stack<>();
       int[] res = new int[temp.length];
       for(int i = 0; i < temp.length; i++){
        while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
            res[stack.peek()] = i - stack.peek();
            stack.pop();
        }
        stack.push(i);
       }
       return res;
    }
}
