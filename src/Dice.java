import java.util.Random;

public class Dice {
    private int faceValue;
    private int sum;
    private Random random = new Random();

    /** Throws one die and generates a value between 1-6 */
    public void roll(){
        this.faceValue = random.nextInt(6)+1;
    }

    /** Returns the face value of the die */
    public int getFaceValue(){
        return this.faceValue;
    }

    /** Compares the face value of two dice objects */
    public boolean equals(Dice another){
        if (this.faceValue == another.faceValue){
            return true;
        }else
            return false;
    }

    /** Sums the face value of two dice objects */
    public int getSum(Dice another){
        this.sum = this.faceValue + another.faceValue;
        return this.sum;
    }


}