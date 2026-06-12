class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for(int[] dir:directions){
                int nextRow = currRow+dir[0];
                int nextCol = currCol+dir[1];

                if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == Integer.MAX_VALUE){
                    grid[nextRow][nextCol] = grid[currRow][currCol]+1;
                    queue.add(new int[]{nextRow,nextCol});
                }
                
            }
        }
    }
}
