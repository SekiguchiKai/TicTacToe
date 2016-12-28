package jp.co.topgate.kai.sekiguchi.ox.constantset;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 列挙型RESULTをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class RESULTTest {
    /**
     * getResultメソッドをテストするためのメソッド
     */
    @Test
    public void getResult() {
        this.helper(RESULT.WIN, "君の勝ちだ");
        this.helper(RESULT.LOSE, "君の負けだ");
        this.helper(RESULT.DRAW, "引き分けだ");

    }

    /**
     * getResultメソッドをテストするためのメソッドの補助メソッド
     *
     * @param data     テストで使用するデータ
     * @param expected 期待する値
     */
    private void helper(RESULT data, String expected) {
        assertThat(data.getResult(), is(expected));

    }

}