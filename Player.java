package tictactoe;

import java.util.ArrayList;

public class Player {

    ArrayList<Integer> ownFields = new ArrayList<>();
    char letter;

    public Player(char letter){
        this.letter = letter;
    }

    public void setField(int y, int x){
        ownFields.add((y*3) + x);
    }

}
