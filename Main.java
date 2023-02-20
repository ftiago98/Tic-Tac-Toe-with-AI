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

        //game menu
        do {
            isInputValid = true;
            System.out.println("Input command:");
            String input = scanner.nextLine();

            switch (input) {
                case "start easy easy":  // AI vs AI
                    playerX = new AIPlayerEasy('X');
                    playerO = new AIPlayerEasy('O');
                    break;
                case "start easy user":  //Player vs AI (Player = X)
                    playerX = new AIPlayerEasy('X');
                    playerO = new Player('O');
                    break;
                case "start user easy": //Player vs AI (Player = O)
                    playerX = new Player('X');
                    playerO = new AIPlayerEasy('O');
                    break;
                case "start user user":  //User vs User
                    playerX = new Player('X');
                    playerO = new Player('O');
                    break;
                case "start medium user":  //User vs User
                    playerX = new AIPlayerMedium('X');
                    playerO = new Player('O');
                    ((AIPlayerMedium) playerX).setEnemyPlayer(playerO);
                    break;
                case "start user medium":  //User vs User
                    playerX = new Player('X');
                    playerO = new AIPlayerMedium('O');
                    ((AIPlayerMedium) playerO).setEnemyPlayer(playerX);
                    break;
                case "start medium medium":  //User vs User
                    playerX = new AIPlayerMedium('X');
                    playerO = new AIPlayerMedium('O');
                    ((AIPlayerMedium) playerX).setEnemyPlayer(playerO);
                    ((AIPlayerMedium) playerO).setEnemyPlayer(playerX);
                    break;
                case "exit":  //Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bad parameters!"); //false input
                    isInputValid = false;
            }
        } while (!isInputValid);

        Grid grid = new Grid(playerO, playerX); //Initialize Grid with both Players
        grid.printGrid();

        do {
            //find which player's turn it is
            if (playerO.ownFields.size() >= playerX.ownFields.size()) {
                playerChosen = playerX;
            } else {
                playerChosen = playerO;
            }

            //get coordinates
            int[] coordinates;
            coordinates = playerChosen.getCoordinates();

            //check if coordinates are empty
            if (grid.isFieldEmpty(coordinates[0], coordinates[1])){
                if(playerChosen.getClass().getName().equals("tictactoe.AIPlayerEasy")) { //Print only if Object = AIPlayer
                    System.out.println("Making move level \"easy\"");
                }
                if(playerChosen.getClass().getName().equals("tictactoe.AIPlayerMedium")) { //Print only if Object = AIPlayer
                    System.out.println("Making move level \"medium\"");
                }
                grid.place(coordinates[0], coordinates[1], playerChosen);
                grid.printGrid();
            } else if (!playerChosen.getClass().getName().equals("tictactoe.AIPlayerEasy") && !playerChosen.getClass().getName().equals("tictactoe.AIPlayerMedium")){
                System.out.println("This cell is occupied! Choose another one!");
                grid.printGrid();
            }
            isGameFinished = playerChosen.checkForWinner();
        } while (!isGameFinished);
    }
}
