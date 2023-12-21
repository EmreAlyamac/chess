import java.awt.Color;

class helpers {
   
    private static int firstClickX = -1;
    private static int firstClickY = -1;
    

    public static Color highlight(int x, int y, Color color, displayBoard display, board board) {

        Color original_color = display.highlightPanel(x, y, color);
        return original_color;

    }


    static Color normalColor = new Color(0, 0, 0);

    static int[][] posible_moves = new int[64][2];
    static int count_2 = 0;

    public static void higlightMoves(int x, int y, board b, displayBoard display) {
        Color highlightColor = new Color(0, 255, 0);
        int[][] moves = new int[64][2];
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                moves[count][0] = i;
                moves[count][1] = j;
                count++;
            }
        }
        for(int i = 0; i < 64; i++){
            if (b.check_move(x, y, moves[i][0], moves[i][1])) {
                highlight(moves[i][0], moves[i][1], highlightColor, display, b);
                posible_moves[count_2][0] = moves[i][0];
                posible_moves[count_2][1] = moves[i][1];
                count_2++;
            }
        }
    }

    public static void unhighlightMoves(displayBoard display) {
        for (int i = 0; i < count_2; i++) {
            int decider = (posible_moves[i][0] + posible_moves[i][1]) % 2;
            if (decider == 0) {
                normalColor = new Color(87, 36, 3);
            } else {
                normalColor = new Color(255, 139, 64);
            }
            highlight(posible_moves[i][0], posible_moves[i][1], normalColor, display, null);
            
        }
        count_2 = 0;
        
        
    }



    public static void clicked(int x ,int y, board b, displayBoard display){
        Color clickedColor = new Color(130, 178, 255);
        System.out.println("clicked on " + x + " " + y + "");
        if (firstClickX == -1 && firstClickY == -1) {
            
            normalColor = highlight(x, y, clickedColor, display, b);
            // this line below is causing some pieces to return false when checked valid move
            higlightMoves(x, y, b, display);
            System.out.println("highlighted  posible moves " + x + " " + y + "" );

            firstClickX = x;
            firstClickY = y;
            


        } else {
            // This is the second click, so we move
            System.out.println("moving from " + firstClickX + " " + firstClickY + " to " + x + " " + y + "");
            boolean moved = b.move(firstClickX, firstClickY, x, y);
            System.out.println("moved: " + moved);
        
    
            // Reset the first click coordinates
            highlight(firstClickX, firstClickY, normalColor, display, b);
            firstClickX = -1;
            firstClickY = -1;
            unhighlightMoves(display);
        }
    }
}
