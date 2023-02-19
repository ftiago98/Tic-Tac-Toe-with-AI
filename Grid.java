package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

    Player playerX;
    Player playerO;

    /* tictactoeGrid
    |       |
    |       |
    |       |
     */
    ArrayList<ArrayList<Character>> tictactoeGrid = new ArrayList<>(
            Arrays.asList(new ArrayList<>(3),
                    new ArrayList<>(3),
                    new ArrayList<>(3))
    );

    public Grid(Player playerO, Player playerX){
        this.playerO = playerO;
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

    public boolean isFieldEmpty (int y, int x){
        boolean isFieldEmpty = false;

        try {
            if (tictactoeGrid.get(--y).get(--x).equals(' ')) {
                isFieldEmpty = true;
            }
        } catch (Exception e) {
            System.out.println("Coordinates should be from 1 to 3!");
        }
        return isFieldEmpty;
    }

    public void place(int y, int x, Player player) {
        tictactoeGrid.get(--y).remove(--x);
        tictactoeGrid.get(y).add(x, player.letter);
        player.setField(y, x);
    }


}
