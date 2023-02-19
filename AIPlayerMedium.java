package tictactoe;

import java.util.Random;

public class AIPlayerMedium extends AIPlayerEasy{

    Player enemyPlayer;

    public AIPlayerMedium(char letter) {
        super(letter);
    }

    public void setEnemyPlayer (Player enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
    }

    public int[] getCoordinates() {
        int yCoordinate = 0;
        int xCoordinate = 0;

        //If "enemy Player" can't win with next round
        Random random = new Random();

        //If enemy can win with next round
        for (int i = 0; i < rowsToWin.size(); i++) {
            int counter = 0;
            int field = 0;
            for (int j = 0; j < 3; j++) {
                if (enemyPlayer.ownFields.contains(rowsToWin.get(i).get(j))) {
                    counter++;
                } else {
                    field = rowsToWin.get(i).get(j);
                }
            }
            if (counter == 2 && !this.ownFields.contains(field)) {
                yCoordinate = field/3 +1;
                xCoordinate = field%3 + 1;
                break;
            } else if (i == rowsToWin.size() - 1){
                // random.nextInt(upper - lower +1) + lower || 1 -> 3 incl.
                yCoordinate = random.nextInt(3 - 1 + 1) + 1;
                xCoordinate = random.nextInt(3 - 1 + 1) + 1;
            }
        }

        return new int[]{yCoordinate, xCoordinate};
    }
}
