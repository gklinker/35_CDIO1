public class Player {
    private int score;
    private int winCon = 40;
    private boolean isTurn;
    private String playerName;

    // Constructor
    public Player(String playerName){
       this.playerName = playerName;
       this.score = 0;
    }

    // Adds the sum of two dice to a players score
    public int addToScore(Dice die1, Dice die2){
        score = score + die1.getFaceValue()+die2.getFaceValue();
        return score;
    }

    // Passes the turn to the next player
    public void turnSwitch(Player playerOne){
        isTurn = false;
        playerOne.isTurn = true;
    }

    // Returns wheater a player have the turn ot not
    public boolean getIsTurn(){
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }



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

    public int getWinCon(){
        return winCon;
    }

    public void setScore(int newScore){
        score = newScore;
    }

    public void setWinCon(int newWinCon){
        winCon = newWinCon;
    }
}
