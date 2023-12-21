import java.awt.Color;

class helpers {
   
    private static int firstClickX = -1;
    private static int firstClickY = -1;
    

    public static Color highlight(int x, int y, Color color, displayBoard display, board board) {

        Color original_color = display.highlightPanel(x, y, color);
        return original_color;

    }


        static Color normalColor = new Color(0, 0, 0);

    public static void clicked(int x ,int y, board b, displayBoard display){
        Color clickedColor = new Color(130, 178, 255);
        System.out.println("clicked on " + x + " " + y + "");
        if (firstClickX == -1 && firstClickY == -1) {
            
            normalColor = highlight(x, y, clickedColor, display, b);

            firstClickX = x;
            firstClickY = y;


        } else {
            // This is the second click, so we move
            System.out.println("moving from " + firstClickX + " " + firstClickY + " to " + x + " " + y + "");
            boolean moved = b.move(firstClickX, firstClickY, x, y);
 
        
    
            // Reset the first click coordinates
            highlight(firstClickX, firstClickY, normalColor, display, b);
            firstClickX = -1;
            firstClickY = -1;
        }
    }
}
