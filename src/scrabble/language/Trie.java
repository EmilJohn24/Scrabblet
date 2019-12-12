package scrabble.language;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode(TrieNode.EMPTY);
    }
    public void addWords(String dictionary) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dictionary));
        String newWord;
        while ((newWord = reader.readLine()) != null){
            addWord(newWord);
        }
    }
    public void addWord(String word) throws NullPointerException{
        word = word.toLowerCase();
        TrieNode explorer = root;
        for (Character c : word.toCharArray()){
            explorer = explorer.addNextLetter(c);
        }
        explorer.markWord(word);
    }

    public boolean searchWord(String word){
        return wordSearchHelper(word) != null;
    }

    private TrieNode wordSearchHelper(String word){
        return root.recursiveWordGetter(word, 0);
    }


}
