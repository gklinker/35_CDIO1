public class Player {
    private int score;
    private int winCon = 40;
    private boolean isTurn;
    private String playerName;

    /** Constructor, creates a instance of the class: player. */
    public Player(String playerName){
        this.playerName = playerName;
        this.score = 0;
    }

    /** Adds the sum of two dice to a players score */
    public int addToScore(Dice die1, Dice die2){
        score = score + die1.getFaceValue()+die2.getFaceValue();
        return score;
    }

    /** Passes the turn to the next player */
    public void turnSwitch(Player playerOne){
        isTurn = false;
        playerOne.isTurn = true;
    }
    /** Boolean for what player has the turn */
    public boolean getIsTurn(){
        return isTurn;
    }

    /** Boolean for setting the turn to a player */
    public void setTurn(boolean turn) {
        isTurn = turn;
    }


    /** If 'score' is higher or equals to the winCon, winGame is true. */
    public boolean winGame(){
        if(score>=winCon)
            return true;
        else
            return false;

    }

    public String toString() {
        return playerName;
    }

    public int getScore(){
        return score;
    }


    public void setScore(int newScore){
        score = newScore;
    }
}
