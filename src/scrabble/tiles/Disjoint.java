package scrabble.tiles;

import scrabble.Letter;
import scrabble.Stash;

import java.util.ArrayList;
import java.util.List;

public class Disjoint extends Tile {
    @Override
    public boolean isAllowedLetter(Stash player, Letter letter, boolean alternateStashMove) {
        List<Letter> intersect = Intersection.intersection(player.getLetterList(), getAltStash().getLetterList());
        return !intersect.contains(letter);
    }
}
