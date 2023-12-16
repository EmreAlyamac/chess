/**
 * bishops
 */
public class bishop extends piece{

    public bishop(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
    }

    public Boolean validMove(int x, int y, piece[][] board) {
        if (x == this.x && y == this.y) {
            return false;
        }
        if (x > this.x && y > this.y) {
            for (int i = 1; i < x - this.x; i++) {
                if (board[this.x + i][this.y + i].getAlive()) {
                    return false;
                }
            }
            return true;
        }
        if (x > this.x && y < this.y) {
            for (int i = 1; i < x - this.x; i++) {
                if (board[this.x + i][this.y - i].getAlive()) {
                    return false;
                }
            }
            return true;
        }
        if (x < this.x && y > this.y) {
            for (int i = 1; i < this.x - x; i++) {
                if (board[this.x - i][this.y + i].getAlive()) {
                    return false;
                }
            }
            return true;
        }
        if (x < this.x && y < this.y) {
            for (int i = 1; i < this.x - x; i++) {
                if (board[this.x - i][this.y - i].getAlive()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString(){
        String result = "B ";
        if (this.color == 0) {
            result += "W ";
        } else if (this.color == 1) {
            result += "B ";
        }

        result += " x: " + this.x + " y: " + this.y;
        return result;
    }
    
}