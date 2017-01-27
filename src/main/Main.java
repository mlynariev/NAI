package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathFinder.findPath("Jeden", 8, 8, 2, 2, 2, 6, new int[][]{{1,4},{2,4},{3,4}});
		PathFinder.findPath("Dwa", 5, 5, 0, 0, 4, 4, new int[][]{{0,4},{2,2},{3,1},{3,3}});
		PathFinder.findPath("Trzy", 7, 7, 2, 1, 5, 4, new int[][]{{4,1},{4,3},{5,3},{2,3}});
		PathFinder.findPath("Cztery", 5, 5, 0, 0, 4, 4, new int[][]{{3,4},{3,3},{4,3}});
	}

}
