class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int INF = Integer.MAX_VALUE;
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        for(int[] row : res){
            Arrays.fill(row,INF);
        }
        int totalFreshEmpty=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    trav(grid,res,n,m,i,j);
                }
            }
        }

        int min=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(res[i][j]>min && res[i][j]!=INF){
                    min=res[i][j];
                }
                if(grid[i][j]==0){
                    totalFreshEmpty++;
                }
            }
        }

        if(totalFreshEmpty == m*n){
            return 0;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && res[i][j]==INF){
                    return -1;
                }
            }
        }
        return min;
    }

    public void trav(int[][] grid,int[][] res,int n,int m,int i,int j){
        Queue<Node> qu = new LinkedList<>();
        Node node = new Node(i,j,0);
        qu.add(node);
        while(!qu.isEmpty()){
            Node currN = qu.poll();
            res[currN.left][currN.right]=currN.height;
            for(int[] dir: dirs){
                int currI = currN.left+dir[0];
                int currJ = currN.right+dir[1];
                int currH = currN.height+1;
                if(currI>-1 && currI<n && currJ>-1 && currJ<m && grid[currI][currJ]!=0 && currH<res[currI][currJ]){
                    qu.add(new Node(currI,currJ,currH));
                }
            }
        }
    }
}

class Node{
    int left;
    int right;
    int height;
    public Node(int left,int right,int height){
        this.left=left;
        this.right=right;
        this.height=height;
    }
}
