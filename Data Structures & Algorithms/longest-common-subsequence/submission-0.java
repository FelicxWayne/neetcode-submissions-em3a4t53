class Solution {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return lcs(0,0,text1,text2);
    }
    public int lcs(int i,int j,String t1,String t2){
        if(i >= t1.length() || j >= t2.length()){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        if(t1.charAt(i) == t2.charAt(j)){
            return memo[i][j] = 1+lcs(i+1,j+1,t1,t2);
        }
        else{
            return memo[i][j] = Math.max(lcs(i+1,j,t1,t2),lcs(i,j+1,t1,t2));
        }
    }
}
