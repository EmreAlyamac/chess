/**
 * queen
 */
public class queen extends piece {

    public queen(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
        this.type = "queen";
        this.path = "";
        if (color == 0){
            this.path = "whiteQueen.png";
        } else {
            this.path = "blackQueen.png";
        }
    }


    public Boolean check_valid(int x, int y, piece[][] board){
        Boolean move = false;

        
        if(board[x][y].getAlive() && board[x][y].getColor() == this.color){
            return false;
        }
        if (x == this.x){
            if (y > this.y){
                for (int i = this.y + 1; i < y; i++){
                    if (board[x][i].getAlive()){
                        return false;
                    }
                }
                move = true;
            } else if (y < this.y){
                for (int i = this.y - 1; i > y; i--){
                    if (board[x][i].getAlive()){
                        return false;
                    }
                }
                move = true;
            }
        }
        else if (y == this.y){
            if (x > this.x){
                for (int i = this.x + 1; i < x; i++){
                    if (board[i][y].getAlive()){
                        return false;
                    }
                }
                return true;
            } else if (x < this.x){
                for (int i = this.x - 1; i > x; i--){
                    if (board[i][y].getAlive()){
                        return false;
                    }
                }
                move = true;
            }
        }
        if (x > this.x && y > this.y){ // down right
            for (int i = 1; i < x - this.x; i++){
                if (board[this.x + i][this.y + i].getAlive()){
                    return false;
                }
            }
            move = true;
        }
        else if(x > this.x && y < this.y){ // down left
            for (int i = 1; i < x - this.x; i++){
                if (board[this.x + i][this.y - i].getAlive()){
                    return false;
                }
            }
            move = true;
        }
        else if(x < this.x && y > this.y){ // up right
            for (int i = 1; i < this.x - x; i++){
                if (board[this.x - i][this.y + i].getAlive()){
                    return false;
                }
            }
            move = true;
        }
        else if(x < this.x && y < this.y){ // up left
            for (int i = 1; i < this.x - x; i++){
                if (board[this.x - i][this.y - i].getAlive()){
                    return false;
                }
            }
            move = true;
        }
        else if(x > this.x  && y > this.y){
            for (int i = 1; i < x - this.x; i++){
                if (board[this.x + i][this.y + i].getAlive()){
                    return false;
                }
            }
        }
        else if(x > this.x && y < this.y){
            for(int i = 1; i < x - this.x; i++){
                if (board[this.x + i][this.y - i].getAlive()){
                    return false;
                }
            }
        }
        

        return move;
    }

    public Boolean validMove(int x, int y, piece[][] board) {
        
        Boolean eat = false;
        if (board[x][y].getAlive() && board[x][y].getColor() != this.color) {
            eat = true;
        }
        if(board[x][y].getAlive() && board[x][y].getColor() == this.color){
            return false;
        }
        Boolean move = false;
        
        if (x == this.x) {
            if (y > this.y) {
                for (int i = this.y + 1; i < y; i++) {
                    if (board[x][i].getAlive()) {
                        move = false;
                        break;
                    }
                }
                move = true;
            } else if (y < this.y) {
                for (int i = this.y - 1; i > y; i--) {
                    if (board[x][i].getAlive()) {
                        move = false;
                        break;
                    }
                }
                move = true;
            }
        } else if (y == this.y) {
            if (x > this.x) {
                for (int i = this.x + 1; i < x; i++) {
                    if (board[i][y].getAlive()) {
                        move = false;
                        break;
                    }
                }
                move = true;
            } else if (x < this.x) {
                for (int i = this.x - 1; i > x; i--) {
                    if (board[i][y].getAlive()) {
                        move = false;
                        break;
                    }
                }
                move = true;

            }
        }
        if (x == this.x + 1 && y == this.y + 1) {
            move = true;
        }
        if (x == this.x + 1 && y == this.y - 1) {
            move = true;
        }
        if (x == this.x - 1 && y == this.y + 1) {
            move = true;
        }
        if (x == this.x - 1 && y == this.y - 1) {
            move = true;
        }
        if (x == this.x + 1 && y == this.y) {
            move = true;
        }
        if (x == this.x - 1 && y == this.y) {
            move = true;
        }
        if (x == this.x && y == this.y + 1) {
            move = true;
        }
        if (x == this.x && y == this.y - 1) {
            move = true;
        }

        if(move){
            this.x = x;
            this.y = y;
        }
        
        if (eat && move) {
            eat(x, y, board);
        }
        return move;
    }

    public String toString() {
        String result = "Q ";
        if (this.color == 0) {
            result += "W ";
        } else if (this.color == 1) {
            result += "B ";
        }

        result += " x: " + this.x + " y: " + this.y;
        return result;
    }

}