package main;

public class Map {

	static int startX, startY;
	static int endX, endY;
	static boolean isClosed[][] = null;
	
	public static void setWall(int x, int y){
		PathFinder.grid[x][y] = null;
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
    
    boolean inOpen = PathFinder.open.contains(n);
    if(!inOpen || n_final_cost<n.fCost){
        n.fCost = n_final_cost;
        n.parent = current;
        if(!inOpen)PathFinder.open.add(n);
    }
	}
}
