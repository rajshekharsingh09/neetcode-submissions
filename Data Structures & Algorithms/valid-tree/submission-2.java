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
            int rootA = findRoot(edge[0],parent);
            int rootB = findRoot(edge[1],parent);
            if(rootA==rootB){
                return false;
            } 
            parent[rootB]=rootA;
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
