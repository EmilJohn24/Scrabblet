package scrabble;

class StashTest {

    private Stash testStash;

    public StashTest(){
        testStash = new Stash();
    }
    @org.junit.jupiter.api.Test
    void addLetter() {
        testStash.addLetter(new Letter('A'));
        testStash.addLetter(new Letter('B'));
        assert(testStash.getLetter(0).getChar() == 'A' && testStash.getLetter(1).getChar() == 'B');
    }


    @org.junit.jupiter.api.Test
    void pickUpLetter() {
        addLetter();
        Letter pickedUp = testStash.pickUpLetter(0);
        assert(pickedUp.getChar() == 'A' && testStash.getLetter(0).getChar() == 'B');

    }
}