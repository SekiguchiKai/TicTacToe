package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.MOVES;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * ScoreCalculatorクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class ScoreCalculatorTest {
    private ScoreCalculator scoreCalculator = new ScoreCalculator();


    /**
     * calcScoreメソッドをテストするためのメソッド
     */
    @Test
    public void calcScore() {
        this.helper(MOVES.CPU_MOVE, MOVES.CPU_MOVE, MOVES.CPU_MOVE, 1000);
        this.helper(MOVES.USER_MOVE, MOVES.USER_MOVE, MOVES.USER_MOVE, -1000);
        this.helper(MOVES.NO_MOVE, MOVES.NO_MOVE, MOVES.NO_MOVE, 0);
        this.helper(MOVES.USER_MOVE, MOVES.CPU_MOVE, MOVES.CPU_MOVE, 0);
        this.helper(MOVES.USER_MOVE, MOVES.USER_MOVE, MOVES.CPU_MOVE, 0);
        this.helper(MOVES.NO_MOVE, MOVES.USER_MOVE, MOVES.CPU_MOVE, 0);
        this.helper(MOVES.NO_MOVE, MOVES.USER_MOVE, MOVES.USER_MOVE, -100);
        this.helper(MOVES.NO_MOVE, MOVES.CPU_MOVE, MOVES.CPU_MOVE, 100);

    }


    /**
     * calcLineScoreメソッドをテストするためのメソッド
     */
    @Test
    public void calcLineScore() {
        this.helper(MOVES.CPU_MOVE, MOVES.CPU_MOVE, MOVES.CPU_MOVE, 1000);
        this.helper(MOVES.USER_MOVE, MOVES.USER_MOVE, MOVES.USER_MOVE, -1000);
        this.helper(MOVES.NO_MOVE, MOVES.NO_MOVE, MOVES.NO_MOVE, 0);
        this.helper(MOVES.USER_MOVE, MOVES.CPU_MOVE, MOVES.CPU_MOVE, 0);
        this.helper(MOVES.USER_MOVE, MOVES.USER_MOVE, MOVES.CPU_MOVE, 0);
        this.helper(MOVES.NO_MOVE, MOVES.USER_MOVE, MOVES.CPU_MOVE, 0);
        this.helper(MOVES.NO_MOVE, MOVES.USER_MOVE, MOVES.USER_MOVE, -100);
        this.helper(MOVES.NO_MOVE, MOVES.CPU_MOVE, MOVES.CPU_MOVE, 100);

    }

    /**
     * calcScoreメソッドをテストするためのメソッドとcalcLineScoreメソッドをテストするためのメソッドを補助するためのメソッド
     *
     * @param data1    テストで使用するMOVES型のデータ
     * @param data2    テストで使用するMOVES型のデータ
     * @param data3    テストで使用するMOVES型のデータ
     * @param expected 期待する値
     */
    private void helper(MOVES data1, MOVES data2, MOVES data3, int expected) {
        assertThat(scoreCalculator.calcLineScore(data1, data2, data3), is(expected));
    }

}