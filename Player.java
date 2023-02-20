package tictactoe;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> ownFields = new ArrayList<>();
    char letter;

    //All possible combinations to win
    ArrayList<ArrayList<Integer>> rowsToWin = new ArrayList<>(
            Arrays.asList(new ArrayList<>(Arrays.asList(0,1,2)),
                    new ArrayList<>(Arrays.asList(3,4,5)),
                    new ArrayList<>(Arrays.asList(6,7,8)),
                    new ArrayList<>(Arrays.asList(0,3,6)),
                    new ArrayList<>(Arrays.asList(1,4,7)),
                    new ArrayList<>(Arrays.asList(2,5,8)),
                    new ArrayList<>(Arrays.asList(0,4,8)),
                    new ArrayList<>(Arrays.asList(2,4,6))));

    public Player(char letter){
        this.letter = letter;
    }

    public void setField(int y, int x){
        ownFields.add((y*3) + x);
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

    public boolean checkForWinner(){

        boolean isGameFinished = false;
        //Check for winner when playerX sets third field
        for (ArrayList<Integer> row:rowsToWin) {
            if (this.ownFields.containsAll(row)) {
                isGameFinished = true;
                System.out.printf("%c wins", this.letter);
            }
        }
        if (this.letter == 'X' && this.ownFields.size() == 5 && !isGameFinished) {
            System.out.println(GameStates.DRAW);
            isGameFinished = true;
        }
        return isGameFinished;
    }
}
