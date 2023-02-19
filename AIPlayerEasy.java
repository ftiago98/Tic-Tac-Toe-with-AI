package tictactoe;

import java.util.Random;

public class AIPlayerEasy extends Player {

    public AIPlayerEasy(char letter) {
        super(letter);
    }

    @Override
    public int[] getCoordinates() {
        Random random = new Random();

        // random.nextInt(upper - lower +1) + lower || 1 -> 3 incl.
        int yCoordinate = random.nextInt(3 - 1 + 1) + 1;
        int xCoordinate = random.nextInt(3 - 1 + 1) + 1;

        return new int[]{yCoordinate, xCoordinate};
    }

}
