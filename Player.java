package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> ownFields = new ArrayList<>();
    char letter;

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

}
