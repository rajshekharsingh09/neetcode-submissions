class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            mp.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, mp, state)) return false;
        }
        return true;
    }

    public boolean hasCycle(int node, Map<Integer, List<Integer>> mp, int[] state){

                if (state[node] == 1) return true;  // cycle detected
        if (state[node] == 2) return false; // already processed

        state[node] = 1; // mark as visiting

        for (int neighbor : mp.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(neighbor, mp, state)) return true;
        }

        state[node] = 2; // mark as visited
        return false;
    }
}
