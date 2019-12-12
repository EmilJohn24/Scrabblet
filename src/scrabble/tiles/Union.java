package scrabble.tiles;

import scrabble.Letter;
import scrabble.Stash;

import java.util.ArrayList;
import java.util.Collection;

public class Union extends Tile {
    @Override
    public boolean isAllowedLetter(Stash player, Letter letter, boolean alternateStashMove) {
        Collection<Letter> allowedLetters = new ArrayList<>();
        allowedLetters.addAll(player.getLetterList());
        allowedLetters.addAll(Tile.getAltStash().getLetterList());
        return allowedLetters.contains(letter);

    }
}
