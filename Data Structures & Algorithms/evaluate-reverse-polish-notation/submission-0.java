class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = Set.of("+","-","*","/");

        for(String t:tokens){
            if(!ops.contains(t)){
                stack.push(Integer.parseInt(t));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;

                switch(t){
                    case "+" -> res = a+b;
                    case "-" -> res = a-b;
                    case "*" -> res = a*b;
                    case "/" -> res = a/b;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
