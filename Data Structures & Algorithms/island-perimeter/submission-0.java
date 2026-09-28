class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int perimeter = 0;
        int directions[][] = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0,-1 }};
        Queue<int[]> q = new LinkedList<>();
        boolean isvisited[][] = new boolean[n][m];
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1&&isvisited[i][j]==false) {
                    isvisited[i][j] = true;
                    q.add(new int[] {i, j});
                }

                while (!q.isEmpty()) {
                    int u[] = q.poll();
                    int r = u[0];
                    int c = u[1];
                    for (int dir[] : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= n || nr < 0 || nc >= m || nc < 0 || grid[nr][nc] == 0) {
                            perimeter++;
                        
                        } else if (isvisited[nr][nc] == false) {
                            isvisited[nr][nc] = true;
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
                return perimeter;
    }
}