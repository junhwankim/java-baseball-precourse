package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private InputView inputView;
    private OutputView outputView;

    private boolean isGameFinished;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Computer computer = new Computer();
        Game game = new Game(computer);

        while(!game.isFinished()) {
            String userNumber = inputView.inputNumber();
            outputView.printMessage(game.checkInputNumber(userNumber));
        }

        outputView.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
