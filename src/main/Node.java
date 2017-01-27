package main;

public class Node{
	public int x;
	public int y;
	int hCost = 0;
	int mCost = 0;
	int fCost;
	Node parent;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "("+this.x+", "+this.y+")";
	}
}
