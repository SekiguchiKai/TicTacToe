import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * MinMaxLogicをテストするためのクラス
 * Created by sekiguchikai on 2016/12/23.
 */
public class MinMaxLogicTest {
    /**
     * calcMinMaxメソッドをテストするためのメソッド
     */
    @Test
    public void calcMinMax() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addMoves(0, 0, MOVES.CPU_MOVE);
        gameBoard.addMoves(0, 1, MOVES.USER_MOVE);
        gameBoard.addMoves(1, 1, MOVES.CPU_MOVE);
        gameBoard.addMoves(1, 0, MOVES.USER_MOVE);

        MinMaxLogic minMaxLogic = new MinMaxLogic();
        int[] nextOnes = minMaxLogic.calcMinMax(2, gameBoard.getGameBoard(), MOVES.CPU_MOVE);

        assertThat(nextOnes[1], is(2));
        assertThat(nextOnes[2], is(2));


    }

    /**
     * makeCapableMOveListメソッドをテストするためのメソッド
     */
    @Test
    public void makeCapableMOveList() {

    }

}