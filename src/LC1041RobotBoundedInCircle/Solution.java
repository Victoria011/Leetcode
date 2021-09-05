package LC1041RobotBoundedInCircle;


// 注意四个方向idx之间转换
public class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; // north, east,south,west
        int x=0, y=0;
        int idx = 0;
        
        for (char i : instructions.toCharArray()){
            if (i == 'L'){
                idx = (idx + 3) % 4;
            } else if (i == 'R'){
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        return ((x == 0 && y==0) || (idx != 0));
    }
}