/**
 * piece
 */
public abstract class piece {

    int color; // 0 = white, 1 = black
    int x;
    int y;
    boolean alive;
    player owner;
    String type;


    public String getType() {
        return this.type;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void kill() {
        this.alive = false;
    }

    public void revive() {
        this.alive = true;
    }

    public int getColor() {
        return this.color;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void eat(int x, int y, piece[][] board){
        if (board[x][y].getAlive() == false) {
            return;
        }
        board[x][y].kill();
        String color = "";
        if (board[x][y].getColor() == 0) {
            color = "White";
        } else {
            color = "Black";
        }
         
        System.out.println(color + " " + board[x][y].getType()+ " at " + x + ", " + y + " has been eaten by " + this.toString());
    }

    //public abstract boolean validmoves(int x, int y, piece[][] board); // may not implement

    public abstract Boolean validMove(int x, int y, piece[][] board);

    public abstract String toString();




}