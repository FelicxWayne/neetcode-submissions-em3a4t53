class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> res = new ArrayList<>();
       Set<Integer> col = new HashSet<>();
       Set<Integer> posDiag = new HashSet<>();
       Set<Integer> negDiag = new HashSet<>();
       int[] queens = new int[n];
       backTrack(0,n,queens,col,posDiag,negDiag,res);
       return res;
    }
    public void backTrack(int r,int n,int[] queens,Set<Integer> col,Set<Integer> posDiag,Set<Integer> negDiag,List<List<String>> res){
        if(r == n){
            res.add(buildBoard(queens,n));
            return;
        }

        for(int c = 0; c<n;c++){
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }

            queens[r] = c;
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);

            backTrack(r+1,n,queens,col,posDiag,negDiag,res);

            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
    }
    public List<String> buildBoard(int[] queens,int n){
        List<String> board = new ArrayList<>();
        for(int i = 0; i<n;i++){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
