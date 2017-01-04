package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * MinMaxLogicクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class MinMaxCalculatorTest {

    private MinMaxCalculator minMaxCalculator = new MinMaxCalculator();
    private Board board = new Board();

    /**
     * calcMinMaxメソッドをテストするためのメソッド
     */
    @Test
    public void calcMinMax() {

        // ユーザーが四隅においた際
        List<Integer> cornerList = Arrays.asList(0, 2, 6, 8);
        cornerList.forEach(i ->

        {
            this.board.putMoves(0, Moves.USER_MOVE);
            this.assertMinMaxLogic(4);
        });

        this.initGameBoard();

        // 勝つ時の一手
        this.board.putMoves(0, Moves.CPU_MOVE);
        this.board.putMoves(1, Moves.CPU_MOVE);
        this.assertMinMaxLogic(2);

        this.initGameBoard();

        this.board.putMoves(0, Moves.CPU_MOVE);
        this.board.putMoves(4, Moves.CPU_MOVE);
        this.assertMinMaxLogic(8);


        this.initGameBoard();

        this.board.putMoves(1, Moves.CPU_MOVE);
        this.board.putMoves(4, Moves.CPU_MOVE);
        this.assertMinMaxLogic(7);


        this.initGameBoard();
        // 負けないための一手
        this.board.putMoves(0, Moves.USER_MOVE);
        this.board.putMoves(1, Moves.USER_MOVE);
        this.assertMinMaxLogic(2);

        this.initGameBoard();

        this.board.putMoves(0, Moves.USER_MOVE);
        this.board.putMoves(4, Moves.USER_MOVE);
        this.assertMinMaxLogic(8);

        this.initGameBoard();

        this.board.putMoves(1, Moves.USER_MOVE);
        this.board.putMoves(4, Moves.USER_MOVE);
        this.assertMinMaxLogic(7);

        this.initGameBoard();

    }

    /**
     * Boardクラスのインスタンスを初期化するためのメソッド
     */
    private void initGameBoard() {

        IntStream.range(0, 9).forEach(i -> this.board.putMoves(i, Moves.NO_MOVE));
    }

    /**
     * doMoveメソッドが適切に実行されているかテストするためのメソッド
     */
    private void assertMinMaxLogic(int expectedSpot) {
        MinMaxCalculator.Best calcResult = this.minMaxCalculator.calcMinMax(2, this.board.getGameBoardState(), Moves.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertThat(calcResult.getBestSpot(), is(expectedSpot));

    }

    /**
     * makeCapableMOveListメソッドをテストするためのメソッド
     */
    @Test
    public void makeCapableMoveList() {

        IntStream.range(0, 9).forEach(i -> board.putMoves(i, Moves.CPU_MOVE));
        assertThat(this.minMaxCalculator.makeCapableMOveList(board.getGameBoardState()).size(), is(0));

        int[] numArray = new int[9];
        int listTotal = 0;
        int arrayTotal = 0;

        IntStream.range(0, 9).forEach(i -> numArray[i] = i);
        for (int i = 0; i < numArray.length; i++) {
            board.putMoves(i, Moves.CPU_MOVE);
            List<Integer> A = this.minMaxCalculator.makeCapableMOveList(board.getGameBoardState());
            for (int j = 0; j < A.size(); j++) {
                listTotal += A.get(j);
                arrayTotal += numArray[j];
            }
            assertThat(listTotal, is(arrayTotal));

        }


    }
}