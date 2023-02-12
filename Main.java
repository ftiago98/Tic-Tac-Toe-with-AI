package tictactoe;


public class Main {
    public static void main(String[] args) {
        Player playerY = new Player('O');
        Player playerX = new Player('X');

        Grid grid = new Grid("X_XOO_XX_", playerY, playerX);
        grid.printGrid();
        grid.place(2, 2, playerX);
        grid.printGrid();
        grid.checkForWinner(playerX);
    }
}
