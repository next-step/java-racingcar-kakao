package racingcar.view;

import racingcar.dto.CarDTO;

import java.util.List;

public class OutputView {

    private static final String PLAY_RESULT_MESSAGE = "\n실행 결과";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String MOVING_BAR = "-";
    private static final String WINNER_JOINING_DELIMITER = ", ";
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    private OutputView() {
    }

    public static void printPlayTitle() {
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public static void printRoundResult(final List<CarDTO> carDTOs) {
        for (final CarDTO carDTO : carDTOs) {
            System.out.println(carDTO.getName() + RESULT_SEPARATOR + MOVING_BAR.repeat(carDTO.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(final List<String> winnerNames) {
        System.out.println(String.join(WINNER_JOINING_DELIMITER, winnerNames) + FINAL_RESULT_MESSAGE);
    }
}
