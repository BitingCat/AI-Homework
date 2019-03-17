package wen.animal.model;

public class Goal {
	private String id;
	private String name;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return id + "+" + name + " ";
	}
}
