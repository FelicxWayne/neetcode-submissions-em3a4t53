class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0;i < row;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(board[i][col-1] == 'O'){
                dfs(i,col-1,board);
            }
        }
        for(int j = 0;j < col;j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board);
            }
            if(board[row-1][j] == 'O'){
                dfs(row-1,j,board);
            }
        }

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board){
        if(i < 0 || i >= board.length){
            return;
        }
        if(j < 0 || j >= board[0].length){
            return;
        }

        if(board[i][j] == 'O'){
            board[i][j] = '#';
            dfs(i+1,j,board);
            dfs(i-1,j,board);
            dfs(i,j+1,board);
            dfs(i,j-1,board);
        }
    }
}
