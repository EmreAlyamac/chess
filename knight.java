/**
 * knight
 */
public class knight extends piece {

    public knight(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
        this.type = "knight";
        this.path = "";
        if (color == 0){
            this.path = "whiteKnight.png";
        } else {
            this.path = "blackKnight.png";
        }
    }
    
    public Boolean check_valid(int x, int y, piece[][] board){
        Boolean move = false;

        if (x == this.x && y == this.y){
            move = false;
        }

        if (x == this.x + 1 && y == this.y + 2){
            move = true;
        }
        if (x == this.x + 1 && y == this.y - 2){
            move = true;
        }
        if (x == this.x - 1 && y == this.y + 2){
            move = true;
        }
        if (x == this.x - 1 && y == this.y - 2){
            move = true;
        }
        if (x == this.x + 2 && y == this.y + 1){
            move = true;
        }
        if (x == this.x + 2 && y == this.y - 1){
            move = true;
        }
        if (x == this.x - 2 && y == this.y + 1){
            move = true;
        }
        if (x == this.x - 2 && y == this.y - 1){
            move = true;
        }


        return move;
    }


    public Boolean validMove(int x, int y, piece[][] board){
        
        Boolean eat = false;
        if (board[x][y].getAlive() && board[x][y].getColor() != this.color){
            eat = true;
        }
        Boolean move = false;

        if (x == this.x && y == this.y){
            move = false;
        }
        if (x == this.x + 1 && y == this.y + 2){
            move = true;
        }
        if (x == this.x + 1 && y == this.y - 2){
            move = true;
        }
        if (x == this.x - 1 && y == this.y + 2){
            move = true;
        }
        if (x == this.x - 1 && y == this.y - 2){
            move = true;
        }
        if (x == this.x + 2 && y == this.y + 1){
            move = true;
        }
        if (x == this.x + 2 && y == this.y - 1){
            move = true;
        }
        if (x == this.x - 2 && y == this.y + 1){
            move = true;
        }
        if (x == this.x - 2 && y == this.y - 1){
            move = true;
        }

        if (eat && move){
            eat(x,y,board);
        }
        return move;
    }

    public String toString(){
        String result = "N ";
        if (this.color == 0) {
            result += "W ";
        } else if (this.color == 1) {
            result += "B ";
        }

        result += " x: " + this.x + " y: " + this.y;
        return result;
    }
    
}