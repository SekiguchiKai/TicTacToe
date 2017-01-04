package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.Arrays;
import java.util.List;

/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
class ScoreCalculator {

    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    int calcScore(Moves[] gameBoard) {

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
     * 引数として受け取った打ち手3つの点数の合計を求める
     * 点数の計算方法は以下
     * <p>
     * CPUの石1つ :1
     * USERの石1つ :-1
     * EMPTY :0
     * <p>
     * 合計
     * 【CPU】
     * CPUの石が3つ揃っていた場合 : 100
     * CPUの石が2つ揃っていた場合 : 20
     * CPUの石が1つ揃っていた場合 : 10
     * <p>
     * 【USER】
     * USERの石が3つ揃っていた場合 : -100
     * USERの石が2つ揃っていた場合 : -20
     * USERの石が1つ揃っていた場合 : -10
     * <p>
     * 【EMPTY】
     * EMPTYの場合 :0
     *
     * @param moves1 打ち手1
     * @param moves2 打ち手2
     * @param moves3 打ち手3
     * @return ラインの合計点数
     */

    int calcLineScore(Moves moves1, Moves moves2, Moves moves3) {

        int score = 0;

        List<Moves> movesList = Arrays.asList(moves1, moves2, moves3);

        int counter = 0;

        counter += 10;

        for (Moves moves : movesList) {
            if (moves == Moves.CPU_MOVE) {
                score += 10;
            } else if (moves == Moves.USER_MOVE) {
                score -= 10;
            }
        }

        // 勝敗がつくときには、点数の差を大きくする
        if (score == 30) {
            score = 100 - counter;
        } else if (score == -30) {
            score = counter - 100;
        }

        return score;


    }
}



