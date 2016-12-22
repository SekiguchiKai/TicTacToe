import java.util.*;
import java.util.stream.IntStream;

/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class Simulator {

    private int bestScore;
    private Integer[] bestScoreSpot;

    Simulator(MOVES[][] gameBoard, int[] moveSpot, MOVES moves) {
        simulate(gameBoard, moveSpot, moves);
    }





    /**
     * 打つことが可能（EMPTY）な全ての場所に対して石を置き、その打ち手を行った場合の点数を計算する
     * MOVESが、CPUの場合は、その点数の中で一番点数が高いものを返す
     * MOVESが、USERの場合は、その点数の中で一番点数が低いものを返す
     *
     * @param gameBoard ゲーム盤
     * @param moveSpot  石を置くことが場所
     * @param moves     MOVE
     * @return 指定されたMOVEに対するベストスコアとそれを実現するために置くべきゲーム盤の場所を返す
     */
    void simulate(MOVES[][] gameBoard, int[] moveSpot, MOVES moves) throws NoSuchElementException {

        List<Integer> scoreList = new ArrayList<>();
        /* 点数と空白の場所 */
        Map<Integer, Integer[]> scoreMap = new HashMap<>();
        scoreMap.put(this.calcScore(gameBoard), new Integer[]{moveSpot[0], moveSpot[1]});


        Optional<Integer> bestScore = scoreMap.keySet().stream().max(Comparator.naturalOrder());

        if (bestScore.isPresent()) {
            this.bestScore = bestScore.get();
            this.bestScoreSpot = scoreMap.get(bestScore.get());
        } else {
            throw new NoSuchElementException();
        }

    }

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
            if (moves == MOVES.CPUMOVE) {
                lineScoreList.add(1);
            } else if (moves == MOVES.USERMOVE) {
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

    /**
     * ベストスコアを返すメソッド
     *
     * @return ベストスコア
     */
    public int getBestScore() {
        return this.bestScore;
    }

    /**
     * ベストスコアの場所を返すメソッド
     *
     * @return ベストスコアの場所
     */
    public Integer[] getBestScoreSpot() {
        return this.bestScoreSpot;
    }

}
