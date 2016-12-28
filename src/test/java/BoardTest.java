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
        MOVES[] gameBoard = board.getGameBoard();
        IntStream.range(0, 9).forEach(i -> assertThat(gameBoard[i], is(MOVES.NO_MOVE)));
    }

    /**
     * addMovesメソッドをテストするためのメソッド
     */
    @Test
    public void addMoves() {

        IntStream.range(0, 5).forEach(i -> board.addMoves(i, MOVES.CPU_MOVE));
        IntStream.range(5, 9).forEach(i -> board.addMoves(i, MOVES.USER_MOVE));

        MOVES[] gameBoard = board.getGameBoard();

        IntStream.range(0, 5).forEach(t -> assertThat(gameBoard[t], is(MOVES.CPU_MOVE)));
        IntStream.range(5, 9).forEach(t -> assertThat(gameBoard[t], is(MOVES.USER_MOVE)));

    }

    /**
     * getGameBoardメソッドをテストするためのメソッド
     */
    @Test
    public void getGameBoard() {
        this.helper(MOVES.USER_MOVE);
        this.helper(MOVES.CPU_MOVE);
    }

    /**
     * getGameBoardメソッドをテストするためのメソッドの補助メソッド
     *
     * @param moves 列挙型MOVESの要素
     */
    private void helper(MOVES moves) {
        MOVES[] gameBoard = board.getGameBoard();
        IntStream.range(0, 9).forEach(i -> board.addMoves(i, moves));
        IntStream.range(0, 9).forEach(t -> assertThat(gameBoard[t], is(moves)));
    }

}