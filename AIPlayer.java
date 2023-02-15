package tictactoe;

import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char letter) {
        super(letter);
    }

    public int[] getCoordinates(){
        Random random = new Random();
        System.out.println("Making move level \"easy\"");

        // random.nextInt(upper - lower +1) + lower || 1 -> 3 incl.
        int yCoordinate = random.nextInt(3-1+1)+1;
        int xCoordinate = random.nextInt(3-1+1)+1;

        return new int[]{yCoordinate, xCoordinate};
    }

}
