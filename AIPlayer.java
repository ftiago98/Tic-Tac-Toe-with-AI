package tictactoe;

import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char letter) {
        super(letter);
    }

    public int[] getRandomField(){
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        int yCoordinate = random.nextInt(3-1+1)+1;
        int xCoordinate = random.nextInt(3-1+1)+1;

        return new int[]{yCoordinate, xCoordinate};
    }

}
