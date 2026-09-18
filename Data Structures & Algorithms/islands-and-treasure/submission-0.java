class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
          int n = grid.length;
          int m = grid[0].length;
          int[][] visited = new int[n][m];
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    trav(n,m,grid,i,j,0);
                }
                
            }
          }

    }

    public void trav(int n,int m, int[][] grid, int i,int j,int d){
        if(grid[i][j]==-1){
            return;
        }
        if(d>grid[i][j]){
            return;
        }
        grid[i][j]=d;
        int min=INF;
        for(int[] dir: dirs){
            int currI=i+dir[0];
            int currJ=j+dir[1];
            if(currI<n && currI>-1 && currJ<m && currJ>-1 ){
                trav(n,m,grid,currI,currJ,d+1);
            }
        }
    }


}
