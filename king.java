class king extends piece{
    
    public king(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
    }

    public Boolean validMove(int x, int y, piece[][] board){
        if (x == this.x && y == this.y){
            return false;
        }
        if (x == this.x + 1 && y == this.y){
            return true;
        }
        if (x == this.x - 1 && y == this.y){
            return true;
        }
        if (x == this.x && y == this.y + 1){
            return true;
        }
        if (x == this.x && y == this.y - 1){
            return true;
        }
        if (x == this.x + 1 && y == this.y + 1){
            return true;
        }
        if (x == this.x + 1 && y == this.y - 1){
            return true;
        }
        if (x == this.x - 1 && y == this.y + 1){
            return true;
        }
        if (x == this.x - 1 && y == this.y - 1){
            return true;
        }
        return false;
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