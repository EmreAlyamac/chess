/**
 * board
 */
public class board {

    private piece[][] board = new piece[8][8];

    public board() {
        // initialize board
        // white pieces
        // x, y, color
        board[0][0] = new rook(0, 0, 0);
        board[0][1] = new knight(0, 1, 0);
        board[0][2] = new bishop(0, 2, 0);
        board[0][3] = new queen(0, 3, 0);
        board[0][4] = new king(0, 4, 0);
        board[0][5] = new bishop(0, 5, 0);
        board[0][6] = new knight(0, 6, 0);
        board[0][7] = new rook(0, 7, 0);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new pawn(1, i, 0);
        }
        // black pieces
        board[7][0] = new rook(7, 0, 1);
        board[7][1] = new knight(7, 1, 1);
        board[7][2] = new bishop(7, 2, 1);
        board[7][3] = new queen(7, 3, 1);
        board[7][4] = new king(7, 4, 1);
        board[7][5] = new bishop(7, 5, 1);
        board[7][6] = new knight(7, 6, 1);
        board[7][7] = new rook(7, 7, 1);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new pawn(6, i, 1);
        }
        // empty spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new empty(i, j);
            }
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < 8; i++) {
            result += "---------------------------------\n";
            for (int j = 0; j < 8; j++) {
                result += "| " + board[i][j].toString() + " ";
            }
            result += "|\n";
        }
        result += "---------------------------------\n";
        return result;
    }


    public piece getPiece(int x, int y) {
        return board[x][y];
    }

    // it will move to the new location if it is a valid move
    // and it will eat the piece if it is a valid move if the target position has a piece of the different color
    


    public Boolean move(int x1, int y1, int x2, int y2) {
        if (board[x1][y1].validMove(x2, y2, board)) {
            board[x2][y2] = board[x1][y1];
            board[x1][y1] = new empty(x1, y1);
            displayBoard.updatePanel(x1, y1, this);
            displayBoard.updatePanel(x2, y2, this);
            return true;
        }
        return false;
    }



}