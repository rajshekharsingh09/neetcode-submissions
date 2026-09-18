class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,graph,visited,stack)){
                    return new int[0];
                }
            }
        }

        int index=0;
        int[] result = new int[numCourses];
        while(!stack.isEmpty()){
            result[index++]=stack.pop();
        }

        return result;
    }

    public boolean dfs(int node,List<List<Integer>> graph,int[] visited,Stack<Integer> stack){
        visited[node]=1;
        for(int neighbour: graph.get(node)){
            if(visited[neighbour]==1){
                return true;
            }
            if(visited[neighbour]==0){
                if(dfs(neighbour,graph,visited,stack)){
                    return true;
                }
            }
        }

        visited[node]=2;
        stack.push(node);
        return false;
    }
}
