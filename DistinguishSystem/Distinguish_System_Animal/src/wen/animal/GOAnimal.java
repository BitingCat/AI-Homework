package wen.animal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GOAnimal {
	public AnimalBoard animal;
	public JCheckBox checkBox[];
	public ArrayList<String> numList;
	public DistinguishSystem ds;
	public GOAnimal() {
		ds = new DistinguishSystem();
	}
	
	public void GO() {
		animal = new AnimalBoard();
		initPanel();
	}
	
	public void initPanel() {
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		JButton checkButton = new JButton("judge"); 
		JLabel resultLabel = new JLabel("result");
		checkBox = new JCheckBox[27];
		
		checkBox[0] = new JCheckBox("有奶");
		checkBox[1] = new JCheckBox("有毛发");
		checkBox[2] = new JCheckBox("有羽毛");
		checkBox[3] = new JCheckBox("会飞");
		checkBox[4] = new JCheckBox("生蛋");
		checkBox[5] = new JCheckBox("哺乳动物");
		checkBox[6] = new JCheckBox("有爪");
		checkBox[7] = new JCheckBox("有犬齿");
		checkBox[8] = new JCheckBox("目盯前方");
		checkBox[9] = new JCheckBox("食肉动物");
		checkBox[10] = new JCheckBox("吃肉");
		checkBox[11] = new JCheckBox("有蹄");
		checkBox[12] = new JCheckBox("有蹄动物");
		checkBox[13] = new JCheckBox("反刍动物");
		checkBox[14] = new JCheckBox("黄褐色");
		checkBox[15] = new JCheckBox("黑色条纹");
		checkBox[16] = new JCheckBox("黑色斑点");
		checkBox[17] = new JCheckBox("长腿");
		checkBox[18] = new JCheckBox("长脖子");
		checkBox[19] = new JCheckBox("暗斑点");
		checkBox[20] = new JCheckBox("白色");
		checkBox[21] = new JCheckBox("不会飞");
		checkBox[22] = new JCheckBox("鸟");
		checkBox[23] = new JCheckBox("黑白色");
		checkBox[24] = new JCheckBox("会游泳");
		checkBox[25] = new JCheckBox("善飞");
		checkBox[26] = new JCheckBox("不怕风浪");
				
		for(int i = 0; i < 27; i++) {
			northPanel.add(checkBox[i]);
		}
		
		northPanel.add(checkButton);
		northPanel.add(resultLabel);
		
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numList = new ArrayList<>();
				for(int i = 0; i < 27; i++) {
					if(checkBox[i].isSelected()) {
						numList.add(String.valueOf(i));
					}
				}
				for(int j = 0; j < 27; j++) {
					checkBox[j].setSelected(false);
				}
				String info;
				if(numList.size() == 0) {
					info = "请选择特征";
				}else {
					info = ds.distinguish(numList);
				}
				resultLabel.setText(info);
				System.out.println(info);
			}
			
		});
		
		animal.setContentPane(northPanel);		
		animal.setVisible(true);
	}
}
