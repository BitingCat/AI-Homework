package wen.animal.model;

public class Data {
	private String id;
	private String point;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPoint(String point) {
		this.point = point;
	}
	
	public String getPoint() {
		return point;
	}
	
	public String toString() {
		return id + "+" + point + " ";
	}
}
