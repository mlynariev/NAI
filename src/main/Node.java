package main;

public class Node {
	
	int heuristic;
	int f; // koszt ruchu
	int x, y; // wspó³rzêdne
	Node parent;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}

}
