package baseball.view;

import baseball.config.message;
import nextstep.utils.Console;

public class InputView {

	public String inputNumber() {
		System.out.print(message.INPUT_NUMBER);
		return Console.readLine();
	}

	public String inputContinueOrEnd() {
		System.out.println(message.GAME_CONTINUE_SELECT);
		return Console.readLine();
	}
}
