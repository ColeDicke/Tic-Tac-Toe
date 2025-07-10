import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean valid = true;
        //Game loop
        while (valid) {
            Game newGame = new Game();
            newGame.start();
            System.out.println("Do you want to play again?");
            Scanner input = new Scanner(System.in);
            //To check if player wants to play again
            while (true) {
                String selection = input.nextLine();
                if (selection.equalsIgnoreCase("yes")) {
                    break;
                } else if (selection.equalsIgnoreCase("no")) {
                    valid = false;
                    break;
                } else {
                    System.out.print("Invalid selection. Try again: ");
                }
            }
        }
        System.out.println("Thanks for playing!");
    }
}