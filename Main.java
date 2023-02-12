package tictactoe;


public class Main {
    public static void main(String[] args) {
        Player playerY = new Player('Y');
        Player playerX = new Player('X');

        Grid grid = new Grid("X_XOO_OX_", playerY, playerX);
        grid.printGrid();
        grid.place(2, 2, playerX);
        grid.printGrid();
    }
}
