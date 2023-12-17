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
    public Boolean validMove(int y, int x, piece[][] board) {
        
        Boolean eat = false;
        if (board[x][y].getAlive() && board[x][y].getColor() != this.color) {
            eat = true;
        }
        Boolean move = false;
        
        if (x == this.x && y == this.y) {
            move = false;
        }
        if (this.color == 0) {
            if (x == this.x && y == this.y + 1) {
                move = true;
            }
            if (x == this.x && y == this.y + 2 && this.y == 1) {
                move = true;
            }
            if (x == this.x + 1 && y == this.y + 1 && board[x][y].getColor() == 1) {
                move = true;
            }
            if (x == this.x - 1 && y == this.y + 1 && board[x][y].getColor() == 1) {
                move = true;
            }
        } else if (this.color == 1) {
            if (x == this.x && y == this.y - 1) {
                move = true;
            }
            if (x == this.x && y == this.y - 2 && this.y == 6) {
                move = true;
            }
            if (x == this.x + 1 && y == this.y - 1 && board[x][y].getColor() == 0) {
                move = true;
            }
            if (x == this.x - 1 && y == this.y - 1 && board[x][y].getColor() == 0) {
                move = true;
            }
        }
        move = false;
        if (eat && move) {
            eat(x, y, board);
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
