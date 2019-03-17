package wen.window;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class ChessBoard extends JFrame {
	JButton chessButton[] = new JButton[9];
	int chessBoard[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
	int chessValue;
	String playerMan;
	int chessPosition;
	
	public ChessBoard() {
		setSize(500, 400);
		setTitle("Tic-Tac-Toe");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel upPanel = new JPanel();
		JPanel checkPanel = new JPanel();
		JPanel downPanel = new JPanel();
		
		//JRadioButton		
		JRadioButton rb_AI = new JRadioButton("AI");
		rb_AI.setSelected(true);
		JRadioButton rb_player = new JRadioButton("player");
		ButtonGroup checkGroup = new ButtonGroup();
		checkGroup.add(rb_AI);
		checkGroup.add(rb_player);
		
		checkPanel.add(rb_AI);
		checkPanel.add(rb_player);
		//set border to choose
		checkPanel.setBorder(new TitledBorder(null, "Choose", TitledBorder.LEADING, TitledBorder.TOP, null,null));
		//TextField
		//TextField depthText = new TextField("2", 10);
		//JButton
		JButton startButton = new JButton("Start");
			
		
		upPanel.add(checkPanel);
		//upPanel.add(depthText);
		upPanel.add(startButton);
		
		setLayout(null);
		upPanel.setBounds(0, 0, 500, 100);
		
		//only can use 'setBounds' when the frame's layout is null
		add(upPanel);
			
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//----clear	chessBoard
				playerMan = "";
				chessPosition = -1;
				for(int i = 0; i < 9; i++) {
					chessBoard[i] = 1;
				}
				for(int i = 0; i < 9; i++) {
					chessButton[i].setText("");
					chessButton[i].setEnabled(true);
				}
				//----clear chessBoard	
				
				//----the first chess
				if(rb_AI.isSelected()) {
					findPosition();
					playerMan = "player";
				}else {
					playerMan = "player";
				}
				//----the first chess
			}	
		});
		
		//downPanel button
		downPanel.setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 9; i++) {
			chessButton[i] = new JButton();
			chessButton[i].setEnabled(false);
			downPanel.add(chessButton[i]);
		}
		downPanel.setBounds(100, 100, 300, 200);
		//set border to chessBoard
		downPanel.setBorder(new TitledBorder(null, "ChessBoard", TitledBorder.LEADING, TitledBorder.TOP, null,null));
		add(downPanel);
		
		for(int i = 0; i < 9; i++) {			
			chessButton[i].addActionListener(new ChessAction());
		}				
	}
	
	void AIPlaying(int position) {
		chessButton[position].doClick();
	}
	
	void playerPlaying() {
		
	}
	
	//judge the chessBoard is full or not
	boolean isChessBoardFull() {
		boolean index = true;
		for(int e : chessBoard) {
			if(e == 1)index = false;
		}
		return index;
	}
	
	
	//set button to unable
	void setChessButtonUnable() {
		for(int i = 0; i < 9; i++) {
			chessButton[i].setText("");
			chessButton[i].setEnabled(false);
		}
	}
	
	int chessAnalysis() {
		int victoryTerm[][] = {{0, 1, 2}, {0, 4, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {3, 4, 5}, {6, 7, 8}};
		//eight victory term	
		for(int[] a : victoryTerm) {
			if(isChessLine(chessButton[a[0]], chessButton[a[1]], chessButton[a[2]])) {
				if("O".equals(chessButton[a[0]].getText()))return 1;
				else if("X".equals(chessButton[a[0]].getText()))return 2;
			}
		}//judge chessResult
		return 3;
	}
	
	boolean isChessLine(JButton button_1, JButton button_2, JButton button_3) {
		if(button_1.getText().equals(button_2.getText()) && button_2.getText().equals(button_3.getText())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	class ChessAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//ButtonListener
			for(int i = 0; i < 9; i++) {
				if(e.getSource() == chessButton[i]) {
					if("player".equals(playerMan)) {
						//playerPlaying
						chessButton[i].setText("O");
						chessButton[i].setEnabled(false);
						chessBoard[i] = 0;
						playerMan = "AI";				
						break;
					}else {
						//AIPlaying
						chessButton[i].setEnabled(false);
						chessButton[i].setText("X");
						chessBoard[i] = 0;						
						playerMan = "player";
						break;
					}
					
				}
			}
			switch(chessAnalysis()) {
			case 1:
				JOptionPane.showMessageDialog(null, "victory", "result", JOptionPane.INFORMATION_MESSAGE);
				//set button to unable
				setChessButtonUnable();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "defeat", "result", JOptionPane.INFORMATION_MESSAGE);
				//set button to unable
				setChessButtonUnable();
				break;
			case 3:
				if(isChessBoardFull()) {
					JOptionPane.showMessageDialog(null, "dogfall", "result", JOptionPane.INFORMATION_MESSAGE);
					//set button to unable
					setChessButtonUnable();
				}else {
					//playing when player is AI
					if("AI".equals(playerMan)) {
						findPosition();
						playerMan = "player";
					}
				}
				break;
			}
					
		}
	}
	
	

	
	
	void findPosition() {
		
		int analysis = -100;
		int value = 100;
		int topValue = -100;
		int position = 0;
		
		int testBoard_1[] = chessBoard;
		String[] testChess_1 = new String[9];
		for(int t = 0; t < 9; t++) {
			if("X".equals(chessButton[t].getText())) testChess_1[t] = "X";
			else if("O".equals(chessButton[t].getText())) testChess_1[t] = "O";
			else testChess_1[t] = "1";
		}
		
		for(int i = 0; i < 9; i++) {
			if(testBoard_1[i] == 0) continue;
			value = 100;		
			
			testBoard_1[i] = 0;
			testChess_1[i] = "X";
			
			if(judge(testChess_1, "X")) value = 100;
			else {
				for(int j = 0; j < 9; j++) {
					if(testBoard_1[j] == 0)continue;
					int Xcount = 0, Ocount = 0;
					int tempValue;
					testBoard_1[j] = 0;
					testChess_1[j] = "O";
					
					if(judge(testChess_1, "O")) value = -100;
					else {
						Xcount = countLine(testBoard_1, testChess_1, "X");	
						Ocount = countLine(testBoard_1, testChess_1, "O");		
											
						tempValue = Xcount - Ocount;
						if(tempValue <= value) value = tempValue;
											
					}		
					testBoard_1[j] = 1;
					testChess_1[j] = "1";		
				}
			}
			
			testBoard_1[i] = 1;
			testChess_1[i] = "1";
			
			if(analysis < value) {
				analysis = value;
				position = i;
			}
			if(analysis > topValue) {
				topValue = analysis;
			}
		}
		System.out.println(position);
		AIPlaying(position);
		
	}
	
	
	boolean judge(String[] testChess, String index){
		int victoryTerm[][] = {{0, 1, 2}, {0, 4, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {3, 4, 5}, {6, 7, 8}};
		//eight victory term	
		for(int[] a : victoryTerm) {
			if(testChess[a[0]].equals(testChess[a[1]]) && testChess[a[1]].equals(testChess[a[2]])) {
				if(index.equals(testChess[a[0]])) return true;
			}
		}//judge chessResult
		return false;
	}
	
	
	int countLine(int[] testBoard, String[] testChess, String index) {
		int count = 0;
		for(int i = 0; i < 9; i++) {
			if(testBoard[i] == 1) testChess[i] = index;
		}
		
		int victoryTerm[][] = {{0, 1, 2}, {0, 4, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {3, 4, 5}, {6, 7, 8}};
		//eight victory term	
		for(int[] a : victoryTerm) {
			if(testChess[a[0]].equals(testChess[a[1]]) && testChess[a[1]].equals(testChess[a[2]])) {
				if(index.equals(testChess[a[0]])) {
					count++;
				}
			}
		}
		for(int i = 0; i < 9; i++) {
			if(testBoard[i] == 1) testChess[i] = "1";
		}
		return count;
	}
	
	
	
}


