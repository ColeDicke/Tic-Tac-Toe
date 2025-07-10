
public class Board {
    private char[][] board;
    public Board() {
        board = new char[][]{
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
    }

    //Places the players mark and makes sure it is empty before placing, if it is not empty, it
    //will not place and return false
    public boolean placeMark(int row, int col, char mark){
        if(board[row][col] == ' '){
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    //checks which ever player's mark for a win by checking all rows, then all columns, then both diagonals
    public boolean checkWin(char mark) {
        for (int i = 0; i <= 4; i += 2) {
            if (board[i][0] == mark && board[i][2] == mark && board[i][4] == mark ||
                    board[0][i] == mark && board[2][i] == mark && board[4][i] == mark) {
                return true;
            }
        }
        for (int i = 0; i <= 4; i += 2) {
            if (board[0][0] == mark && board[2][2] == mark && board[4][4] == mark ||
                    board[0][4] == mark && board[2][2] == mark && board[4][0] == mark) {
                return true;
            }
        }
        return false;
    }

    //Iterates through the whole board to find any empty markable indices; if it finds none it returns true
    public boolean isFull(){
        for (int i = 0; i <= 4; i += 2){
            for (int j = 0; j <= 4; j += 2){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length;i++){
           for(int j = 0; j < board[i].length;j++){
               sb.append(board[i][j]).append(' ');
           }
           sb.append("\n");
        }
        return sb.toString();
    }
}
