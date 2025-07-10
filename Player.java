import java.util.Scanner;

public class Player {
    private String name;
    private char mark;
    private int[] move = new int[2];
    private int row;
    private int col;
    private boolean bound;
    Scanner input = new Scanner(System.in);

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }
    public char getMark(){
        return mark;
    }
    public String getName(){
        return name;
    }

    //Get the row and column player wants to place a mark, ensure it is in the correct
    //bounds, and converts from the 3x3 grid user input to the actual 5x5 grid of the game
    public int[] getMove() {
        System.out.print(getName() + ", enter the row you'd like to mark: ");
        bound = false;
        while(!bound){
            row = input.nextInt();
            switch (row) {
                case 1:
                    row = 0;
                    bound = true;
                    break;
                case 2:
                    row = 2;
                    bound = true;
                    break;
                case 3:
                    row = 4;
                    bound = true;
                    break;
                default:
                    System.out.print("Row out of bounds. Try again: ");
            }
        }
        System.out.print("Enter the column you'd like to mark: ");
        bound = false;
        while(!bound) {
            col = input.nextInt();
            switch (col) {
                case 1:
                    col = 0;
                    bound = true;
                    break;
                case 2:
                    col = 2;
                    bound = true;
                    break;
                case 3:
                    col = 4;
                    bound = true;
                    break;
                default:
                    System.out.print("Column out of bounds. Try again: ");
            }
        }
        move[0] = row;
        move[1] = col;
        return move;
    }
}
