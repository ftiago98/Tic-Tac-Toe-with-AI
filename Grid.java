package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

    ArrayList<ArrayList<Character>> tictactoeGrid;
    ArrayList<ArrayList<Integer>> winningFields;

    Player playerX;
    Player playerY;

    public Grid(String start, Player playerY, Player playerX){
        this.playerY = playerY;
        this.playerX = playerX;

        // two dimensional ArrayList {[],[],[]}
        for (int i = 0; i < 3; i++) {
            tictactoeGrid = new ArrayList<>(
                    Arrays.asList(new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>())
            );
        }

        winningFields = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(0,1,2)),
                        new ArrayList<>(Arrays.asList(3,4,5)),
                        new ArrayList<>(Arrays.asList(6,7,8)),
                        new ArrayList<>(Arrays.asList(0,3,6)),
                        new ArrayList<>(Arrays.asList(1,4,7)),
                        new ArrayList<>(Arrays.asList(2,5,8)),
                        new ArrayList<>(Arrays.asList(0,4,8)),
                        new ArrayList<>(Arrays.asList(2,4,6))));

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

    public boolean checkForWinner(Player player){

        for (ArrayList<Integer> element:
             winningFields) {
            if (player.ownFields.containsAll(element)) {
                System.out.println("YOU WOOON");
            } else {
                System.out.println("YOU DID NOT WIN");
            }
        }

        return false;
    }
}
