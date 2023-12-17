/**
 * pawn
 */
public class pawn extends piece {

    public pawn(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
    }

    // x vertical, y horizontal
    public Boolean validMove(int x, int y, piece[][] board) {
        
        Boolean eat = false;
        if (board[x][y].getAlive() && board[x][y].getColor() != this.color) {
            eat = true;
        }
        Boolean move = false;
        
        if (x == this.x && y == this.y) {
            move = false;
        }
        if (this.color == 0) {
            if (y == this.y && x == this.x + 1) {
                move = true;
            }
            if (y == this.y && x == this.x + 2 && this.x == 1) {
                move = true;
            }
            if (y == this.y + 1 && x == this.x + 1 && board[x][y].getColor() == 1) {
                move = true;
            }
            if (y == this.y - 1 && x == this.x + 1 && board[x][y].getColor() == 1) {
                move = true;
            }
        } else if (this.color == 1) {
            if (y == this.y && x == this.x - 1) {
                move = true;
            }
            if (y == this.y && x == this.x - 2 && this.x == 6) {
                move = true;
            }
            if (y == this.y + 1 && x == this.x - 1 && board[x][y].getColor() == 0) {
                move = true;
            }
            if (y == this.y - 1 && x == this.x - 1 && board[x][y].getColor() == 0) {
                move = true;
            }
        }
        if (eat && move) {
            eat(x, y, board);
        }
        if (move){
            this.x = x;
            this.y = y;
        }
        return move;
    }

    public String toString() {
        String result = "P ";
        if (this.color == 0) {
            result += "W ";
        } else if (this.color == 1) {
            result += "B ";
        }

        result += " x: " + this.x + " y: " + this.y;
        return result;
    }

    
}
