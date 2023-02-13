package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

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

    Player playerX;
    Player playerAI;

    int roundCounter = 0;

    public Grid(String start, Player playerAI, Player playerX){
        this.playerAI = playerAI;
        this.playerX = playerX;

        int counter = 0;
        for (int i = 0; i < tictactoeGrid.size(); i++) {
            for (int j = 0; j < tictactoeGrid.size(); j++) {
                if (start.charAt(counter) == '_') {
                    tictactoeGrid.get(i).add(' ');
                } else if (start.charAt(counter) == 'X'){
                    tictactoeGrid.get(i).add(start.charAt(counter));
                    playerX.setField(i, j);
                } else {
                    tictactoeGrid.get(i).add('O');
                    playerAI.setField(i, j);
                }
                counter++;
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

    public boolean place(int y, int x, Player player) {

        boolean isValid = false;
        y--;
        x--;

        try {
            if (tictactoeGrid.get(y).get(x).equals(' ')) {
                tictactoeGrid.get(y).remove(x);
                tictactoeGrid.get(y).add(x, player.letter);
                player.setField(y, x);
                isValid = true;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } catch (Exception e) {
            System.out.println("Coordinates should be from 1 to 3!");
        }

        return isValid;
    }

    public boolean checkForWinner(Player player){

        boolean isGameFinished = false;
        roundCounter++;

        for (ArrayList<Integer> element:
             winningFields) {
            if (player.ownFields.containsAll(element)) {
                System.out.printf("%c wins", player.letter);
                isGameFinished = true;
            }
        }

        if (roundCounter == 9) {
            System.out.println("Draw");
            isGameFinished = true;
        } else if (!isGameFinished) {
            System.out.println("Game not finished");
        }

        return isGameFinished;
    }
}
