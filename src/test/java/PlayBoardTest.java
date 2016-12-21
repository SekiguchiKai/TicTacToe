
import org.junit.Test;


import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * クラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class PlayBoardTest {

    /**
     * addMoveメソッドをテストするためのメソッド
     */
    @Test
    public void addMove() {
        PlayBoard playBoard = new PlayBoard();

        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> playBoard.addMoves(i, j, MOVES.USERMOVE)));
        MOVES[][] MOVESArray = playBoard.getMOVESArray();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> assertThat(MOVESArray[i][j], is(MOVES.USERMOVE))));

        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> playBoard.addMoves(i, j, MOVES.CPUMOVE)));
        MOVES[][] MOVESArray2 = playBoard.getMOVESArray();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> assertThat(MOVESArray2[i][j], is(MOVES.CPUMOVE))));

    }

    /**
     * getMoveArrayメソッドをテストするためのメソッド
     */
    @Test
    public void getMoveArray() {
        PlayBoard playBoard = new PlayBoard();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> assertThat(playBoard.getMoves(i, j), is(MOVES.EMPTY))));
    }

}