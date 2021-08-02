/*
Optimized Solution:
Time: O(n^2)
Space: O(n^2) for internal stack

Idea: The previous approach involved recalculation of island areas with each iteration.
      In this solution we will cache the already computed area.
      
      1. For every one in the grid
        - Calculate the area using dfs, mark that particular island by some id and store the area in a map.
      2. For every zero in the grid
        - move in all four directions and get the appropriate island area from the map and add all such areas in all four direction.
      3. Return the max area.
*/

class MakingALargeIsland2 {
    public int largestIsland(int[][] grid) {
        // length of grid
        int n = grid.length;
        
        // island id (0 and 1 are already present)
        int id = 2;
        
      // map to store island area
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0, 0);
        
      // Iterate the grid and for every one identified calculate the area.
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 1) {
                    
                    int area = dfs(grid, i, j, id);
                    
                    map.put(id, area);
                    
                    id++;
                }
            }
        }
        
        int ans = map.getOrDefault(2, 0);
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 0) {

					int totalArea = 0;

					Set<Integer> set = new HashSet<Integer>();
					// left
					if (j - 1 >= 0 && !set.contains(grid[i][j - 1])) {
					
						totalArea += map.get(grid[i][j - 1]);
						
						set.add(grid[i][j -1]);
					}
						
					// right
					if (j + 1 < n && !set.contains(grid[i][j + 1])) {
						
						totalArea += map.get(grid[i][j + 1]);
						
						set.add(grid[i][j + 1]);
					}
					// up
					if (i - 1 >= 0 && !set.contains(grid[i - 1][j])) {
						
						totalArea += map.get(grid[i - 1][j]);
						set.add(grid[i - 1][j]);
					}
					// down
					if (i + 1 < n && !set.contains(grid[i + 1][j])) {
						
						totalArea += map.get(grid[i + 1][j]);
						set.add(grid[i + 1][j]);
					}

					ans = Math.max(ans, 1 + totalArea);
				}
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int x, int y, int id) {
        
        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] != 1)
            return 0;
        
        grid[x][y] = id;
        
        int val = 1 + dfs(grid, x, y - 1, id) + dfs(grid, x, y + 1, id) 
            + dfs(grid, x - 1, y, id) + dfs(grid, x + 1, y, id);
        
        return val;
    }
}
