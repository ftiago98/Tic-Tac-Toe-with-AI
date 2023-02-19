package tictactoe;

public enum GameStates {
    X_WINS("X wins"),
    O_WINS("O_wins"),
    DRAW("Draw"),
    NOT_FINISHED("Game not finished");

    private String stateMSG;

    GameStates(String stateMSG) {
        this.stateMSG = stateMSG;
    }
}
