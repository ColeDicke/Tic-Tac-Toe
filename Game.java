import java.util.Scanner;

public class Game {
    private boolean validMark;
    private Scanner input;
    private String name1;
    private char mark1;
    private String name2;
    private char mark2;
    private int[] move = new int[2];
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    //Starts the actual game and contains all logic to the actual game and loop
    public void start() {
        //gets both players names and which mark they want to use, validating the selections
        //and then creates the player instances and the board instance
        input = new Scanner(System.in);
        System.out.print("Enter player 1 name: ");
        this.name1 = input.nextLine();
        System.out.print("Enter player 1 mark(X or O): ");
        validMark = false;
        while (!validMark) {
            this.mark1 = input.next().charAt(0);
            input.nextLine();//dummy input
            mark1 = Character.toUpperCase(mark1);
            if (mark1 == 'X') {
                mark2 = 'O';
                validMark = true;
            } else if (mark1 == 'O') {
                mark2 = 'X';
                validMark = true;
            } else {
                System.out.print("Invalid mark option. Try again: ");
            }
        }
        System.out.print("Enter player 2 name: ");
        name2 = input.nextLine();
        System.out.println(name1 + "'s mark is " + mark1);
        System.out.println(name2 + "'s mark is " + mark2);
        player1 = new Player(name1,mark1);
        player2 = new Player(name2,mark2);
        currentPlayer = player1;
        board = new Board();
        //Actual loop of the game and checks if the game is over after each round
        while(!isGameOver()){
            boolean valid = false;
            while(!valid){
                move = currentPlayer.getMove();
                if(!(board.placeMark(move[0],move[1],currentPlayer.getMark()))) {
                    System.out.println("Invalid placement of mark. Try again.");
                }
                else{valid = true;}
            }
            System.out.println(board);
            switchPlayer();
        }
        //Checks who won or if there was a tie that occurred
        if(board.checkWin(player1.getMark())){
            System.out.println(player1.getName() + " has won!");
        }
        else if(board.checkWin(player2.getMark())){
            System.out.println(player2.getName() + " has won!");
        }
        else if(board.isFull()){
            System.out.println("It's a tie!");
        }
    }

    //checks if either player has won or if the board is full
    public boolean isGameOver(){
        if(board.checkWin(player1.getMark()) || board.checkWin(player2.getMark()) || board.isFull()){
            return true;
        }
        return false;
    }

    //switches between player1 and player2 in order to simplify the game loop
    public void switchPlayer(){
    currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
