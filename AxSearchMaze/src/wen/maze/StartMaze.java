package wen.maze;

import java.awt.EventQueue;

public class StartMaze {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				//start the maze
				GoMaze go = new GoMaze();
			}
		});
	}
}
