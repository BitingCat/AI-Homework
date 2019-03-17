package wen.maze;

import java.util.ArrayList;
import java.util.LinkedList;

public class OpenClose {
	public boolean isExist(MazePoint testPoint, LinkedList<MazePoint> table) {
		for (MazePoint e : table) {
			if(e.getX() == testPoint.getX() && e.getY() == testPoint.getY())return true;
		}
		return false;
	}
}