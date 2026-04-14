class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(backTrack(i,j,0,word,board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean backTrack(int row,int col,int index,String word,char[][] board){
        if(row < 0 || row >= board.length){
            return false;
        }
        if(col < 0 || col >= board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(index == word.length()-1){
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backTrack(row-1,col,index+1,word,board)||backTrack(row+1,col,index+1,word,board)||backTrack(row,col-1,index+1,word,board)||backTrack(row,col+1,index+1,word,board);

        board[row][col] = temp;

        return found;
    }
}
