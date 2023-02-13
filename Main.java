package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player playerAI = new Player('O');
        Player playerX = new Player('X');
        Player player = null;
        boolean isGameFinished = false;
        boolean isValid = false;


        System.out.println("Enter the cells:");
        String cellsInput = scanner.next();

        Grid grid = new Grid(cellsInput, playerAI, playerX);
        grid.printGrid();

        do {
            System.out.println("Enter the coordinates:");
            try {
                int yCoordinate = scanner.nextInt();
                int xCoordinate = scanner.nextInt();

                if (playerAI.ownFields.size() >= playerX.ownFields.size()) {
                    player = playerX;
                } else {
                    player = playerAI;
                }
                isValid = grid.place(yCoordinate, xCoordinate, player);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); //discard invalid token from console. If not it will throw infinity loop with exceptions.
            }

            if (isValid) {
                grid.printGrid();
                isGameFinished = grid.checkForWinner(player);
            }

        } while (isGameFinished == false);

    }
}
