
/**
 * Jorge Marinez
 * Cabrillo College, Computer Science
 * Pengo Username: jmarinez
 * Email: jorgemarinez@sbcglobal.net
 * Filename: p6.java
 * Assignment06: Maze Generation with Disjoint Sets
 * Status: working/tested
 */

import java.util.Scanner;

/**
 *p6 class
 */
public class p6 {
	
	/**
     *Main
     */
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		
		Maze maze = new Maze(size);
		maze.createMaze();
		maze.print();
		
	}

}
