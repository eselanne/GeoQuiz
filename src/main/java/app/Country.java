package app;

public class Country {
	String name;
	int x;
	int y;
	boolean guessed;
	
	public Country (String s, int x, int y) {
		this.name = s;
		this.x = x;
		this.y = y;
		this.guessed = false;
	}
	
	public String getName () {
		return this.name;
	}
	public int getXcoord () {
		return this.x;
	}
	public int getYcoord () {
		return this.y;
	}
	public boolean getIsGuessed () {
		return guessed;
	}
	
	public void setIsGuessed() {
		this.guessed = true;
	}
}
