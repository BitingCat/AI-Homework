//package wen.window;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//
//public class ChessAction implements ActionListener{
//	JButton[] chessButton;
//	boolean playerMan;
//	//playerWho == true; player
//	//playerWho == false; AI
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		for(int i = 0; i < 9; i++) {
//			if(e.getSource() == chessButton[i]) {
//				if(playerMan) {
//					chessButton[i].setText("O");
//					chessButton[i].setEnabled(false);
//					playerMan = false;
//					break;
//				}else {
//					chessButton[i].setText("X");
//					chessButton[i].setEnabled(false);
//					playerMan = true;
//					break;
//				}
//				
//			}
//		}
//	}
//	
//	public ChessAction(JButton[] chessButton, boolean playerMan) {
//		this.chessButton = chessButton;
//		this.playerMan = playerMan;
//	}
//
//}
