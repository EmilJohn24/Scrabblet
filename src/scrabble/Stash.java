package scrabble;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stash {
    private static final Integer MAX_SIZE = 7;
    private ArrayList<Letter> letters;

    public Stash(){
        letters = new ArrayList<>();
    }

    public final List<Letter> getLetterList(){
        return letters;
    }

    public void addLetter(Letter letter) throws ArrayIndexOutOfBoundsException{
        if (letters.size() > 7) throw new ArrayIndexOutOfBoundsException("Stash is full");
        letters.add(letter);
    }

    public void addLetter(Character character){
        addLetter(new Letter(character));
    }

    public void putBackLetter(int index, Letter character){
        letters.add(index, character);
    }

    public Letter getLetter(int index){
        return letters.get(index);
    }

    public Letter pickUpLetter(int index){
        return letters.remove(index);
    }
}
