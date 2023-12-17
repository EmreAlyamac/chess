class game {
    
    public static void main(String[] args) {
        board b = new board();
        System.out.println(b);
        
        // Turn 1: Move black pawn
        Boolean moved = b.move(6, 0, 4, 0);
        System.out.println(b + " Moved: " + moved.toString());
        
        // Turn 2: Move white pawn
        moved = b.move(1, 1, 3, 1);
        System.out.println(b + " Moved: " + moved.toString());
        
        // Turn 3: Move black pawn again
        moved = b.move(4, 0, 3, 0);
        System.out.println(b + " Moved: " + moved.toString());
        
        // Turn 4: White pawn eats black pawn
        moved = b.move(3, 1, 4, 0);
        System.out.println(b + " Moved: " + moved.toString());
        
        // Turn 5: Move another black pawn
        moved = b.move(6, 2, 4, 2);
        System.out.println(b + " Moved: " + moved.toString());
    
        // Turn 6: Move another white pawn
        moved = b.move(1, 3, 3, 3);
        System.out.println(b + " Moved: " + moved.toString());
    
        // Turn 7: Black pawn eats white pawn
        moved = b.move(4, 2, 3, 3);
        System.out.println(b + " Moved: " + moved.toString());
    
        // Turn 8: White pawn eats black pawn
        moved = b.move(3, 4, 4, 3);
        System.out.println(b + " Moved: " + moved.toString());
    }
}