package scrabble;

import javafx.util.Pair;
import scrabble.language.Trie;
import scrabble.tiles.Tile;

import java.io.IOException;
import java.util.Stack;

public class Board {
    private Tile[][] board;
    private Trie wordCheck;
    private Stack<Pair<Integer, Integer>> moveStack;

    public Board(int rows, int cols) throws IOException {
        board = new Tile[rows][cols];
        wordCheck = new Trie();
        wordCheck.addWords("dictionary.txt");
        moveStack = new Stack<>();
    }

    public void sealMove(){
        Pair<Integer, Integer> lastMove = moveStack.peek();
        int row = lastMove.getKey();
        int col = lastMove.getValue();
        Integer startRow = getStartingPoint(row, col, true);
        Integer startCol = getStartingPoint(row, col, false);
        if (verifyWordStartingAt(startRow, col, true)
                && verifyWordStartingAt(row, startCol, false)){
            moveStack.clear();
        } else{
            while (!moveStack.isEmpty()){
                Pair<Integer, Integer> lastMoveCoord = moveStack.pop();
                Tile currentTile = getTile(lastMoveCoord.getKey(), lastMoveCoord.getValue());
            }
        }
    }

    public void move(int row, int col, BoardMove myMove){
        Tile moveTile = getTile(row, col);
        moveTile.move(myMove.getPlayer(),
                myMove.getIndex(), myMove.isAlternateStashMove());
        moveStack.push(new Pair<>(row, col));

    }

    public Tile getTile(int row, int col){
        return board[row][col];
    }

    public String buildWordAt(int row, int col, boolean downward){
        //else downward
        String builtWord = "";
        if (downward) {
            for (int currentCol = col; getTile(row, currentCol).hasLetter(); ++currentCol){
                builtWord = builtWord.concat(getTile(row, currentCol).getLetter().toString());
            }
        }
        else{
            for (int currentRow = row; getTile(currentRow, col).hasLetter(); ++currentRow){
                builtWord = builtWord.concat(getTile(currentRow, col).getLetter().toString());
            }
        }
        return builtWord;
    }

    public int getStartingPoint(int row, int col, boolean downward){
        if (!downward) {
            int currentCol = col;
            while (getTile(row, currentCol).hasLetter()) --currentCol;
            return currentCol + 1;
        }
        else{
            int currentRow = row;
            while (getTile(currentRow, col).hasLetter()) --currentRow;
            return currentRow + 1;
        }
    }

    public boolean verifyWordStartingAt(int row, int col, boolean downward){
        String builtWord = buildWordAt(row, col, downward);
        return wordCheck.searchWord(builtWord);
    }
}
