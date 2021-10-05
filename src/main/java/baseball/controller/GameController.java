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
        do {
            playGame();
        } while(getContinueSelect());
    }

    private boolean getContinueSelect() {
        String userSelect = inputView.inputContinueOrEnd();

        while (!userSelect.equals("1") && !userSelect.equals("2")) {
            userSelect = inputView.inputContinueOrEnd();
        }

        return userSelect.equals("1");
    }

    private void playGame() {
        Computer computer = new Computer();
        Game game = new Game(computer);

        do {
            String userNumber = inputView.inputNumber();
            outputView.printMessage(game.checkInputNumber(userNumber));
        } while (!game.isFinished());

        outputView.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
