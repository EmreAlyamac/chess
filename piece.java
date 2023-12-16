/**
 * piece
 */
public abstract class piece {

    int color; // 0 = white, 1 = black
    int x;
    int y;
    boolean alive;


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

    //public abstract boolean validmoves(int x, int y, piece[][] board); // may not implement

    public abstract Boolean validMove(int x, int y, piece[][] board);

    public abstract String toString();




}