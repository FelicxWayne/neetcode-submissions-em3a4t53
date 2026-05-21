class Solution {
    Integer[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        memo = new Integer[matrix.length][matrix[0].length];
        int max = 0;

        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                max = Math.max(max,solve(i,j,-1,matrix));
            }
        }
        return max;
    }
    public int solve(int i,int j,int prev,int[][] matrix){
        if(i < 0 || i >= matrix.length){
            return 0;
        }
        if(j < 0 || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] <= prev){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        int down = solve(i+1,j,matrix[i][j],matrix);
        int up = solve(i-1,j,matrix[i][j],matrix);
        int left = solve(i,j-1,matrix[i][j],matrix);
        int right = solve(i,j+1,matrix[i][j],matrix);

        return memo[i][j] = 1+Math.max(Math.max(down,up),Math.max(left,right));
    }
}
