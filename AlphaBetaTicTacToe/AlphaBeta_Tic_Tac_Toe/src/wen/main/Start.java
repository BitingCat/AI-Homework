package wen.main;

import java.awt.EventQueue;

import wen.window.ChessBoard;

public class Start {
	public static void main(String[] args) {
		System.out.println("hei");		
		EventQueue.invokeLater(new Runnable() {		
			@Override
			public void run() {
				ChessBoard chessBoard = new ChessBoard();
			}	
		});
	}
}
