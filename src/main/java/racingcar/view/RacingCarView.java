package racingcar.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.exception.InValidInputException;
import racingcar.model.RacingCar;

public class RacingCarView {

    Scanner sc;

    public RacingCarView() {
        sc = new Scanner(System.in);
    }

    public List<String> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = List.of(sc.nextLine().split(","));

        for (String carName : carNames) {
            checkCarName(carName);
        }

        return carNames;
    }

    private static void checkCarName(String carName) {
        if (carName.length() > 5) {
            throw new InValidInputException("[ERROR] 이름은 5자 이하만 가능하다.");
        }
    }

    public int requestTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(sc.nextLine());
    }

    public void displayRacingCarStatus(List<RacingCar> racingCarList) {
        racingCarList.forEach(racingCar -> System.out.println(
            racingCar.getName() + " : " + "-".repeat(racingCar.getMoves())));
        System.out.println();
    }

    public void startGameRound() {
        System.out.println("\n실행 결과");
    }

    public void displayWinners(List<RacingCar> racingCars) {
        String winners = racingCars.stream()
            .map(RacingCar::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
