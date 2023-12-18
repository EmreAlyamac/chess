class game {
    
    public static board b = new board();
    public  static displayBoard display = new displayBoard(b);



    private static int firstClickX = -1;
    private static int firstClickY = -1;
    
    public static void clicked(int x ,int y ){
        if (firstClickX == -1 && firstClickY == -1) {
            // This is the first click
            firstClickX = x;
            firstClickY = y;
        } else {
            // This is the second click, so we move
            boolean moved = b.move(firstClickX, firstClickY, x, y);
            display.update(b);
    
            // Reset the first click coordinates
            firstClickX = -1;
            firstClickY = -1;
        }
    }
    public static void main(String[] args) {
        board b = new board();
       
    }
}