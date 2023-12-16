class game {
    
    public static void main(String[] args) {
        board b = new board();
        System.out.println(b);
        Boolean moved = b.move(1, 1, 2, 1);
        System.out.println(b + moved.toString());
    }
}