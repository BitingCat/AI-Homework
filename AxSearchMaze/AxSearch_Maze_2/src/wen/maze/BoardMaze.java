package wen.maze;

import javax.swing.JFrame;

public class BoardMaze extends JFrame {
	public BoardMaze() {
		//---set the property of the mazeBoard
		setSize(1000, 800);
		setTitle("Maze");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//---
	}
}
