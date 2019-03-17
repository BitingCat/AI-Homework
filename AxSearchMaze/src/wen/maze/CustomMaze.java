package wen.maze;

public class CustomMaze {
	public MazePoint[][] mazePoint;
	public MazePoint[][] createMaze(int size) {
		mazePoint = new MazePoint[size][size];
		for(int i = 0; i < size; i++) {
			for(int j  = 0; j < size; j++) {
				mazePoint[i][j] = new MazePoint(i, j , 1);
				mazePoint[i][j].setF(0);
				mazePoint[i][j].setZZ(1);
			}
		}
		return mazePoint;
	} 
}
