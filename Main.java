package tictactoe;

public class Main {
    public static void main(String[] args) {
        AIPlayer playerAI = new AIPlayer('O');
        Player playerX = new Player('X');
        Player playerChosen;
        boolean isGameFinished;

        Grid grid = new Grid(playerAI, playerX);
        grid.printGrid();

        do {
            if (playerAI.ownFields.size() >= playerX.ownFields.size()) {
                playerChosen = playerX;
                int[] array = grid.getCoordinates();
                grid.place(array[0], array[1], playerX);
            } else {
                playerChosen = playerAI;
                int[] array = playerAI.getRandomField();
                grid.place(array[0], array[1], playerAI);
            }
            grid.printGrid();
            isGameFinished = grid.checkForWinner(playerChosen);

        } while (!isGameFinished);
    }
}
