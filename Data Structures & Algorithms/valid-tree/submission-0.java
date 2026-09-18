class Solution {
    public boolean validTree(int n, int[][] edges) {
        if ( edges.length  != n-1){
            return false;
        }
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            int rootA = findRoot(nodeA,parent);
            int rootB = findRoot(nodeB,parent);
            if(rootA==rootB){
                return false;
            } 
            parent[rootA]=rootB;
        }
        return true;
    }

    public int findRoot(int node,int[] parent){
        if(parent[node]!=node){
            parent[node]=findRoot(parent[node],parent);
        }
        return parent[node];
    }
}
