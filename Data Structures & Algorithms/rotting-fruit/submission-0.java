class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        int freshFruits = 0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshFruits++;
                }
            }
        }
        int minutes = 0;
        while(!queue.isEmpty() && freshFruits > 0){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                for(int[] dir:directions){
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 2;
                        freshFruits--;
                        queue.add(new int[]{nextRow,nextCol});
                    }
                }
            }
            minutes++;
        }
        return (freshFruits == 0) ? minutes:-1; 
    }
}
