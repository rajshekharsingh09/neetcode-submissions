class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int INF = Integer.MAX_VALUE;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<Node> qu = new LinkedList<>();
        Queue<Node> qu2 = new LinkedList<>();
        int[][] res= new int[n][m];
        int[][] res1= new int[n][m];
        for(int i =0;i<n;i++){
            qu.add(new Node(i,0,heights[i][0]));
            qu2.add(new Node(i,m-1,heights[i][m-1]));
        }
        for(int j=0;j<m;j++){
            qu.add(new Node(0,j,heights[0][j]));
            qu2.add(new Node(n-1,j,heights[n-1][j]));
        }
        bfs(qu,heights,res,n,m);
        bfs(qu2,heights,res1,n,m);
        List<List<Integer>> ls = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(res[i][j]==-1 && res1[i][j]==-1){
                    ls.add(Arrays.asList(i,j));
                }
            }
        }
        return ls;
    }

    public void bfs(Queue<Node> q,int[][] heights,int[][] res,int n,int m){
        while(!q.isEmpty()){
            Node cN = q.poll();
            res[cN.left][cN.right]=-1;
            for(int[] dir:dirs){
                int currN = cN.left+dir[0];
                int currM = cN.right+dir[1];
                if(currN>-1 && currN<n && currM>-1 && currM<m &&
                    cN.height<=heights[currN][currM] &&
                    res[currN][currM]!=-1){
                        q.add(new Node(currN,currM,heights[currN][currM]));
                    }
            }
        }
    }
}

class Node{
    int left;
    int right;
    int height;
    public Node(int l,int r,int h){
        this.left = l;
        this.right = r;
        this.height = h;
    }
}
