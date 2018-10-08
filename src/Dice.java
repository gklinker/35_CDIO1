import java.util.Random;
public class Dice {
    private int die1;
    private int die2;
    private int sum;
    private int lastSum;
    Random random = new Random();


    public void roll(){
        die1 = random.nextInt(6)+1;
        die2 = random.nextInt(6)+1;
        sum = die1 + die2;
    }

    public void addPoints(Player player){
        player.setScore(player.getScore() + getSum());
    }

    public int getSum(){
        return sum;
    }

    public boolean dieEquals(){
        if(sum == lastSum)
            return true;
        else
            return false;
    }
}
