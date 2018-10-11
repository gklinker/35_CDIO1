import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    private Dice testDice = new Dice();
    private Dice testDice2 = new Dice();



    @RepeatedTest(1000)
    /** test if the roll() method generates a random number between 1 and 6, repeated 1000 times to make sure */
    // <expected result> all tests return true
    // <actual result> all tests returned true
    void testRoll() {
        testDice.roll();

        assertTrue((testDice.getFaceValue() >= 1 && testDice.getFaceValue() <= 6));
    }
    // test if the rolls are "fair", using the same criteria as the assignment handed in this past monday.
    // 60000 rolls, 4% margin of error.
    // Tested 500 times to eliminate any element of luck.
    // This test the same as our group's answer of the earlier assignment this week.
    // <expected result> all rolls are spread evenly and fairly within a 4% margin of error.
    // <actual result> successful spread of values.
    @RepeatedTest(500)
    void testFairness() {
        int ones, twos, threes, fours, fives, sixes;
        ones = twos = threes = fours = fives = sixes = 0;

        int lowerBound = 9600;
        int upperBound = 10400;

        for(int i = 0; i < 60000; i++) {
            testDice.roll();
            int rollResult = testDice.getFaceValue();

            switch(rollResult) {
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                case 3:
                    threes++;
                    break;
                case 4:
                    fours++;
                    break;
                case 5:
                    fives++;
                    break;
                case 6:
                    sixes++;
                    break;
                default:
                    fail();
                    break;
            }
        }
        assertTrue((ones >= lowerBound) && (ones <= upperBound));
        assertTrue((twos >= lowerBound) && (twos <= upperBound));
        assertTrue((threes >= lowerBound) && (threes <= upperBound));
        assertTrue((fours >= lowerBound) && (fours <= upperBound));
        assertTrue((fives >= lowerBound) && (fives <= upperBound));
        assertTrue((sixes >= lowerBound) && (sixes <= upperBound));

    }

    //test of the equals method. Uses 2 tests, one for equal rolls, the other for unequal rolls.
    //FIRST TEST
    //<summary> Testing testDice faceValue with itself
    //<expected result> returns true
    //<actual result> returned true
    //SECOND TEST
    //<summary> Testing testDice faceValue with testDice2
    //<expected result> returns false
    //<actual result> returned false
    @Test
    void equals() {

        //test 1
        testDice.roll();
        assertTrue(testDice.equals(testDice));

        //test 2
        testDice2.roll();
        while(testDice2.getFaceValue() == testDice.getFaceValue()) {
            testDice2.roll();
        }
        assertFalse(testDice.equals(testDice2));

    }

    //test of the getSum() method, that adds together the facevalues of 2 dice objects.
    //<expected result> the sum of the faceValues of testDice and testDice2
    //<actual result> the sum of the faceValues of testDice and testDice2
    @Test
    void getSum() {
        testDice.roll();
        testDice2.roll();
        assertEquals(testDice.getSum(testDice2), testDice.getFaceValue() + testDice2.getFaceValue());
    }
}