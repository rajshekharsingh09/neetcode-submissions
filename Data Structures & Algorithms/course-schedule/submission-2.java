class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if(graph[prerequisites[i][0]]==null){
                graph[prerequisites[i][0]]= new ArrayList<>();
            }
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, state)) return false;
        }
        return true;
    }

    public boolean hasCycle(int node, List<Integer>[] graph , int[] state){

                if (state[node] == 1) return true;  // cycle detected
        if (state[node] == 2) return false; // already processed

        state[node] = 1; // mark as visiting

        if(graph[node]!=null){
            for (int neighbor : graph[node]) {
                if (hasCycle(neighbor, graph, state)) return true;
            }
        }


        state[node] = 2; // mark as visited
        return false;
    }
}
