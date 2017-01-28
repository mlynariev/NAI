package main;

import java.util.PriorityQueue;

public class PathFinder {
	public static final int DIAGONAL_COST = 14;
	public static final int BEELINE_COST = 10;
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
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

	
	public static void findPath(String tCase, int x, int y, int startX, int startY, int endX, int endY, int[][] wall, int[][] road, int[][] mood){
		System.out.println("********************Start*********************");
		System.out.println(tCase);
		System.out.println("================================================");
		
		grid = new Node[x][y];
		Map.isClosed = new boolean[x][y];
		
		open = new PriorityQueue<>((Object o1, Object o2) -> {
			Node c1 = (Node)o1;
			Node c2 = (Node)o2;
			
			return c1.fCost<c2.fCost?-1:c1.fCost>c2.fCost?1:0;
		});
		
		Map.setStartNode(startX, startY);
		Map.setEndNode(endX, endY);
		
		System.out.println("Koszty heurystyki");
		for (int i = 0; i < x; ++i){
			for (int j = 0; j < y; ++j){
				grid[i][j] = new Node(i, j);
				grid[i][j].hCost = Math.abs(i-endX)+Math.abs(j-endY);
				if (i==startX && j==startY) System.out.print("$  ");
				else if (i==endX && j==endY) System.out.print("E  ");
				else if (grid[i][j]!=null) System.out.printf("%-3d", grid[i][j].hCost);
			}
			System.out.println();
		}
		System.out.println("================================================");
		System.out.println();
		
		grid[startX][startY].fCost = 0;
		
		for (int i = 0; i < wall.length; ++i){
			Map.setWall(wall[i][0], wall[i][1]);
		}
		
		for (int i = 0; i < road.length; ++i){
			Map.setRoad(road[i][0], road[i][1]);
		}
		
		for (int i = 0; i < mood.length; ++i){
			Map.setMood(mood[i][0], mood[i][1]);
		}
		
		System.out.println("================================================");
		System.out.println("Siatka: ");
		for (int i = 0; i < x; ++i){
			for (int j = 0; j < y; ++j){
				if (i==startX && j==startY) System.out.print("S  ");
				else if (i==endX && j==endY) System.out.print("E  ");
				else if (grid[i][j]!=null) System.out.print(grid[i][j].type+"  ");
				else System.out.print("W  ");
			}
			System.out.println();
		}
		System.out.println("================================================");
		System.out.println();
		System.out.println("================================================");
		
		aStar();
		System.out.println("Koszty ruchów");
		for (int i = 0; i < x; ++i){
			for (int j = 0; j < y; ++j){
					
					
					if(grid[i][j]!=null){
						switch(grid[i][j].type){
						case "M": System.out.printf("-%-5d", grid[i][j].fCost); break;
						case "R": System.out.printf("+%-5d", grid[i][j].fCost); break;
						case "F": System.out.printf("=%-5d", grid[i][j].fCost); break;
						}
					}
					else System.out.printf("[]    ");
				}
			System.out.println();
			}
		System.out.println("================================================");
		System.out.println();
		
		if(Map.isClosed[endX][endY]){
			System.out.println("Œcie¿ka: ");
			Node current = grid[endX][endY];		
			System.out.print(current);
			int steps = 0;
			while(current.parent!=null){
				steps++;
				System.out.print(" -> "+current.parent);
				current = current.parent;	
			}
			System.out.println();
			System.out.println("Liczba kroków: " +steps);
			System.out.println();
		}
		else System.out.println("Nie ma mo¿liwej œcie¿ki");
		
		System.out.println("********************Koniec********************");
		System.out.println();
	}
	
}
