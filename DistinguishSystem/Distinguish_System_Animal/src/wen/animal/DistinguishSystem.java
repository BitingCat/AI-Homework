package wen.animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import wen.animal.io.SourceDataReader;
import wen.animal.model.Data;
import wen.animal.model.Goal;
import wen.animal.model.Rules;

public class DistinguishSystem {
	
	private ArrayList<Rules> rules = new ArrayList<>();
	private ArrayList<Data> data = new ArrayList<>();
	private ArrayList<Goal> goal = new ArrayList<>();
	
	public String distinguish(ArrayList<String> numList){
		String info = "";
		StringBuilder sb = new StringBuilder();
		for(String e : numList) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		SourceDataReader sdr = new SourceDataReader();
		rules = sdr.getRules();
		data = sdr.getData();
		goal = sdr.getGoal();
		
		Map<String, Integer> weigth = new HashMap<>();
		Stack<String> result = new Stack<>();
		int maxWeight = 0;
		for(Rules r : rules) {
			int currentWeight = r.getWeigth(numList);
			if (0 == currentWeight) {
				continue;
			}
			weigth.put(String.valueOf(r.getId()), currentWeight);
			if (currentWeight > maxWeight) {
				result.clear();
				result.push(r.getId());
				maxWeight = currentWeight;
			} else if (currentWeight == maxWeight) {
				result.push(r.getId());
			}
		}
		int hasFeatureCount = 0;
		sb.append("条件不足，不过包含这些特征的有");		
		int index = 0;
		while (index < result.size()) {
			if(getRepeat(result, result.get(index)) > 1) {
				result.remove(index);
			}	
			index++;
		}
		while (!result.isEmpty()) {
			String cur = result.pop();
			for(Rules e : rules) {
				if(e.getId().equals(cur)) {
					if(weigth.get(e.getId()) == numList.size()) {
						info = "可推理出该动物是" + getAnimal(e.getResult());
						break;
					} else {
						if (hasFeatureCount > 0) {
							sb.append(" 和 ");
						}
						++hasFeatureCount;
						sb.append(getAnimal(e.getResult()));
					}
					
				}
			}
		}	
		if (hasFeatureCount > 0) {
			info = sb.toString();
		}
		return info;
	}
	
	public String getAnimal(String id) {
		for(Data d : data) {
			if(d.getId().equals(id)) {
				return d.getPoint();
			}
		}
		for(Goal g : goal) {
			if(g.getId().equals(id)) {
				return g.getName();
			}
		}
		return "";
	}
	
	public int getRepeat(Stack<String> result, String id) {
		int num = 0;
		for(String e : result) {
			if(rules.get(Integer.parseInt(id)).getResult().equals(rules.get(Integer.parseInt(e)).getResult())) {
				num++;
			}
		}
		return num;
	}

}
