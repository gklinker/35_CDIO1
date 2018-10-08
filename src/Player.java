public class Player {
    private int score;
    private int winCon = 40;
    private boolean isTurn;
    private String playerName;

    Player(String playerName){
        this.playerName = playerName;
    }

   public int addToScore(Dice die1, Dice die2){
        score = score + die1.getFaceValue()+die2.getFaceValue();
        return score;
   }

   public void turnSwitch(Player playerOne){
        isTurn = false;
        playerOne.isTurn = true;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public boolean getIsTurn(){
        return isTurn;
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
