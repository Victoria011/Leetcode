package LC1041RobotBoundedInCircle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		for(int i=0;i<directions.length; i++) {
			for(int j=0; j<directions[0].length; j++) {
				System.out.print(Integer.toString(directions[i][j])+" ");
			}
			System.out.print("\n");
		}
//		System.out.println();
	}

}

//directions
//0 1 
//1 0 
//0 -1 
//-1 0 