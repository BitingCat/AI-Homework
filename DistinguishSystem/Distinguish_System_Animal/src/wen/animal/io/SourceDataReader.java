package wen.animal.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import wen.animal.model.Data;
import wen.animal.model.Goal;
import wen.animal.model.Rules;
import wen.animal.tools.Directory;

public class SourceDataReader {
	private static final String PATH_RULES = "/lib/rules.txt";
	private static final String PATH_DATA = "/lib/data.txt";
	private static final String PATH_GOAL = "/lib/goal.txt";
	
	private ArrayList<Rules> rules = new ArrayList<>();
	private ArrayList<Data> data = new ArrayList<>();
	private ArrayList<Goal> goal = new ArrayList<>();
	
	public ArrayList<Rules> getRules(){
		try {
			BufferedReader in = new BufferedReader(
				new FileReader(Directory.getPath(PATH_RULES))
			);
			String s;
//			StringBuilder sb = new StringBuilder();
			int index = 0;
			while((s = in.readLine()) != null) {		
				rules.add(rulesSplit(s, String.valueOf(index)));
				index++;
			}
			in.close();
			
			System.out.println(rules.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}
		return rules;
	}
	
	public ArrayList<Data> getData() {
		try {
			BufferedReader in = new BufferedReader(
				new FileReader(Directory.getPath(PATH_DATA))
			);
			String s;
			while((s = in.readLine()) != null) {
				data.add(dataSplit(s));
			}
			in.close();
			System.out.println(data.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Goal> getGoal() {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(Directory.getPath(PATH_GOAL))
			);
			String s;
			while((s = in.readLine()) != null) {
				goal.add(goalSplit(s));
			}
			in.close();
			System.out.println(goal.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}
		return goal;
	}
	
	public Data dataSplit(String s1) {
		Data d = new Data();
		String[] s2 = s1.split("\\.");
		d.setId(s2[0]);
		d.setPoint(s2[1]);
		return d;	
	}
	
	public Goal goalSplit(String s1) {
		Goal g = new Goal();
		String[] s2 = s1.split("\\.");
		g.setId(s2[0]);
 		g.setName(s2[1]);
		return g;
	}
	
	
	public Rules rulesSplit(String s1, String index) {
		Rules rules = new Rules();
		ArrayList<String> rules1 = new ArrayList<>();
		String[] s2 = s1.split("->");
		String[] s3 = s2[0].split("\\*");
		for(int i = 0; i < s3.length; i++) {
			rules1.add(s3[i]);
		}
		rules.setResult(s2[1]);
		rules.setRulesList(rules1);
		rules.setId(index);
		return rules;
	}
	
	
}
