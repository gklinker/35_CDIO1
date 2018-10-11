import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Dice testDice = new Dice();
    private Dice testDice2 = new Dice();
    private Player testPlayer = new Player("player1");
    private Player testPlayer2 = new Player("player2");

    //tests if the result of testDice 1 and testDice2 gets added to the player's score.
    //<expected result> testPlayers getScore() is equal to the sum of faceValue of both testdice
    //<actual result>
    @Test
    void addToScore() {
        testDice.roll();
        testDice2.roll();
        testPlayer.addToScore(testDice, testDice2);
        assertEquals(testPlayer.getScore(), testDice.getFaceValue() + testDice2.getFaceValue());
    }

    //tests if the turn switches.
    //<expected result> the testPlayer1 and testPlayer2 turns will be switched when I call turnSwitch() method
    //<actual result> the IsTurn bool attached to testPlayer1 and testPlayer2 changes as intended when turnSwitch is called.
    @Test
    void turnSwitch() {
        testPlayer.setTurn(true);
        assertTrue(testPlayer.getIsTurn());
        assertFalse(testPlayer2.getIsTurn());
        testPlayer.turnSwitch(testPlayer2);
        assertFalse(testPlayer.getIsTurn());
        assertTrue(testPlayer2.getIsTurn());
        testPlayer2.turnSwitch(testPlayer);
        assertTrue(testPlayer.getIsTurn());
        assertFalse(testPlayer2.getIsTurn());

    }

    //tests if the winGame method works()
    //<expected result> returns true if a player has over 40 points.
    //<actual result> returns true if a player has over 40 points, returns false if less.
    @Test
    void winGame() {
        testPlayer.setScore(40);
        assertTrue(testPlayer.winGame());
        testPlayer2.setScore(30);
        assertFalse(testPlayer2.winGame());
    }
}