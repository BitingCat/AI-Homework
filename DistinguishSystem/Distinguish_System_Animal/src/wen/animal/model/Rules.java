package wen.animal.model;

import java.util.ArrayList;

public class Rules {
	private ArrayList<String> rulesList;
	private String result;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRulesList(ArrayList<String> rulesList) {
		this.rulesList = rulesList;
	}
	public ArrayList<String> getRulesList() {
		return rulesList;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
	}
	
	public int getWeigth(ArrayList<String> numList) {
		int index = 0;
		for(String n : numList) {
			for(String r : rulesList) {
				if(n.equals(r)) {
					index++;
					break;
				}
			
			}
		}
		
		return index;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String s : rulesList) {
			result.append(s + "+");
		}
		result.append(this.result);
		return result.toString();
	}
}
