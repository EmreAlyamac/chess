/**
 * rook
 */
public class rook extends piece {

    public rook(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
    }

    public Boolean validMove(int x, int y, piece[][] board) {
        if (x == this.x) {
            if (y > this.y) {
                for (int i = this.y + 1; i < y; i++) {
                    if (board[x][i].getAlive()) {
                        return false;
                    }
                }
                return true;
            } else if (y < this.y) {
                for (int i = this.y - 1; i > y; i--) {
                    if (board[x][i].getAlive()) {
                        return false;
                    }
                }
                return true;
            }
        } else if (y == this.y) {
            if (x > this.x) {
                for (int i = this.x + 1; i < x; i++) {
                    if (board[i][y].getAlive()) {
                        return false;
                    }
                }
                return true;
            } else if (x < this.x) {
                for (int i = this.x - 1; i > x; i--) {
                    if (board[i][y].getAlive()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String result = "R ";
        if (this.color == 0) {
            result += "W ";
        } else if (this.color == 1) {
            result += "B ";
        }

        result += " x: " + this.x + " y: " + this.y;
        return result;

    }
    
}