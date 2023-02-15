package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player playerO = null;
        Player playerX = null;
        Player playerChosen;

        boolean isInputValid;
        boolean isGameFinished;
        boolean isPlayerXAI = false;
        boolean isPlayerOAI = false;

        do {
            isInputValid = true;
            System.out.println("Input command:");
            String input = scanner.nextLine();

            switch (input) {
                case "start easy easy":  // AI vs AI
                    playerX = new AIPlayer('X');
                    playerO = new AIPlayer('O');
                    isPlayerXAI = true;
                    isPlayerOAI = true;
                    break;
                case "start easy user":  //Player vs AI
                    playerX = new AIPlayer('X');
                    playerO = new Player('O');
                    isPlayerXAI = true;
                    break;
                case "start user easy":
                    playerX = new Player('X');
                    playerO = new AIPlayer('O');
                    isPlayerOAI = true;
                    break;
                case "start user user":  //User vs User
                    playerX = new Player('X');
                    playerO = new Player('O');
                    break;
                case "exit":  //Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bad parameters!"); //false input
                    isInputValid = false;
            }
        } while (!isInputValid);

        Grid grid = new Grid(playerO, playerX);
        grid.printGrid();

        do {
            if (playerO.ownFields.size() >= playerX.ownFields.size()) {
                playerChosen = playerX;
                int[] array = playerX.getCoordinates();
                if (grid.isFieldEmpty(array[0], array[1])) {
                    if (isPlayerXAI){
                        System.out.println("Making move level \"easy\"");
                    }
                    grid.place(array[0], array[1], playerX);
                    grid.printGrid();
                } else if (!isPlayerXAI){
                    System.out.println("This cell is occupied! Choose another one!");
                    grid.printGrid();
                }
            } else {
                playerChosen = playerO;
                int[] array = playerO.getCoordinates();
                if (grid.isFieldEmpty(array[0], array[1])) {
                    if (isPlayerOAI) {
                        System.out.println("Making move level \"easy\"");
                    }
                    grid.place(array[0], array[1], playerO);
                    grid.printGrid();
                } else if (!isPlayerOAI){
                    System.out.println("This cell is occupied! Choose another one!");
                    grid.printGrid();
                }
            }
            isGameFinished = grid.checkForWinner(playerChosen);
        } while (!isGameFinished);
    }
}
