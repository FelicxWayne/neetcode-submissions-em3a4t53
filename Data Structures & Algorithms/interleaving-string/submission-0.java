class Solution {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        memo = new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1.length()-1,s2.length()-1,s3.length()-1,s1,s2,s3);
    }
    public boolean solve(int i,int j,int k, String s1,String s2, String s3){
        if(k < 0) return true;

        if(memo[i+1][j+1] != null){
            return memo[i+1][j+1];
        }

        boolean match1 = false;
        boolean match2 = false;
        if(i >= 0 && s1.charAt(i) == s3.charAt(k)){
            match1 = solve(i-1,j,k-1,s1,s2,s3);
        }
        if(j >= 0 && s2.charAt(j) == s3.charAt(k)){
            match2 = solve(i,j-1,k-1,s1,s2,s3);
        }

        return memo[i+1][j+1] = match1||match2;
    }
}
