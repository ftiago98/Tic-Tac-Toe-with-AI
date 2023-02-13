package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Grid {

    Scanner scanner = new Scanner(System.in);
    Player playerX;
    Player playerAI;

    ArrayList<ArrayList<Character>> tictactoeGrid = new ArrayList<>(
            Arrays.asList(new ArrayList<>(3),
                    new ArrayList<>(3),
                    new ArrayList<>(3))
    );
    ArrayList<ArrayList<Integer>> winningFields = new ArrayList<>(
            Arrays.asList(new ArrayList<>(Arrays.asList(0,1,2)),
            new ArrayList<>(Arrays.asList(3,4,5)),
            new ArrayList<>(Arrays.asList(6,7,8)),
            new ArrayList<>(Arrays.asList(0,3,6)),
            new ArrayList<>(Arrays.asList(1,4,7)),
            new ArrayList<>(Arrays.asList(2,5,8)),
            new ArrayList<>(Arrays.asList(0,4,8)),
            new ArrayList<>(Arrays.asList(2,4,6))));

    public Grid(Player playerAI, Player playerX){
        this.playerAI = playerAI;
        this.playerX = playerX;

        for (int i = 0; i < tictactoeGrid.size(); i++) {
            for (int j = 0; j < tictactoeGrid.size(); j++) {
                tictactoeGrid.get(i).add(' ');
            }
        }
    }

    public void printGrid(){
        System.out.println("---------");
        for (ArrayList<Character> characters : tictactoeGrid) {
            System.out.print("| ");
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public int[] getCoordinates () {
        boolean isInputValid;
        int xCoordinate = 0;
        int yCoordinate = 0;
        do {
            System.out.println("Enter the coordinates:");
            try {
                yCoordinate = scanner.nextInt();
                xCoordinate = scanner.nextInt();
                isInputValid = true;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); //discard invalid token from console. If not it will throw infinity loop with exceptions.
                isInputValid = false;
            }
        } while (!isInputValid);

        return new int[]{yCoordinate, xCoordinate};
    }

    public void place(int y, int x, Player player) {
        y--; //Array start by Index 0 not 1
        x--; //Array start by Index 0 not 1
        try {
            if (tictactoeGrid.get(y).get(x).equals(' ')) {
                tictactoeGrid.get(y).remove(x);
                tictactoeGrid.get(y).add(x, player.letter);
                player.setField(y, x);
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } catch (Exception e) {
            System.out.println("Coordinates should be from 1 to 3!");
        }
    }

    public boolean checkForWinner(Player player){

        boolean isGameFinished = false;

        for (ArrayList<Integer> element:
             winningFields) {
            if (player.ownFields.containsAll(element)) {
                System.out.printf("%c wins", player.letter);
                isGameFinished = true;
            }
        }

        if (playerX.ownFields.size() == 5) {  //TicTacToe can't have more than 5 X
            System.out.println("Draw");
            isGameFinished = true;
        }

        return isGameFinished;
    }
}
