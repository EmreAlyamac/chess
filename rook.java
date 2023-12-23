/**
 * rook
 */
public class rook extends piece {

    public rook(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
        this.type = "rook";
        this.path = "";
        if (color == 0){
            this.path = "whiteRook.png";
        } else {
            this.path = "blackRook.png";
        }
    }

    public Boolean check_valid(int x, int y, piece[][] board){
        Boolean move = false;

        
        if(board[x][y].getAlive() && board[x][y].getColor() == this.color){
            return false;
        }
        
        if (x == this.x && y == this.y){
            return false;
        }

        if (x == this.x){
            if (y > this.y){
                for (int i = this.y + 1; i < y; i++){
                    if (board[x][i].getAlive()){
                        return false;
                    }
                }
                return true;
            } else if (y < this.y){
                for (int i = this.y - 1; i > y; i--){
                    if (board[x][i].getAlive()){
                        return false;
                    }
                }
                return true;
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
                return true;
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
        
        if(board[x][y].getAlive() && board[x][y].getColor() == this.color){
            return false;
        }
        
        if (x == this.x && y == this.y){
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
        if (move){
            this.x = x;
            this.y = y;
        }
        if(eat && move){
            eat(x,y,board);
        }
        return move;
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