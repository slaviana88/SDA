package Trie;

import java.io.Serializable;

public class Node implements Serializable {
	public Node[] children;
	public String description;

	/**
	 * In a trie indexing an alphabet of 26 letters, each node has 26 possible
	 * children and, therefore, 26 possible pointers.
	 */

	public Node() {
		description = null;
		children = new Node[26];
	}

}
