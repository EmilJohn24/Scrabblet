package scrabble;

public class BoardMove {
    private Stash player;
    private int index;
    private boolean alternateStashMove;

    public BoardMove(Stash player, int index, boolean alternateStashMove){
        this.player = player;
        this.index = index;
        this.alternateStashMove = alternateStashMove;
    }

    public boolean isAlternateStashMove() {
        return alternateStashMove;
    }

    public int getIndex() {
        return index;
    }

    public Stash getPlayer() {
        return player;
    }

}
