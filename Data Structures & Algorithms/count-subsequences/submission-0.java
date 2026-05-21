class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return solve(0,0,s,t);
    }
    public int solve(int i,int j,String s,String t){
        if(j >= t.length()){
            return 1;
        }
        if(i >=  s.length()){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return memo[i][j] = solve(i+1,j,s,t)+solve(i+1,j+1,s,t);
        }

        return memo[i][j] = solve(i+1,j,s,t);
    }
}
