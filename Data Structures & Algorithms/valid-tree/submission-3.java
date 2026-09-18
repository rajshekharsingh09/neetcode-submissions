class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length){
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(0,graph,visited);
        for(boolean v: visited){
            if(!v) return false;
        }

        return true;

    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node]=true;
        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited);
            }
        }
    }

}
