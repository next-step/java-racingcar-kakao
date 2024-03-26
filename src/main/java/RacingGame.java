import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.RandomGenerator;

import static view.ResultView.printCars;

public class RacingGame {

    private final String carNames;
    private final int tryNo;
    private int gameCount;

    public static List<Player> playerList = new ArrayList<>();

    public RacingGame(String carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
        makePlayer();
        printCars(playerList);
    }

    private void makePlayer() {
        String[] split = carNames.split(",");
        playerList = Player.getPlayer(split);
    }

    public void race() {
        List<Integer> ranNumList = RandomGenerator.makeRanNumList(tryNo);
        playerList = Player.updatePlayerList(playerList, ranNumList);
        gameCount++;
    }

    public List<Player> getCars() {
        return playerList;
    }

    public boolean isEnd() {
        return tryNo == gameCount;
    }

    public List<String> getWinners() {
        return Player.getWinnerName(playerList);
    }
}
