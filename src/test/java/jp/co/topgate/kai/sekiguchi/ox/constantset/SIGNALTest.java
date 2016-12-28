package jp.co.topgate.kai.sekiguchi.ox.constantset;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 列挙型SIGNALをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class SIGNALTest {
    /**
     * getSignalメソッドをテストするためのメソッド
     */
    @Test
    public void getSignal() {
        this.helper(SIGNAL.CIRCLE, "○");
        this.helper(SIGNAL.CROSS, "×");
        this.helper(SIGNAL.EMPTY, " ");
    }

    /**
     * getSignalメソッドをテストするためのメソッドの補助メソッド
     */
    private void helper(SIGNAL data, String expected) {
        assertThat(data.getSignal(), is(expected));
    }

}