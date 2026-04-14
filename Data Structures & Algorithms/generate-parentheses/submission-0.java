class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("",0,0,n,res);
        return res;
    }
    public void helper(String currStr,int openCount,int closeCount,int n,List<String> res){
        if(currStr.length() == n*2){
            res.add(new String(currStr));
            return;
        }

        if(openCount < n){
            helper(currStr+"(",openCount+1,closeCount,n,res);
        }
        if(closeCount < openCount){
            helper(currStr+")",openCount,closeCount+1,n,res);
        }
    }
}
