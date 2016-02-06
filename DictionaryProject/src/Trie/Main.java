package Trie;


public class Main {

	public static void main(String[] args) {

		Trie t = new Trie();
		System.out.println(t.isEmpty());

		t.add("algorithm",
				"An algorithm is a procedure or formula for solving a problem. A computer program can be viewed as an elaborate algorithm. In mathematics and computer science, an algorithm usually means a small procedure that solves a recurrent problem.");
		t.add("api",
				"The API defines the correct way for a developer to write a program that requests services from an operating system (OS) or other application. APIs are implemented by function calls composed of verbs and nouns.The required syntax is described in the documentation of the application being called.");
		t.add("app",
				"App is an abbreviated form of the word application. An application is a software program  that's designed to perform a specific function directly for the user or, in some cases, for another application program.");

//		System.out.println(t.isEmpty());
//		System.out.println(t.search("app"));
//		t.update("api", "neshto");
//		System.out.println(t.search("api"));
//		t.remove("api");
//		System.out.println(t.numberOfChildren());
		System.out.println(t.showAll());
//		t.save();
//		t.read("words.txt");
//		t.clear();
//		System.out.println(t.isEmpty());
//		System.out.println(t.showAll());

//		System.out.println(num - 97);
//		System.out.println(word.substring(2));
	}


}