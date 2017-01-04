package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ミニマックスアルゴリズムを表したクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class MinMaxCalculator {

    public static class Best {
        private int bestScore;
        private int bestSpot;

        Best(int bestScore, int bestSpot) {
            this.bestScore = bestScore;
            this.bestSpot = bestSpot;
        }

        /**
         * bestSpotを返すためのメソッド
         *
         * @return bestSpot
         */
        public int getBestSpot() {
            return this.bestSpot;
        }
    }

    /**
     * ミニマックスアルゴリズムαβ法を用い、引数で渡された打ち手のプレイヤーに取って最適な点数とゲーム盤の場所を返す
     * CPUの場合は、最大の点数とその点数を取り得るゲーム盤の場所を返し、USERの場合は、点数とその点数を取り得るゲーム盤の場所を返す
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
     * @param depth      探索の深さ
     * @param gameBoard  ゲーム盤
     * @param playerMove player名
     * @param alpha      α
     * @param beta       β
     * @return ゲーム盤の位置
     */
    public Best calcMinMax(int depth, Moves[] gameBoard, Moves playerMove, int alpha, int beta) {


        // 石を置くことが可能な全てのゲーム盤の場所を格納したListを作成
        List<Integer> capableMove = this.makeCapableMOveList(gameBoard);

        int score;

        int spot = -1;


        ScoreCalculator scoreCalculator = new ScoreCalculator();

        // 試合が終了か、深さが0の場合は、スコアを
        if (capableMove.isEmpty() || depth == 0) {
            score = scoreCalculator.calcScore(gameBoard);
            return new Best(score, spot);
        } else {
            // CPUの点数であるαの方が、βよりも大きい場合、それ以上探索しなくても良い(その時のαが最大なので)ので、探索を打ち切る
            for (int moveSpot : capableMove) {

                gameBoard[moveSpot] = playerMove;

                if (playerMove == Moves.CPU_MOVE) {
                    score = calcMinMax(depth - 1, gameBoard, Moves.USER_MOVE, alpha, beta).bestScore;
                    if (score > alpha) {
                        alpha = score;
                        spot = moveSpot;
                    }
                } else if (playerMove == Moves.USER_MOVE) {
                    score = calcMinMax(depth - 1, gameBoard, Moves.CPU_MOVE, alpha, beta).bestScore;
                    if (score < beta) {
                        beta = score;
                        spot = moveSpot;
                    }
                }

                gameBoard[moveSpot] = Moves.NO_MOVE;
                if (alpha >= beta) break;
            }

            return new Best((playerMove == Moves.CPU_MOVE) ? alpha : beta, spot);
        }

    }

    /**
     * 現在石を置くことが可能なすべての手をリスト化する（NO_MOVEが存在しているGameBoardの場所）
     *
     * @param gameBoard ゲームの盤
     * @return NO_MOVEが存在するGameBoard上の場所の一覧を格納したList
     */
    List<Integer> makeCapableMOveList(Moves[] gameBoard) {

        List<Integer> capableMoveList = new ArrayList<>();
        IntStream.range(0, Board.gameBoardLength).forEach(i -> {
            if (gameBoard[i] == Moves.NO_MOVE) {
                capableMoveList.add(i);
            }
        });

        return capableMoveList;
    }


}