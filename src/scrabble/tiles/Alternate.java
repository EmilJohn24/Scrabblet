package scrabble.tiles;

import scrabble.Letter;
import scrabble.Stash;

public class Alternate extends Tile{
    @Override
    public boolean isAllowedLetter(Stash player, Letter letter, boolean alternateStashMove) {
        return alternateStashMove;
    }
}
