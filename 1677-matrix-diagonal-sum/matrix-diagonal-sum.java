class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int totalsum=0;
        for(int i =0;i<n;i++){
            totalsum += mat[i][i];
            if(i!= n-1-i){
                totalsum += mat[i][n-1-i];
            }
        }
        return totalsum;
    }
}