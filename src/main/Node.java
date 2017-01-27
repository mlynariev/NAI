package main;

public class Node{
	public int x;
	public int y;
	int hCost = 0;
	int fCost = 0;
	Node parent;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "("+this.x+", "+this.y+")";
	}
}
