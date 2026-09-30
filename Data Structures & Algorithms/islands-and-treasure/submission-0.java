class Solution {
    public void islandsAndTreasure(int[][] grid) {
        long land=2^31-1;
        int n=grid.length;
        int m=grid[0].length;
        int directions[][]=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]>q=new LinkedList<>();
        boolean isvisited[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            if(grid[r][c]==0&&isvisited[r][c]==false){
                isvisited[r][c]=true;
                q.add(new int[]{r,c});
            }
            for(int dir[]:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=n||nr<0||nc>=m||nc<0){
                    continue;
                }
                if(grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }
            
                grid[nr][nc] = grid[r][c] + 1;

                q.add(new int[]{nr, nc});
        }
    }
}
}

