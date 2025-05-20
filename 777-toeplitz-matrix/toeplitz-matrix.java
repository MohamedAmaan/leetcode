class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =1 ;i<m;i++){
            for(int j =1;j<n;j++){
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}