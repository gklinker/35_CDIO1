import java.util.Scanner;
public class Main{
    static boolean play = true;
    public static void main(String[] args) {
        Player player1 = new Player("Bob");
        Player player2 = new Player("Bobby");
        Dice dice = new Dice();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to IOOuterActive dice game");
        System.out.println("To play, press 1 and enter");
        player1.setTurn(true);
        while (play) {

            int input = scan.nextInt();
            if (input == 1) {
                if (player1.getIsTurn() && player2.getIsTurn())
                    System.out.println("An error occurred");

                else if (player1.getIsTurn()) {
                    dice.roll();
                    System.out.println(dice.getSum());
                    dice.addPoints(player1);
                    if(dice.dieEquals() && dice.getSum()==2)
                        player1.setScore(0);
                    if(dice.dieEquals())
                        System.out.println("Two of a kind gives an extra round");
                    else
                    player1.turnSwitch(player2);
                } else if (player2.getIsTurn()) {
                    dice.roll();
                    System.out.println(dice.getSum());
                    dice.addPoints(player2);
                    if(dice.dieEquals() && dice.getSum()==2)
                        player2.setScore(0);
                    if(dice.dieEquals())
                        System.out.println("Two of a kind gives an extra round");
                    else
                        player2.turnSwitch(player1);
                } else
                    System.out.print("An error occurred");
            }
            showScore(player1, player2);
            showWinner(player1, player2);
            if(input == 2)
                System.out.println(player1.getIsTurn()+ " " +player2.getIsTurn() );
        }
    }
    public static void showScore(Player player1, Player player2){
        System.out.println(player1.toString()+ " has "+ player1.getScore() +" points");
        System.out.println(player2.toString()+ " has "+ player2.getScore() +" points");
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
}
