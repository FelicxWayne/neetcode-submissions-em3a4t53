class Solution {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new Integer[m+1][n+1];
        return backTrack(0,0,m,n);
    }
    public int backTrack(int i,int j,int row,int col){
        if(i < 0 || i > row){
            return 0;
        }
        if(j < 0 || j > col){
            return 0;
        }
        if(i == row-1 && j == col-1){
            return 1;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        int right = backTrack(i,j+1,row,col);
        int down = backTrack(i+1,j,row,col);

        return memo[i][j] = right+down;
    }
}