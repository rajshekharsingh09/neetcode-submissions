class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int INF = Integer.MAX_VALUE;
    public void solve(char[][] board) {
        int n = board.length;
        if(n==0){
            return;
        }
        int m = board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' || board[i][m-1]=='O'){
                System.out.println("if "+i+ " "+(m-1));
                funct(board,i,0,n,m);
                funct(board,i,m-1,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' || board[n-1][j]=='O'){
                System.out.println("iff "+(n-1)+" "+j);
                funct(board,0,j,n,m);
                funct(board,n-1,j,n,m);
            }
        }
        System.out.println(Arrays.deepToString(board));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        return;
    }

    public void funct(char[][] board,int i,int j,int n,int m){
        if(board[i][j]=='X'){
            return;
        }
        Node node1 = new Node(i,j);
        Queue<Node> qu = new LinkedList<>();
        qu.add(node1);
        while(!qu.isEmpty()){
            Node currN=qu.poll();
            board[currN.left][currN.right]='#';
            for(int[] dir: dirs){
                int nextI = currN.left+dir[0];
                int nextJ = currN.right+dir[1];
                if(nextI<n && nextI>-1 && nextJ<m && nextJ>-1 && board[nextI][nextJ]=='O'){
                    qu.add(new Node(nextI,nextJ));
                }
            }
        }
    }
}

class Node{
    int left;
    int right;
    public Node(int left,int right){
        this.left = left;
        this.right = right;
    }
}
