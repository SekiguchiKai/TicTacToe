import java.util.*;
import java.util.stream.IntStream;

/**
 * ミニマックスアルゴリズムを表したクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class MinMaxLogic {

    /**
     * ミニマックスアルゴリズムを用い、ゲーム盤のy軸,x軸を保持したint[][]の二次元配列を返すメソッド
     * CPUの場合は、最大の点数を取り得るゲーム盤の場所を返し、USERの場合は、最小の点数を取り得るゲーム盤の場所を返す
     * <p>
     * このメソッドのアルゴリズム
     * 【CPUの場合】
     * 現在のゲーム木の深さの1個下の階層の点数をMinMaxで取得する
     * その取得した点数が現在保持している一番高い点数（ベストスコア）よりも高い場合は、その点数が保持されるベストスコアとなる
     * <p>
     * 【USERの場合】
     * 現在のゲーム木の深さの1個下の階層の点数をMinMaxで取得する
     * その取得した点数が現在保持している一番低い点数（ベストスコア）よりも低い場合は、その点数が保持されるベストスコアとなる
     *
     * @return ゲーム盤のy軸, x軸を保持したint[][]の二次元配列
     */
    public Integer[] calcMinMax(MOVES[][] gameBoard, PLAYER_NAME playerName) {

        int bestScore = 0;
        int score = 0;

        Integer[] scoreSpot;
        Integer[] bestScoreSpot = null;


        for (int[] moveSpot : this.makeCapableList(gameBoard)) {
            if (playerName == PLAYER_NAME.CPU) {
                Simulator simulator = new Simulator(gameBoard, moveSpot, MOVES.CPUMOVE);
                score = simulator.getBestScore();
                scoreSpot = simulator.getBestScoreSpot();
                if (score > bestScore) {
                    bestScore = score;
                    bestScoreSpot = scoreSpot;
                }
            } else {
                Simulator simulator = new Simulator(gameBoard, moveSpot, MOVES.USERMOVE);
                score = simulator.getBestScore();

                if (bestScore > score) {
                    bestScore = score;
                }

            }
        }
        return bestScoreSpot;

    }

    /**
     * 現在石を置くことが可能なすべての手をリスト化する（EMPTYが存在しているGameBoardの場所）
     *
     * @param gameBoard ゲームの盤
     * @return EMPTYが存在するGameBoard上の場所の一覧を格納したList
     */
    List<int[]> makeCapableList(MOVES[][] gameBoard) {

        List<int[]> capableMoveList = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> {
            if (gameBoard[i][j] == MOVES.EMPTY) {
                capableMoveList.add(new int[]{i, j});
            }
        }));

        return capableMoveList;
    }


}
