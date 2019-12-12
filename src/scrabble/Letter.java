package scrabble;

import java.util.ArrayList;
import java.util.Hashtable;

public class Letter {
    private static Hashtable<Character, Integer> scores;
    private static ArrayList<Letter> letters;

    static{
        scores = new Hashtable<>();
        letters = new ArrayList<>();
    }

    private static void addLetters(Character character, int count){
        for (int i = 0; i != count; ++i){
            addLetter(new Letter(character));
        }
    }


    private static void defaultLetters(){
        addLetters('A', 9);
        addLetters('B', 2);
        addLetters('C', 2);
        addLetters('D', 4);
        addLetters('E', 12);
        addLetters('F', 2);
        addLetters('G', 3);
        addLetters('H', 2);
        addLetters('I', 9);
        addLetters('J', 1);
        addLetters('K', 1);
        addLetters('M', 2);
        addLetters('N', 6);
        addLetters('O', 8);
        addLetters('P', 2);
        addLetters('Q', 1);
        addLetters('R', 6);
        addLetters('S', 4);
        addLetters('T', 6);
        addLetters('U', 4);
        addLetters('V', 2);
        addLetters('W', 2);
        addLetters('X', 1);
        addLetters('Y', 2);
        addLetters('Z', 1);
    }

    private static void setScores(Integer score, Character... letters){
        for (Character c : letters){
            setScore(c, score);
        }
    }

    private static void generateScores(){
        setScores(1, 'A', 'E', 'I',
                'O', 'U', 'L', 'N', 'S', 'T', 'R');
        setScores(2, 'D', 'G');
        setScores(3, 'B', 'C', 'M', 'P');
        setScores(4, 'F', 'H', 'V', 'W', 'Y');
        setScores(5, 'K');
        setScores(8, 'J', 'X');
        setScores(10, 'Q', 'Z');
    }

    public static void addLetter(Letter letter){
        letters.add(letter);
    }

    public static Letter pickUpNextLetter(){
        return letters.remove(0);
    }


    public static void setScore(Character letter, Integer score){
        scores.put(letter, score);
    }

    public static Integer getScore(Letter letter){
        return scores.get(letter.getChar());
    }


    private final Character letter;

    Letter(Character letter){
        this.letter = letter;
    }

    public Character getChar() {
        return letter;
    }
}
