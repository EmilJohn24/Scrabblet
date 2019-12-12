package scrabble.tiles;

import scrabble.Letter;
import scrabble.Stash;

import java.util.Collection;

public abstract class Tile {
    private static Stash alternate;
    static{
        setAltStash(new Stash());
    }
    static void setAltStash(Stash alternate){
        Tile.alternate = alternate;
    }
    static Stash getAltStash(){
        return Tile.alternate;
    }


    private Letter letter;

    public Tile(){
        this.letter = null;
    }

    public boolean hasLetter(){
        return this.letter != null;
    }
    public Letter getLetter() {
        return this.letter;
    }

    public void removeLetter() {
        this.letter = null;
    }

    public abstract boolean isAllowedLetter(Stash player, Letter letter, boolean alternateStashMove);

    public boolean move(Stash player, int index) {
        return move(player, index, true);
    }

    public boolean move(Stash player, int index, boolean alternateStashMove){
        Stash originStash = alternateStashMove ? alternate : player;
        Letter pendingMoveLetter = originStash.pickUpLetter(index);
        if (isAllowedLetter(player, this.letter, alternateStashMove) && this.letter == null){
            putLetter(pendingMoveLetter);
            return true;
        }
        else{
            originStash.putBackLetter(index, pendingMoveLetter);
            return false;
        }
    }

    private void putLetter(Letter letter){
        this.letter = letter;
    }
}
