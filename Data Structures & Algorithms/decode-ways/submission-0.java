class Solution {
    Integer[] memo;
    public int numDecodings(String s) {
        memo = new Integer[s.length()+1];
        return solve(0,s);
    }
    public int solve(int i,String s){
        if(i == s.length()){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(memo[i] != null){
            return memo[i];
        }

        int ways = solve(i+1,s);

        if(i+1 < s.length()){
            int twoDigit = Integer.parseInt(s.substring(i,i+2));
            if(twoDigit >= 10 && twoDigit <= 26){
                ways += solve(i+2,s);
            }
        }

        return memo[i] = ways;
    }
}
