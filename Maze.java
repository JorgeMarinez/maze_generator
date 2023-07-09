/**
 * Jorge Marinez
 * Cabrillo College, Computer Science
 * Pengo Username: jmarinez
 * Email: jorgemarinez@sbcglobal.net
 * Filename: Maze.java
 * Assignment06: Maze Generation with Disjoint Sets
 * Status: working/tested
 */

import java.util.*;

/**
 *Maze class.
 */
public class Maze {
	
	private DisjointSet sets;
	private int[] maze;
	private int size;

	/**
	 *Return the wall on the other side of wall w from tile x.
	 */
	public Maze() {
		this(3);
	}
	
	/**
     *Creates an n*n maze.
     */
	public Maze(int size) {
		this.size = size; 
		sets = new DisjointSet(size * size); 
		maze = new int[size * size];
		for (int i = 0; i < maze.length; i++) {
			sets.makeSet(i);
			maze[i] = 15;
		}
		maze[0] = 11;
		maze[(size * size) - 1] = 14;
		
	}
	
	/**
     *Generate maze.
     */
	public void createMaze() {
		Integer[] randList = new Integer[size * size];
		for (int i = 0; i < randList.length; i++) {
			randList[i] = i;
		}
		List<Integer> list = Arrays.asList(randList);
		Collections.shuffle(list);
		int counter = 0;
		while (sets.setCounter() > 1) {
			int num = list.get(counter);
			removeWall(num);
			counter++;
			if (counter == size * size)
				counter = 0;
		}
	}
	
	/**
     *Remove the walls.
     */
	private void removeWall(int index) {
		int adj = 0;
		int wall = 0;
		for (int i = 0; i < 1; i++) {
			wall = randomWall(index);
			adj = adjacent(index, wall);	
			if (!sets.sameComponent(index, adj)) {
				maze[index] = maze[index] - wall;
				maze[adj] = maze[adj] - oppWall(wall);
				sets.union(index, adj);
				return;
			}
		}
	}
	
	
	/**
     *Returns a random adjacent cell.
     */
	private int randomWall(int index) {
		ArrayList<Integer> adjCells = new ArrayList();
		if (index >= size) {
			adjCells.add(8);
		}
		if (index < size * size - size) {
			adjCells.add(2);
		}
		if (index % size != 0) {
			adjCells.add(4);
		}
		if ((index + 1) % size != 0) {
			adjCells.add(1);
		}
		Collections.shuffle(adjCells);	 
		return adjCells.get(0);
	}
	
	/**
     *Returns the index of the adjacent cell.
     */
	private int adjacent(int index, int wall) {
		if (wall == 8) return index - size;
		if (wall == 4) return index - 1;
		if (wall == 2) return index + size;
		if (wall == 1) return index + 1;		
		return 0;
	}
	
	/**
     *Returns the opposite cell of given cell .
     */
	private int oppWall(int wall) {
		if (wall == 8) return 2;
		if (wall == 4) return 1;
		if (wall == 2) return 8;
		if (wall == 1) return 4;
		return 0;
	}

	/**
	 *Prints the maze to console.
	 */	
	public void print() {
		for (int i = 0; i < size * size; i++) {
			System.out.print(Integer.toHexString(maze[i]));
			if (i % size == size - 1) {
				System.out.println();
			}
		}	
	}
	
	
}
