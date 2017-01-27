package main;

import java.util.PriorityQueue;

public class PathFinder {
	public static final int DIAGONAL_COST = 14;
	public static final int BEELINE_COST = 10;
	
	public static Node[][] grid = new Node[5][5];
	static PriorityQueue<Node> open;
	
	public static void aStar(){
		open.add(grid[Map.startX][Map.startY]);
		
		Node current;
		
		while(true){
			current = open.poll();
			if (current == null) break;
			Map.isClosed[current.x][current.y]=true;
			
			if (current.equals(grid[Map.endX][Map.endY])){
				return;
			}
			
			Node n;
			if (current.x-1>=0){
				n = grid[current.x-1][current.y];
				Map.calculateMove(current, n, current.fCost+BEELINE_COST);
				
				if (current.y-1>=0){
					n = grid[current.x][current.y-1];
					Map.calculateMove(current, n, current.fCost+DIAGONAL_COST);
				}
				
				if (current.y+1<grid[0].length){
					n = grid[current.x-1][current.y+1];
					Map.calculateMove(current, n, current.fCost+DIAGONAL_COST);
				}
			}
			
			if (current.y-1>=0){
				n = grid[current.x][current.y-1];
				Map.calculateMove(current, n, current.fCost+BEELINE_COST);
			}
			
			if (current.y+1<grid[0].length){
				n = grid[current.x][current.y+1];
				Map.calculateMove(current, n, current.fCost+BEELINE_COST);
			}
			
			if(current.x+1<grid.length){
        n = grid[current.x+1][current.y];
        Map.calculateMove(current, n, current.fCost+BEELINE_COST); 

        if(current.y-1>=0){
            n = grid[current.x+1][current.y-1];
            Map.calculateMove(current, n, current.fCost+DIAGONAL_COST); 
        }
        
        if(current.y+1<grid[0].length){
           n = grid[current.x+1][current.y+1];
           Map.calculateMove(current, n, current.fCost+DIAGONAL_COST); 
        }  
			}	
		}
	}
}
