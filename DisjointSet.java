/**
 * Jorge Marinez
 * Cabrillo College, Computer Science
 * Pengo Username: jmarinez
 * Email: jorgemarinez@sbcglobal.net
 * Filename: DisjointSet.java
 * Assignment06: Maze Generation with Disjoint Sets
 * Status: working/tested
 */

/**
 *Disjoint Set class..
 */
public class DisjointSet {
	
	private int[] parent;
	private int[] rank;
	private int counter;
	
	/**
     *Constructor.
     */
	public DisjointSet(int size) {
		counter = size;
		parent = new int[size];
		rank = new int[size];
	}
	
	/**
     *Makes a set.
     */
	public void makeSet(int x) {
		parent[x] = x;
		rank[x] = 0;
	}
	
	/**
     *Unions two sets.
     */
	public void union(int x, int y) {
		link(find(x), find(y));
		
	}
	
	/**
     *Finds a given set.
     */
	public int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	/**
     *Joins two sets.
     */
	private void link(int x, int y) {
		if (x == y) return;
		if (rank[x] > rank[y]) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
			
			if (rank[x] == rank[y]) {
				rank[y]++;
				
			}
		}
		counter--;
	}
	
	/**
     *Determines if the two sets are in the same set.
     */
	public boolean sameComponent(int x, int y) {
		return(find(x) == find(y));
	}
	
	/**
     *Returns the number of sets.
     */
	public int setCounter() {
		return counter;
	}
	
	
}
