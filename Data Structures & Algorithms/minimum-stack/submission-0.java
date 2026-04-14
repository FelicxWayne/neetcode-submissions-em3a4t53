class MinStack {
    int[] stack;
    Stack<Integer> min = new Stack<>();
    int top = 0;

    public MinStack() {
        stack = new int[1000];
    }
    
    public void push(int val) {
        stack[top++] = val;
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        top--;
        int pop = stack[top];
        stack[top] = 0;
        if(!min.isEmpty() && min.peek() == pop) min.pop();
    }
    
    public int top() {
        return stack[top-1];
    }
    
    public int getMin() {
        return min.peek();
    }
}
