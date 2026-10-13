class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row=-1;
        for(int i=0;i<n;i++){
            if(matrix[i][0]<=target && matrix[i][m-1]>=target){
                row = i;
                break;
            }
        }
        if(row==-1)return false;

        int left = 0;
        int right = m-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(matrix[row][mid]==target)return true;

            if(matrix[row][mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
        
    }
}
