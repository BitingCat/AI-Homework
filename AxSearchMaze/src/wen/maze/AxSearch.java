package wen.maze;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class AxSearch {
//	public ArrayList<MazePoint> open = new ArrayList();
//	public ArrayList<MazePoint> close = new ArrayList();
	public MazePoint nodeNow;
	public MazePoint nodeTemp;
	public MazePoint nodeNext;
	public MazePoint begin;
	public MazePoint end;
	public OpenClose oc;
	public LinkedList<MazePoint> open = new LinkedList();
	public LinkedList<MazePoint> close = new LinkedList();
	public int g;
	public int h;
	public int f;
	public LinkedList<MazePoint> search(MazePoint[][] mazePoint, int size) {
		begin = new MazePoint();
		end = new MazePoint();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(mazePoint[i][j].getZ() == 8)begin = mazePoint[i][j];
				if(mazePoint[i][j].getZ() == 4)end = mazePoint[i][j];
				System.out.print(mazePoint[i][j].getX() + "" + mazePoint[i][j].getY() + " " + mazePoint[i][j].getZ() + "   ");
			}
			System.out.println();
		}
		System.out.println("begin : " + begin.getX() + "" + begin.getY());
		System.out.println("end : " + end.getX() + "" + end.getY());
		
		g = 0;
		h = Math.abs(end.getX() - begin.getX()) + Math.abs(end.getY() - begin.getY());
		f = g + h;
		begin.setG(g);
		begin.setH(h);
		begin.setF(f);
		nodeNow = begin;
		open.add(begin);
		int index = 0;
		oc = new OpenClose();
		while(true) {
			
			if(nodeNow.getX() - 1 >= 0 && mazePoint[nodeNow.getX() - 1][nodeNow.getY()].getZ() != 0 && mazePoint[nodeNow.getX() - 1][nodeNow.getY()].getZZ() != 0 && !oc.isExist(mazePoint[nodeNow.getX() - 1][nodeNow.getY()], open)) {
				g = nodeNow.getG() + 1;
				h = Math.abs(end.getX() - (nodeNow.getX() - 1)) + Math.abs(end.getY() - nodeNow.getY());
				f = g + h;
				mazePoint[nodeNow.getX() - 1][nodeNow.getY()].setG(g);
				mazePoint[nodeNow.getX() - 1][nodeNow.getY()].setH(h);
				mazePoint[nodeNow.getX() - 1][nodeNow.getY()].setF(f);
				open.addFirst(mazePoint[nodeNow.getX() - 1][nodeNow.getY()]);
			}
			if(nodeNow.getX() + 1 < size && mazePoint[nodeNow.getX() + 1][nodeNow.getY()].getZ() != 0 && mazePoint[nodeNow.getX() + 1][nodeNow.getY()].getZZ() != 0 && !oc.isExist(mazePoint[nodeNow.getX() + 1][nodeNow.getY()], open)) {
				g = nodeNow.getG() + 1;
				h = Math.abs(end.getX() - (nodeNow.getX() + 1)) + Math.abs(end.getY() - nodeNow.getY());
				f = g + h;
				mazePoint[nodeNow.getX() + 1][nodeNow.getY()].setG(g);
				mazePoint[nodeNow.getX() + 1][nodeNow.getY()].setH(h);
				mazePoint[nodeNow.getX() + 1][nodeNow.getY()].setF(f);
				open.addFirst(mazePoint[nodeNow.getX() + 1][nodeNow.getY()]);
			}
			if(nodeNow.getY() - 1 >= 0 && mazePoint[nodeNow.getX()][nodeNow.getY() - 1].getZ() != 0 && mazePoint[nodeNow.getX()][nodeNow.getY() - 1].getZZ() != 0 && !oc.isExist(mazePoint[nodeNow.getX()][nodeNow.getY() - 1], open)) {
				g = nodeNow.getG() + 1;
				h = Math.abs(end.getX() - (nodeNow.getX())) + Math.abs(end.getY() - (nodeNow.getY() - 1));
				f = g + h;
				mazePoint[nodeNow.getX()][nodeNow.getY() - 1].setG(g);
				mazePoint[nodeNow.getX()][nodeNow.getY() - 1].setH(h);
				mazePoint[nodeNow.getX()][nodeNow.getY() - 1].setF(f);
				open.addFirst(mazePoint[nodeNow.getX()][nodeNow.getY() - 1]);
			}
			if(nodeNow.getY() + 1 < size && mazePoint[nodeNow.getX()][nodeNow.getY() + 1].getZ() != 0 && mazePoint[nodeNow.getX()][nodeNow.getY() + 1].getZZ() != 0 && !oc.isExist(mazePoint[nodeNow.getX()][nodeNow.getY() + 1], open)) {
				g = nodeNow.getG() + 1;
				h = Math.abs(end.getX() - (nodeNow.getX())) + Math.abs(end.getY() - (nodeNow.getY() + 1));
				f = g + h;
				mazePoint[nodeNow.getX()][nodeNow.getY() + 1].setG(g);
				mazePoint[nodeNow.getX()][nodeNow.getY() + 1].setH(h);
				mazePoint[nodeNow.getX()][nodeNow.getY() + 1].setF(f);
				open.addFirst(mazePoint[nodeNow.getX()][nodeNow.getY() + 1]);
			}
			for(MazePoint a : open) {
				if(a.getX() == nodeNow.getX() && a.getY() == nodeNow.getY()) {
					mazePoint[nodeNow.getX()][nodeNow.getY()].setZZ(0);
					open.remove(open.indexOf(a));		
					if(!oc.isExist(a, close))close.add(a);
					break;
				}
			}
			System.out.println("nodeNow: " + nodeNow.getX() + "" + nodeNow.getY());
			int maxIndex = 0;
			int maxF = 100; 
			for(MazePoint e : open) {
				if(e.getF() < maxF) {
					maxF = e.getF();
					maxIndex = open.indexOf(e);
				}
			}
			
			if(nodeNow.getX() == end.getX() && nodeNow.getY() == end.getY()) {
				System.out.println("Find the endPoint");
				break;
			}
			if(open.isEmpty() && nodeNow.getX() != end.getX() && nodeNow.getY() != end.getY()) {
				System.out.println("The maze is closed");
				break;
			}
			
			
			nodeNow = open.get(maxIndex);
			System.out.println("nodeNext: " + nodeNow.getX() + "" + nodeNow.getY());
			
	
			if(index == 1000)break;
		}
		
		System.out.print("\nthe open is: ");
		for(MazePoint e : open) {
			System.out.print(e.getX() + "" + e.getY() + "" + e.getF() + "   ");
		}
		
		System.out.println();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(mazePoint[i][j].getF() + "   ");
			}
			System.out.println();
		}
		
		return close;
	
	}
}
