package scrabble;

import java.io.IOException;

public class Play {
    private Board playingBoard;

    public Play() throws IOException {
        playingBoard = new Board(15, 15);
    }
}
