package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PathFinder.findPath("#1 z dodatkowymi polami", 7, 7, 2, 1, 5, 4, new int[][]{{4,1},{4,3},{5,3},{2,3}}, new int[][]{{4,2},{5,2},{6,2},{6,3},{6,4}}, new int[][]{{5,4},{4,4},{3,3},{3,2}});
		//PathFinder.findPath("#1 ze zwyk³ymi polami", 7, 7, 2, 1, 5, 4, new int[][]{{4,1},{4,3},{5,3},{2,3}}, new int[][]{}, new int[][]{});
		
		//PathFinder.findPath("#2 ze zwyk³ymi polami", 5, 5, 0, 0, 0, 4, new int[][]{}, new int[][]{}, new int[][]{});
		//PathFinder.findPath("#2 z dodatkowymi polami", 5, 5, 0, 0, 0, 4, new int[][]{}, new int[][]{{1,0},{1,1},{1,2},{1,3},{1,4}}, new int[][]{{0,1},{0,2},{0,3}});
		
		//PathFinder.findPath("#3 brak œcie¿ki", 4, 4, 0, 0, 3, 3, new int[][]{{2,3},{2,2},{3,2}}, new int[][]{}, new int[][]{});
		
		PathFinder.findPath("#4 skomplikowana", 
				20, 20, // wielkoœæ siatki
				9, 13, // punkt startowy
				18, 3, // punkt koncowy
				new int[][]{{12,12},{11,12},{10,12},{9,12},{8,12},{7,12},{6,12},{13,7},{14,7},{15,7},{16,7},{16,8},{16,9},{17,9},{18,9},{19,9}}, // œciany
				new int[][]{{8,13},{7,13},{6,13},{5,13},{5,12},{5,11},{6,11},{7,11},{8,11},{9,11},{10,11},{11,11}}, // drogi
				new int[][]{{12,8},{12,9}}); // b³ota
		}
}
