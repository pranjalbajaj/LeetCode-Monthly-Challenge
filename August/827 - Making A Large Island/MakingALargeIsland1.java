/*
Brute force approach - Naive DFS
Time: O(n^4)
Space: O(n^2) -> visited array

Idea: 
1. For every zero in the grid 
    - make that zero as 1 and indentify the area of the island starting from that 1.
2. Return the max area indentified.

The solution is not optimized because we will be traversing the entire matrix again and again for every zero.
This will result in re-calculation of island areas which we have already calculated in the previous iteration.
*/

class MakingALargeIsland1 {
    public int largestIsland(int[][] grid) {
        
        // length of grid
        int n = grid.length;
        
        // max area to be returned
        int area = 0;
        
        // Iterate for every zero and update the max area
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 0) {
                    
                    // make the zero as 1 (we can change atmost one zero to one)
                    grid[i][j] = 1;
                    
                    // call the dfs method from (i, j) as source and get the net area.
                    area = Math.max(area, dfs(grid, new boolean[n][n], i, j));
                    
                    // set the value again to 0
                    grid[i][j] = 0;
                }
            }
        }
        
        return area == 0 ? n*n : area;
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        
        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || visited[x][y])
            return 0;
        
        if (grid[x][y] == 0)
            return 0;
        
        visited[x][y] = true;
        
        int val = 1 + dfs(grid, visited, x, y - 1) + dfs(grid, visited, x, y + 1) 
            + dfs(grid, visited, x - 1, y) + dfs(grid, visited, x + 1, y);
        
        return val;
    }
}
