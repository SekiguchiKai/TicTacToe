import java.util.*;
import java.util.stream.Stream;


/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class Simulator {

    private String result;


    /**
     * 現在のゲーム盤の状況で、指定された場所に石を置いた時の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    int calcScore(MOVES[] gameBoard) {

        int totalScore = 0;
        // 横
        totalScore += calcLineScore(gameBoard[0], gameBoard[1], gameBoard[2]);
        totalScore += calcLineScore(gameBoard[3], gameBoard[4], gameBoard[5]);
        totalScore += calcLineScore(gameBoard[6], gameBoard[7], gameBoard[8]);

        // 縦
        totalScore += calcLineScore(gameBoard[0], gameBoard[3], gameBoard[6]);
        totalScore += calcLineScore(gameBoard[1], gameBoard[4], gameBoard[7]);
        totalScore += calcLineScore(gameBoard[2], gameBoard[5], gameBoard[8]);

        // 斜め
        totalScore += calcLineScore(gameBoard[0], gameBoard[4], gameBoard[8]);
        totalScore += calcLineScore(gameBoard[2], gameBoard[4], gameBoard[6]);

        return totalScore;
    }


    /**
     * 引数として受け取ったラインの点数を求める
     * 点数の計算方法は以下
     * <p>
     * CPUの石1つ :1
     * USERの石1つ :-1
     * EMPTY :0
     * <p>
     * 合計
     * 【CPU】
     * CPUの石が3つ揃っていた場合 :3
     * CPUの石が2つ揃っていた場合 :2
     * CPUの石が1つ揃っていた場合 :1
     * <p>
     * 【USER】
     * USERの石が3つ揃っていた場合 :-3
     * USERの石が2つ揃っていた場合 :-2
     * USERの石が1つ揃っていた場合 :-1
     * <p>
     * 【EMPTY】
     * EMPTYの場合 :0
     *
     * @param moves1 石1
     * @param moves2 石2
     * @param moves3 石3
     * @return ラインの合計点数
     */

    int calcLineScore(MOVES moves1, MOVES moves2, MOVES moves3) {
        int score = 0;

        List<MOVES> aList = Arrays.asList(moves1, moves2, moves3);


        for (MOVES moves : aList) {
            if (moves == MOVES.CPU_MOVE) {
                score += 10;
            } else if (moves == MOVES.USER_MOVE) {
                score -= 10;
            }
        }

        // 勝敗がつくときには、点数の差を大きくする
        if (score == 30) {
            score = 100;
        } else if (score == -30) {
            score = -100;
        }

        return score;


    }
}



