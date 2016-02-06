package Trie;

public interface Dictionary {
	// add the word and it's description in the Trie
	public void add(String word, String explanation);

	// search for the word in the Trie and returns it's description
	public String search(String word);

	// return if there is any word in the Trie
	public boolean isEmpty();

	// refresh words's description
	public void update(String word, String explanation);

	// remove a word from the Trie
	public boolean remove(String word);

	// return the number of children in the Trie
	public int numberOfChildren();

	// shows all the words with their's descriptions
	public StringBuilder showAll();

	// read the word from file and fill the Trie
	public void read(String file);

	// save the current information
	public void save();

	// clear the information in the trie
	public void clear();
}
