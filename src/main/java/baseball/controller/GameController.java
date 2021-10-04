package baseball.controller;

import baseball.domain.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Game game;
    private InputView inputView;
    private OutputView outputView;

    private boolean isGameFinished;

    public GameController() {
        game = new Game();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        while(!game.isFinished()) {
            String inputNumber = inputView.inputNumber();
            outputView.printMessage(game.checkInputNumber(inputNumber));
        }
    }
}
