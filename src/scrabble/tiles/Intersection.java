package scrabble.tiles;

import scrabble.Letter;
import scrabble.Stash;

import java.lang.reflect.Array;
import java.util.*;

public class Intersection extends Tile{
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    @Override
    public boolean isAllowedLetter(Stash player, Letter letter, boolean alternateStashMove) {
        List<Letter> intersect = intersection(player.getLetterList(), getAltStash().getLetterList());
        return intersect.contains(letter);
    }


}
