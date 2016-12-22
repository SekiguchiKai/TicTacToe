import java.util.*;


/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class Simulator {
    /**
     * 現在のゲーム盤の状況で、指定された場所に石を置いた時の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    int calcScore(MOVES[][] gameBoard) {
        int totalScore = 0;
        // 横
        totalScore += calcLineScore(gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
        totalScore += calcLineScore(gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
        totalScore += calcLineScore(gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);

        // 縦
        totalScore += calcLineScore(gameBoard[0][0], gameBoard[1][0], gameBoard[2][0]);
        totalScore += calcLineScore(gameBoard[0][1], gameBoard[1][1], gameBoard[2][1]);
        totalScore += calcLineScore(gameBoard[0][2], gameBoard[1][2], gameBoard[2][2]);

        // 斜め
        totalScore += calcLineScore(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]);
        totalScore += calcLineScore(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]);

        return totalScore;

    }

    /**
     * 引数として受け取ったラインの点数を求める
     * 点数の計算方法は以下
     * <p>
     * CPUの石1つ : 1
     * USERの石1つ : -1
     * EMPTY : 0
     * <p>
     * 合計
     * 【CPU】
     * CPUの石が3つ揃っていた場合 : 3
     * CPUの石が2つ揃っていた場合 : 2
     * CPUの石が1つ揃っていた場合 : 1
     * <p>
     * 【USER】
     * USERの石が3つ揃っていた場合 : -3
     * USERの石が2つ揃っていた場合 : -2
     * USERの石が1つ揃っていた場合 : -1
     * <p>
     * 【EMPTY】
     * EMPTYの場合 : 0
     *
     * @param moves1 石1
     * @param moves2 石2
     * @param moves3 石3
     * @return ラインの合計点数
     */
    int calcLineScore(MOVES moves1, MOVES moves2, MOVES moves3) {
        List<MOVES> movesList = Arrays.asList(moves1, moves2, moves3);
        List<Integer> lineScoreList = new ArrayList<>();

        movesList.forEach(moves -> {
            if (moves == MOVES.CPU_MOVE) {
                lineScoreList.add(1);
            } else if (moves == MOVES.USER_MOVE) {
                lineScoreList.add(-1);
            } else {
                lineScoreList.add(0);
            }
        });

        int lineScore = 0;
        for (int score : lineScoreList) {
            lineScore += score;
        }
        return lineScore;
    }


}
