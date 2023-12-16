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
        if (x == this.x && y == this.y) {
            return false;
        }
        if (this.color == 0) {
            if (x == this.x && y == this.y + 1) {
                return true;
            }
            if (x == this.x && y == this.y + 2 && this.y == 1) {
                return true;
            }
            if (x == this.x + 1 && y == this.y + 1 && board[x][y].getColor() == 1) {
                return true;
            }
            if (x == this.x - 1 && y == this.y + 1 && board[x][y].getColor() == 1) {
                return true;
            }
        } else if (this.color == 1) {
            if (x == this.x && y == this.y - 1) {
                return true;
            }
            if (x == this.x && y == this.y - 2 && this.y == 6) {
                return true;
            }
            if (x == this.x + 1 && y == this.y - 1 && board[x][y].getColor() == 0) {
                return true;
            }
            if (x == this.x - 1 && y == this.y - 1 && board[x][y].getColor() == 0) {
                return true;
            }
        }
        return false;
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
