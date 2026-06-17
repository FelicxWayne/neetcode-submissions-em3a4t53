class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }
    public int dfs(int i,int j,int[][] grid){
        if(i < 0 || i >= grid.length){
            return 0;
        }
        if(j < 0 || j >= grid[0].length){
            return 0;
        }

        int area = 0;
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            area = 1+dfs(i+1,j,grid)+dfs(i-1,j,grid)+dfs(i,j+1,grid)+dfs(i,j-1,grid);
        }
        return area;
    }
}
