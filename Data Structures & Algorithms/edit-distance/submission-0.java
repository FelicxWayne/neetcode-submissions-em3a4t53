class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        int i = word1.length()-1;
        int j = word2.length()-1;
        memo = new Integer[i+1][j+1];
        return solve(i,j,word1,word2);
    }
    public int solve(int i,int j,String t1,String t2){
        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        if(t1.charAt(i) == t2.charAt(j)){
            return memo[i][j] = solve(i-1,j-1,t1,t2);
        }

        int delete = solve(i-1,j,t1,t2);
        int insert = solve(i,j-1,t1,t2);
        int replace = solve(i-1,j-1,t1,t2);

        return memo[i][j] = 1+Math.min(delete,Math.min(insert,replace));
    }
}
