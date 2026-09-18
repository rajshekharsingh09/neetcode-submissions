class Solution {
    public int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] gridVisited = new int[n][m];
        int max=0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(gridVisited[i][j]==0 && grid[i][j]==1){
                    int counter =0;
                    counter = priDfs(grid,gridVisited,i,j,n,m,counter);
                    if(counter>max){
                        max=counter;
                    }

                }
            }
        }
        return max;
    }

    public int priDfs(int[][] grid, int[][] gridVisited,int i,int j,int n,int m,int counter){
        gridVisited[i][j]=1;
        counter++;
        for(int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && x<n && y>=0 && y<m && gridVisited[x][y]==0 && grid[x][y]==1){
                counter=priDfs(grid,gridVisited,x,y,n,m,counter);
            }
        }
        return counter;
    }
}
