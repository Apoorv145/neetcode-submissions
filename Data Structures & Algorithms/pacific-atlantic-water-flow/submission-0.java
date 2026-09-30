class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q1.add(new int[]{i, 0});
            pacific[i][0] = true;

            q2.add(new int[]{i, m - 1});
            atlantic[i][m - 1] = true;
        }

        for (int j = 0; j < m; j++) {
            q1.add(new int[]{0, j});
            pacific[0][j] = true;

            q2.add(new int[]{n - 1, j});
            atlantic[n - 1][j] = true;
        }

        int[][] directions = {
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
        };

        while (!q1.isEmpty()) {
            int[] curr = q1.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !pacific[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]) {

                    pacific[nr][nc] = true;
                    q1.add(new int[]{nr, nc});
                }
            }
        }

        while (!q2.isEmpty()) {
            int[] curr = q2.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !atlantic[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]) {

                    atlantic[nr][nc] = true;
                    q2.add(new int[]{nr, nc});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}