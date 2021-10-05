package baseball.view;

import nextstep.utils.Console;

public class InputView {
	public String inputNumber() {
		System.out.print("숫자를 입력해주세요: ");
		return Console.readLine();
	}

	public String inputContinueOrEnd() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Console.readLine();
	}
}
