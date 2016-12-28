package jp.co.topgate.kai.sekiguchi.ox.io;

import jp.co.topgate.kai.sekiguchi.ox.constantset.MOVES;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * CommandLineIOクラスをテストするためのメソッド
 * Created by sekiguchikai on 2016/12/27.
 */
public class CommandLineIOTest {
    CommandLineIO commandLineIO = new CommandLineIO();

    /**
     * changeMovesToSignalメソッドをテストするためのメソッド
     */
    @Test
    public void changeMovesToSignal() {
        this.changeMovesToSignalHelper(MOVES.USER_MOVE, 1, "○");
        this.changeMovesToSignalHelper(MOVES.CPU_MOVE, 2, "×");
        this.changeMovesToSignalHelper(MOVES.NO_MOVE, 3, "3");

    }

    /**
     * changeMovesToSignalメソッドをテストするためのメソッドの補助メソッド
     */
    private void changeMovesToSignalHelper(MOVES data1, int data2, String expected) {
        assertThat(commandLineIO.changeMovesToSignal(data1, data2), is(expected));
    }


}