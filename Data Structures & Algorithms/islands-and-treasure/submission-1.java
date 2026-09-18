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
                    trav(n,m,grid,i,j);
                }
            }
          }

    }

    public void trav(int n,int m, int[][] grid, int i,int j){
        Queue<Node> qu = new LinkedList<>();
        Node node = new Node(i,j,0);
        qu.add(node);
        while(!qu.isEmpty()){
            Node currN= qu.poll();
            if(currN.dist<grid[currN.left][currN.right]){
                grid[currN.left][currN.right]=currN.dist;
            }
            
            for(int[] dir: dirs){
                int currI=currN.left+dir[0];
                int currJ=currN.right+dir[1];
                if(currI<n && currI>-1 && currJ<m && currJ>-1 && grid[currI][currJ]!=-1){
                    int newDist = currN.dist+1;
                    if(newDist<grid[currI][currJ]){
                        qu.add(new Node(currI,currJ,currN.dist+1));
                    }
                    
                }
            }
        }
    }

}

public class Node{
    int left;
    int right;
    int dist;
    Node(int left,int right,int dist){
        this.left=left;
        this.right=right;
        this.dist=dist;
    }
}
