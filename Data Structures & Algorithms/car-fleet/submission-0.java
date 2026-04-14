class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }
        Arrays.sort(cars,(a,b) -> Double.compare(a[0],b[0]));
        for(int i = n-1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(cars[i][1]);
            }
            else if(!stack.isEmpty() && cars[i][1] > stack.peek()){
                stack.push(cars[i][1]);
            }
        }
        return stack.size();
    }
}
