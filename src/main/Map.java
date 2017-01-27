package main;

import java.util.PriorityQueue;

public class Map {

	static int startX, startY;
	static int endX, endY;
	static Node [][] map = new Node[5][5];
	static boolean isClosed[][] = null;
	
	static PriorityQueue<Node> open;
	
	public static void setWall(int x, int y){
		map[x][y] = null;
	}
	
	public static void setStartNode(int x, int y){
		startX = x;
		startY = y;
	}
	
	public static void setEndNode(int x, int y){
		endX = x;
		endY = y;
	}
	
	public static void calculateMove(Node current, Node n, int cost){
    if(n == null || isClosed[n.x][n.y])return;
    int n_final_cost = n.hCost+cost;
    
    boolean inOpen = open.contains(n);
    if(!inOpen || n_final_cost<n.fCost){
        n.fCost = n_final_cost;
        n.parent = current;
        if(!inOpen)open.add(n);
    }
	}
}
