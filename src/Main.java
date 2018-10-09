import java.util.Scanner;
public class Main{
    static boolean play = true;
    public static void main(String[] args) {

        Player player1 = new Player("Bob");
        Player player2 = new Player("Bobby");
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to IOOuterActive dice game");
        System.out.println("To play, press 1 and enter");
        System.out.println("Player 1 starts!");

        player1.setTurn(true);

        while (play) {
            int input = scan.nextInt();
            if (input == 1) {
                if (player1.getIsTurn() && player2.getIsTurn())
                    System.out.println("An error occurred");

                else if (player1.getIsTurn()) {
                    die1.roll();
                    die2.roll();
                    System.out.println("You rolled " + die1.getFaceValue() + " and " + die2.getFaceValue() + ", sum is " + die1.getSum(die2));
                    player1.addToScore(die1, die2);
                    if(die1.equals(die2) && die1.getSum(die2)==2) {
                        player1.setScore(0);
                        System.out.println("Too bad! You rolled two 1s and you've lost all your points. You can roll again.");
                    }
                    else if(die1.equals(die2))
                        System.out.println("Nice! Two of a kind gives an extra roll. Roll again!");
                    else
                        player1.turnSwitch(player2);
                } else if (player2.getIsTurn()) {
                    die1.roll();
                    die2.roll();
                    System.out.println("You rolled " + die1.getFaceValue() + " and " + die2.getFaceValue() + ", sum is " + die1.getSum(die2));
                    player2.addToScore(die1, die2);
                    if(die1.equals(die2) && die1.getSum(die2)==2) {
                        player2.setScore(0);
                        System.out.println("Too bad! You rolled two 1s and you've lost all your points. You can roll again.");
                    }
                    else if(die1.equals(die2))
                        System.out.println("Nice! Two of a kind gives an extra roll. Roll again!");
                    else
                        player2.turnSwitch(player1);
                } else
                    System.out.print("An error occurred");
            }
            showScore(player1, player2);
            showWinner(player1, player2);
            showTurn(player1, player2);
            if(input == 2)
                System.out.println(player1.getIsTurn()+ " " +player2.getIsTurn() );
        }
    }
    public static void showScore(Player player1, Player player2){
            System.out.println("Player 1: " + player1.toString()+ " has "+ player1.getScore() +" points");
            System.out.println("Player 2: " + player2.toString()+ " has "+ player2.getScore() +" points");
    }
    public static void showWinner(Player player1, Player player2){
        if(player1.winGame()) {
            System.out.print(player1.toString() + " won the game");
            play = false;
        }
        else if(player2.winGame()) {
            System.out.print(player2.toString() + " won the game");
            play = false;
        }
    }
    public static void showTurn(Player player1, Player player2){
        if (play) {
            if (player1.getIsTurn()) {
                System.out.println("Player 1, you're next!");
            } else if (player2.getIsTurn()) {
                System.out.println("Player 2, you're next!");
            }
        }
    }
}