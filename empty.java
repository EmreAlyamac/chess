class empty extends piece{
    public empty(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = false;
        this.color = -1;
        this.type = "empty";
    }
    public Boolean validMove(int x, int y, piece[][] board) {
        return false;
    }
    public boolean validmoves(int x, int y, piece[][] board) {
        return false;
    }
    public String toString() {
        return " ";
    }
}