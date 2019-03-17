package wen.maze;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GoMaze {
	public MazePoint[][] mazePoint;
	public JButton[][] mazeButton;
	public LinkedList<MazePoint> close = new LinkedList();
	public BoardMaze boardMaze;	
	JMenu menuHome;
	JMenu menuBegin;
	JMenu menuHelp;
	JMenu menu1;
	JMenu menu2;
	JPanel buttonPanel;
	int size = 8;
	int choose = 0;
	
	public GoMaze() {		
		action();
	}
	
	public void action() {
		boardMaze = new BoardMaze();		
		createButton();
		createMenu();
		
		
		menu1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choose = 1;
				System.out.println("Random");
				
			}
		});
		menu2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choose = 2;
				System.out.println("Custom");
				
				CustomMaze customMaze = new CustomMaze();
				mazePoint = customMaze.createMaze(size);
				
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						mazeButton[i][j].setEnabled(true);
						mazeButton[i][j].setText("");
					}
				}
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						mazeButton[i][j].addActionListener(new ButtonAction());
					}
				}
				
				
			}
		});
		menuBegin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int begin = 0;
				int end = 0;
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						if("begin".equals(mazeButton[i][j].getText())) {
							begin++;
						}
						if("end".equals(mazeButton[i][j].getText())) {
							end++;
						}
					}
				}
				if(begin != 1 || end != 1)JOptionPane.showMessageDialog(null, "Only can one begin and one end", "error", JOptionPane.INFORMATION_MESSAGE);
				else {
					System.out.println("Begin");
					switch(choose) {
					case 0:
						JOptionPane.showMessageDialog(null, "Please choose the 'Random' or 'Custom'!", "warning", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 1:
						
						break;
					case 2:
						AxSearch axSearch = new AxSearch();
						close = axSearch.search(mazePoint, size);
						System.out.print("\nthe close is: ");
						for(MazePoint a : close) {
							System.out.print(a.getX() + "" + a.getY() + "" + a.getF() + "   ");
						}
						for(int i = 0; i < size; i++) {
							for(int j = 0; j < size; j++) {
								mazeButton[i][j].setEnabled(false);
								for(MazePoint a : close) {
									Color c = new Color(1);
									if(i == a.getX() && j == a.getY()) {
										mazeButton[i][j].setBackground(c);
										break;
									}
								}
							}
						}
						break;
					}
				}
				
			}
		});
		
	}
	
	public void createButton() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(size, size));
		mazeButton = new JButton[size][size];	
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				mazeButton[i][j] = new JButton();
				mazeButton[i][j].setText("");
				mazeButton[i][j].setEnabled(false);
				buttonPanel.add(mazeButton[i][j]);
			}
		}
		boardMaze.add(buttonPanel);
	}
	
	
	public void createMenu() {
		JMenuBar menu = new JMenuBar();
		menuHome = new JMenu("Game",true);
		menuBegin = new JMenu("Begin", true);
		menuHelp = new JMenu("Help", true);
		menu1 = new JMenu("Random");
		menu2 = new JMenu("Custom");
		
		menuHome.add(menu1);
		menuHome.add(menu2);
		menu.add(menuHome);
		menu.add(menuBegin);
		menu.add(menuHelp);
		
		boardMaze.setJMenuBar(menu);
	}
	
	class ButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(e.getSource() == mazeButton[i][j]) {
						if("".equals(mazeButton[i][j].getText())) {
							mazeButton[i][j].setText("wall");
							mazePoint[i][j].setZ(0);
						}else if("wall".equals(mazeButton[i][j].getText())) {
							mazeButton[i][j].setText("begin");
							mazePoint[i][j].setZ(8);
						}else if("begin".equals(mazeButton[i][j].getText())) {
							mazeButton[i][j].setText("end");
							mazePoint[i][j].setZ(4);
						}else if("end".equals(mazeButton[i][j].getText())) {
							mazeButton[i][j].setText("");
							mazePoint[i][j].setZ(1);
						}
					}
				}
			}
		}
		
	}
}
