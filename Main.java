package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player playerO = new AIPlayer('O');
        Player playerX = null;
        Player playerChosen;

        boolean isInputValid = true;
        boolean isUserPlaying = true;
        boolean isGameFinished;

        do {
            System.out.println("Input command:");
            String input = scanner.nextLine();

            if (input.equals("start easy easy")){ // AI vs AI
                playerX = new AIPlayer('X');
            } else if (input.equals("start easy user")) { //Player vs AI
                playerX = new Player('X');
            } else {
                System.out.println("Bad parameters!"); //false input
                scanner.nextLine();
                isInputValid = false;
            }
        } while (!isInputValid);

        Grid grid = new Grid(playerO, playerX);
        grid.printGrid();

        do {
            if (playerO.ownFields.size() >= playerX.ownFields.size()) {
                playerChosen = playerX;
                int[] array = playerX.getCoordinates();
                grid.place(array[0], array[1], playerX);
            } else {
                playerChosen = playerO;
                int[] array = playerO.getCoordinates();
                grid.place(array[0], array[1], playerO);
            }
            grid.printGrid();
            isGameFinished = grid.checkForWinner(playerChosen);
        } while (!isGameFinished);
    }
}
