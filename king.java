class king extends piece{
    
    public king(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
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
        if (x == this.x + 1 && y == this.y){
            move = true;
        }
        if (x == this.x - 1 && y == this.y){
            move = true;
        }
        if (x == this.x && y == this.y + 1){
            move = true;
        }
        if (x == this.x && y == this.y - 1){
            move = true;
        }
        if (x == this.x + 1 && y == this.y + 1){
            move = true;
        }
        if (x == this.x + 1 && y == this.y - 1){
            move = true;
        }
        if (x == this.x - 1 && y == this.y + 1){
            move = true;
        }
        if (x == this.x - 1 && y == this.y - 1){
            move = true;
        }
        move = false;

        if (eat && move){
            eat(x,y,board);
        }
        return move;
    }

    public String toString(){
        String result = "K ";
        if (this.color == 0) {
            result += "W ";
        } else if (this.color == 1) {
            result += "B ";
        }

        result += " x: " + this.x + " y: " + this.y;
        return result;
    }

}