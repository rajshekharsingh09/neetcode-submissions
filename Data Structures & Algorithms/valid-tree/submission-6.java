class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length){
            return false;
        }

        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }



        for(int[] edge: edges){
            int rootA = findRoot(edge[0],edges,parent);
            int rootB = findRoot(edge[1],edges,parent);
            if(rootA==rootB){
                return false;
            }
            parent[rootA]=rootB;
        }
        return true;
    }

    private int findRoot(int node, int[][] edges, int[] parent){
        if(parent[node]!= node){
            parent[node]=findRoot(parent[node],edges,parent);
        }
        return parent[node];
    }

}
