package LC200NumberOfIslands;
//Approach 1: DFS
public class Solution {
    private void dfs(char[][] grid, int r, int c){ // 搜索到 grid[r][c] row co位置l 
        int rows = grid.length;
        int cols = grid[0].length;
        // corner case
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0'){
            return;
        }
        
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1,c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        
    }
    
    public int numIslands(char[][] grid) {
        // base case
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int num_islands = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
}