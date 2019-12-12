package scrabble.language;

import com.sun.istack.internal.NotNull;
import javafx.util.Pair;

import java.util.Hashtable;

class TrieNode {
    private Character character;
    private String word; //for quick lookup
    private Hashtable<Character, TrieNode> connectedNodes;
    static Character EMPTY = '\0';

    TrieNode(@NotNull Character character, String word){
        this(character);
        this.word = word;
    }

    TrieNode(@NotNull Character character){
        this.character = character;
        this.connectedNodes = new Hashtable<>();
        this.word = "";
    }

    TrieNode recursiveWordGetter(String word, Integer currentIndex){
        if (word.equals(this.word)) return this;
        if (currentIndex >= word.length()) return null;

        Character nextLetter = word.charAt(currentIndex);

        TrieNode nextNode = getNodeFor(nextLetter);
        if (nextNode == null) return null;
        else return nextNode.recursiveWordGetter(word, currentIndex + 1);
    }

    TrieNode getNodeFor(@NotNull Character letter){
        return connectedNodes.get(letter);
    }

    TrieNode addNextLetter(@NotNull Character letter){
        if (!connectedNodes.containsKey(letter)) {
            TrieNode newlyPlacedNode = new TrieNode(letter);
            connectedNodes.put(letter, newlyPlacedNode);
            return newlyPlacedNode;
        }
        return connectedNodes.get(letter);
    }



    void markWord(String word){
        this.word = word;
    }

    public Character getCharacter() {
        return character;
    }
}
