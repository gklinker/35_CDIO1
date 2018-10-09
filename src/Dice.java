import java.util.Random;

public class Dice {
    private int faceValue;
    private int sum;
    private int lastSum;
    private Random random = new Random();

    // Throws one die and generates a value between 1-6
    public void roll(){
        this.faceValue = random.nextInt(6)+1;
    }

    // Returns the face value of the dice
    public int getFaceValue(){
        return this.faceValue;
    }

    // Compares the face value of two dice objects
    public boolean equals(Dice another){
        if (this.faceValue == another.faceValue){
            return true;
        }else
            return false;
    }

    // Sums the face value of two dice objects
    public int getSum(Dice another){
        this.sum = this.faceValue + another.faceValue;
        return this.sum;
    }

    // Method for two times 6 in a row
    public boolean dieEquals(){
        if(sum == lastSum)
            return true;
        else
            return false;
    }
}