class king extends piece{
    
    public king(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
        this.type = "king";
        this.path = "";
        if (color == 0){
            this.path = "whiteKing.png";
        } else {
            this.path = "blackKing.png";
        }
    }
    /*
     * Besides the protection requirement, the king is done is wished there could be helper method that checks for all the pieces on the board and looks if a spesific piece can reach the king. if it moved
     * if return true then the king is in check
     * if return false then the king is not in check
     * also we can restrict the king from moving to a position that will put it in check
     */
    public Boolean isInCheck(piece[][] board, int x, int y){

    
        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                piece currentPiece = board[i][j];
                if (currentPiece != null && currentPiece.getAlive() && currentPiece.getColor() != this.color && currentPiece.getType() != "king"){
                    if (currentPiece.check_valid(x, y, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean check_valid(int x, int y, piece[][] board){
        Boolean move = false;

        if (isInCheck(board, x, y)){
            return false;
        }

        if(board[x][y].getAlive() && board[x][y].getColor() == this.color){
            return false;
        }

        
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


        return move;
    }

    public Boolean validMove(int x, int y, piece[][] board){
        Boolean eat = false;
        if (board[x][y].getAlive() && board[x][y].getColor() != this.color){
            eat = true;
        }

        if (isInCheck(board, x, y)){
            return false;
        }

        if(board[x][y].getAlive() && board[x][y].getColor() == this.color){
            return false;
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

        if (eat && move){
            eat(x,y,board);
        }
        if(move){
            this.x = x;
            this.y = y;
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