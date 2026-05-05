class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(rowZero.contains(i) || colZero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
