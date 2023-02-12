package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

    ArrayList<ArrayList<Character>> tictactoeGrid = new ArrayList<>(3);
    ArrayList<ArrayList<Integer>> winningFields = new ArrayList<>();

    Player playerX;
    Player playerY;

    public Grid(String start, Player playerY, Player playerX){

        this.playerY = playerY;
        this.playerX = playerX;

        // two dimensional ArrayList {[],[],[]}
        for (int i = 0; i < 3; i++) {
            tictactoeGrid.add(new ArrayList());
        }

        ArrayList topRow = (ArrayList) Arrays.asList(0, 1, 2);
        ArrayList middleRow = (ArrayList) Arrays.asList(3, 4, 5);
        ArrayList bottomRow = (ArrayList) Arrays.asList(6, 7, 8);
        ArrayList leftColumn = (ArrayList) Arrays.asList(0, 3, 6);
        ArrayList middleColumn = (ArrayList) Arrays.asList(1, 4, 7);
        ArrayList rightColumn = (ArrayList) Arrays.asList(2, 5, 8);

        winningFields.add(topRow);
        winningFields.add(middleRow);
        winningFields.add(bottomRow);
        winningFields.add(leftColumn);
        winningFields.add(middleColumn);
        winningFields.add(rightColumn);

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
                    playerY.setField(i, j);
                }
                counter++;
            }
        }
    }

    public void printGrid(){
        System.out.println("---------");

        for (int i = 0; i < tictactoeGrid.size(); i++) {
            System.out.print("| ");
            for (int j = 0; j < tictactoeGrid.get(i).size(); j++) {
                System.out.print(tictactoeGrid.get(i).get(j) + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    public boolean place(int y, int x, Player player) {

        try {

        } catch (Exception e) {
            System.out.println("Coordinates should be from 1 to 3!");
        }

        if (tictactoeGrid.get(y).get(x).equals(' ')) {
            tictactoeGrid.get(y).remove(x);
            tictactoeGrid.get(y).add(x, player.letter);
            player.setField(y, x);
        } else {
            System.out.println("This cell is occupied! Choose another one!");
        }
        return false;
    }

    public boolean checkForWinner(){



        return false;
    }

    //ArrayList grid
    //printGrid
    //placeLetter
    //checkForWinner


}
