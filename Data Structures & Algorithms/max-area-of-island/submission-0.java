class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
     int n=grid.length;
        int m=grid[0].length;
        int maxarea=0;
        Queue<int[]>q=new LinkedList<>();
        boolean isvisited[][]=new boolean[n][m];
        int directions[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!isvisited[i][j]){
                    int area=0;
                    isvisited[i][j]=true;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int curr[]=q.poll();
                        int r=curr[0];
                        int c=curr[1];
                        area++;
                    for(int dir[]:directions){
                        int nr=r+dir[0];
                        int nc=c+dir[1];
                        if (nr >= 0 && nr < n &&
                                nc >= 0 && nc < m &&
                                grid[nr][nc] == 1 &&
                                !isvisited[nr][nc]){
                            isvisited[nr][nc]=true;
                            q.add(new int[]{nr,nc});
                        
                        }
                        
                    }
                    }
                     maxarea=Math.max(area,maxarea);
                }
            }
        }
        return maxarea;
    }
}