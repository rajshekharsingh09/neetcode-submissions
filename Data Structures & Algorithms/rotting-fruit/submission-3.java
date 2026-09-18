class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int n, m;
    final int INF = Integer.MAX_VALUE / 2; // avoid overflow on t+1

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int[][] time = new int[n][m];
        for (int[] row : time) {
            Arrays.fill(row, INF);
        }

        int fresh = 0;

        // 1. Start DFS from every rotten fruit
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, time, i, j, 0);
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh fruits at all
        if (fresh == 0) {
            return 0;
        }

        // 2. Compute answer from time[][] only for fresh cells
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == INF) {
                        // fresh but never reached by any rotten fruit
                        return -1;
                    }
                    ans = Math.max(ans, time[i][j]);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int[][] time, int i, int j, int t) {
        // out of bounds
        if (i < 0 || i >= n || j < 0 || j >= m) return;

        // cannot pass through empty cells
        if (grid[i][j] == 0) return;

        // we already have an equal or better (smaller) time, no need to continue
        if (t >= time[i][j]) return;

        // update best time for this cell
        time[i][j] = t;

        // spread to neighbors
        for (int[] d : dirs) {
            dfs(grid, time, i + d[0], j + d[1], t + 1);
        }
    }
}
