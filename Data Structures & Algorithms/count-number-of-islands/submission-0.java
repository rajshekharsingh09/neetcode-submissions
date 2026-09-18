class Solution {
    public int numIslands(char[][] grid) {
        int n =  grid.length;
        int m = grid[0].length;
        int count =0;
        int[][] gridVisited = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(gridVisited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    gridVisited[i][j]=1;
                    priDfs(grid,gridVisited,i,j,n,m);

                }
            }
        }
        return count;
    }

    public static void priDfs(char[][] grid, int[][] gridVisited,int i,int j,int n,int m){
        gridVisited[i][j]=1;
        if( j+1<m && grid[i][j+1]=='1' && gridVisited[i][j+1]==0 ){
            priDfs(grid,gridVisited,i,j+1,n,m);
        }if(j-1>=0 && grid[i][j-1]=='1' && gridVisited[i][j-1]==0){
            priDfs(grid,gridVisited,i,j-1,n,m);
        } if(i+1<n  && grid[i+1][j]=='1' && gridVisited[i+1][j]==0 ){
            priDfs(grid,gridVisited,i+1,j,n,m);
        }if(i-1>=0 && grid[i-1][j]=='1' && gridVisited[i-1][j]==0){
            priDfs(grid,gridVisited,i-1,j,n,m);
        }
    }
}
