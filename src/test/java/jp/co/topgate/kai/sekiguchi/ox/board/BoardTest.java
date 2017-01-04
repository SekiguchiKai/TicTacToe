package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.stream.IntStream;

/**
 * GameBoardクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class BoardTest {
    private Board board = new Board();


    /**
     * initGameBoardメソッドをテストするためのメソッド
     */
    @Test
    public void initGameBoard() {
        Moves[] gameBoard = board.getGameBoardState();
        IntStream.range(0, 9).forEach(i -> assertThat(gameBoard[i], is(Moves.NO_MOVE)));
    }

    /**
     * putMovesメソッドをテストするためのメソッド
     */
    @Test
    public void putMoves() {

        IntStream.range(0, 5).forEach(i -> board.putMoves(i, Moves.CPU_MOVE));
        IntStream.range(5, 9).forEach(i -> board.putMoves(i, Moves.USER_MOVE));

        Moves[] gameBoard = board.getGameBoardState();

        IntStream.range(0, 5).forEach(t -> assertThat(gameBoard[t], is(Moves.CPU_MOVE)));
        IntStream.range(5, 9).forEach(t -> assertThat(gameBoard[t], is(Moves.USER_MOVE)));

    }

    /**
     * getGameBoardStateメソッドをテストするためのメソッド
     */
    @Test
    public void getGameBoardState() {
        this.helper(Moves.USER_MOVE);
        this.helper(Moves.CPU_MOVE);
    }

    /**
     * getGameBoardStateメソッドをテストするためのメソッドの補助メソッド
     *
     * @param moves 列挙型MOVESの要素
     */
    private void helper(Moves moves) {
        IntStream.range(0, Board.gameBoardLength).forEach(i -> board.putMoves(i, moves));

        Moves[] gameBoard = board.getGameBoardState();

        IntStream.range(0, Board.gameBoardLength).forEach(t -> assertThat(gameBoard[t], is(moves)));
    }

}