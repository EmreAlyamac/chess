/**
 * bishops
 */
public class bishop extends piece{

    public bishop(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
        this.type = "bishop";
        if (color == 0) { // white
            this.path = "whiteBishop.png";
        } else { // black
            this.path = "blackBishop.png";
        }

    }

    // if it can reach return true
    // if there is a piece there it can call the eat method 

    // eating is the same as moving but it will kill the piece




    public Boolean validMove(int x, int y, piece[][] board) {
        Boolean move = false;
        Boolean eat = false;
        // check if the target position has a piece of the different color
        if (board[x][y].getAlive() && board[x][y].getColor() != this.color) {
            eat = true;
        }
        if (board[x][y].getAlive() && board[x][y].getColor() == this.color) {
            return false;
        }

        if (Math.abs(this.x - x) != Math.abs(this.y - y)) {
            return false;
        }
        
        if (x == this.x && y == this.y) {
            return false;
        }

        if (x > this.x && y > this.y) { // down right
            for (int i = 1; i < x - this.x; i++) {
                if (board[this.x + i][this.y + i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }

        if (x > this.x && y < this.y) { // down left
            for (int i = 1; i < x - this.x; i++) {
                if (board[this.x + i][this.y - i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }

        if (x < this.x && y > this.y) { // up right
            for (int i = 1; i < this.x - x; i++) {
                if (board[this.x - i][this.y + i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }

        if (x < this.x && y < this.y) { // up left
            for (int i = 1; i < this.x - x; i++) {
                if (board[this.x - i][this.y - i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }
        if(move){
            this.x = x;
            this.y = y;
        }

        if(eat && move){
            eat(x,y,board);
        }

        return move;

    }

    public Boolean check_valid(int x, int y, piece[][] board) {
        Boolean move = false;
        if (x == this.x && y == this.y) {
            return false;
        }
        
        if (board[x][y].getAlive() && board[x][y].getColor() == this.color) {
            return false;
        }

        if (Math.abs(this.x - x) != Math.abs(this.y - y)) {
            return false;
        }

        if (x > this.x && y > this.y) {
            for (int i = 1; i < x - this.x; i++) {
                if (board[this.x + i][this.y + i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }
        if (x > this.x && y < this.y) {
            for (int i = 1; i < x - this.x; i++) {
                if (board[this.x + i][this.y - i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }
        if (x < this.x && y > this.y) {
            for (int i = 1; i < this.x - x; i++) {
                if (board[this.x - i][this.y + i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }
        if (x < this.x && y < this.y) {
            for (int i = 1; i < this.x - x; i++) {
                if (board[this.x - i][this.y - i].getAlive()) {
                    return false;
                    
                }
            }
            move = true;
        }
        return move;
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