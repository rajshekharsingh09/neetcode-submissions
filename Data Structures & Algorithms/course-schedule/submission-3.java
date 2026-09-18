class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]= new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int[] it: prerequisites){
            graph[it[1]].add(it[0]);
            indegree[it[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.offer(i);
        }

        int completed=0;

        while(!q.isEmpty()){
            int node = q.poll();
            completed++;
            for(int next:graph[node]){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        return completed==numCourses;
    }

    
}
