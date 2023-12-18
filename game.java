class game {
    
    public static void main(String[] args) {
        board b = new board();

        
        // Turn 1: Move black pawn
        Boolean moved = b.move(6, 0, 4, 0);
        System.out.println(b + " Moved: " + moved.toString());
        
        // Turn 2: Move white pawn
        moved = b.move(1, 1, 3, 1);
        System.out.println(b + " Moved: " + moved.toString());

        moved = b.move(3,1,4,0);
        System.out.println(b + " Moved: " + moved.toString());

    }
}