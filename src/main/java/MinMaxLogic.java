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
     * @param depth      ゲーム木の深さ
     * @param gameBoard  ゲーム盤
     * @param playerMove player名
     * @return ゲーム盤のy軸, x軸を保持したint[][]の二次元配列
     */
    public int[] calcMinMax(int depth, MOVES[][] gameBoard, MOVES playerMove) {

        int bestScore = 0;
        if (playerMove == MOVES.CPU_MOVE) {
            bestScore = -100;
        } else {
            bestScore = 100;
        }


        int score;

        int bestRow = -1;
        int bestColumn = -1;


        List<int[]> capableMove = this.makeCapableMOveList(gameBoard);
        Simulator simulator = new Simulator();

        // 試合が終了か、深さが0の場合は、スコアを
        if (capableMove.isEmpty() || depth == 0) {
            bestScore = simulator.calcScore(gameBoard);
        } else {
            for (int[] moveSpot : capableMove) {

                gameBoard[moveSpot[0]][moveSpot[1]] = playerMove;

                if (playerMove == MOVES.CPU_MOVE) {
                    score = calcMinMax(depth - 1, gameBoard, MOVES.USER_MOVE)[0];
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = moveSpot[0];
                        bestColumn = moveSpot[1];
                    }
                } else if (playerMove == MOVES.USER_MOVE) {
                    score = calcMinMax(depth - 1, gameBoard, MOVES.CPU_MOVE)[0];
                    if (bestScore > score) {
                        bestScore = score;
                        bestRow = moveSpot[0];
                        bestColumn = moveSpot[1];
                    }
                }

                gameBoard[moveSpot[0]][moveSpot[1]] = MOVES.NO_MOVE;
            }
        }


        return new int[]{bestScore, bestRow, bestColumn};

    }

    /**
     * 現在石を置くことが可能なすべての手をリスト化する（NO_MOVEが存在しているGameBoardの場所）
     *
     * @param gameBoard ゲームの盤
     * @return NO_MOVEが存在するGameBoard上の場所の一覧を格納したList
     */
    List<int[]> makeCapableMOveList(MOVES[][] gameBoard) {

        List<int[]> capableMoveList = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> {
            if (gameBoard[i][j] == MOVES.NO_MOVE) {
                capableMoveList.add(new int[]{i, j});
            }
        }));

        return capableMoveList;
    }


}
