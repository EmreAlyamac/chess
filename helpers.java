import java.awt.Color;

class helpers {
   
    private static int firstClickX = -1;
    private static int firstClickY = -1;
    

    public static Color highlight(int x, int y, Color color, displayBoard display, board board) {
        if((firstClickX == -1) && (firstClickY == -1)){
            Color original_color = display.highlightPanel(x, y, color);
            return original_color;
        }
        return null;
    }

    public static void reset(int x, int y, Color color, displayBoard display) {
        if((firstClickX == -1) && (firstClickY == -1)){
            display.resetPanel(x, y, color);
        }
    }

    public static void clicked(int x ,int y, board b, displayBoard display){
        Color clickedColor = new Color(0, 0, 0);
        Color normalColor = new Color(255, 139, 64);
        System.out.println("clicked on " + x + " " + y + "");
        if (firstClickX == -1 && firstClickY == -1) {
            
            normalColor = highlight(x, y, clickedColor, display, b);
            display.update(b);

            // This is the first click
            firstClickX = x;
            firstClickY = y;
    
            // Highlight the clicked piece

        } else {
            // This is the second click, so we move
            boolean moved = b.move(firstClickX, firstClickY, x, y);
            
            if(moved){
                
    
                // Reset the color of the moved piece
                reset(firstClickX, firstClickY, normalColor, display);
                display.update(b);
                
            }
    
            // Reset the first click coordinates
            firstClickX = -1;
            firstClickY = -1;
        }
    }
}
