package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * NormalGameLogicクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class NormalGameLogicTest {


    /**
     * judgeResultメソッドをテストするためのメソッド
     */
    @Test
    public void judgeResult() {
        NormalGameLogic normalGameLogic = new NormalGameLogic();
        Board board = new Board();
        this.callHelper(board, Moves.USER_MOVE, normalGameLogic);
        this.callHelper(board, Moves.CPU_MOVE, normalGameLogic);
        this.callHelper(board, Moves.NO_MOVE, normalGameLogic);

        IntStream.range(0, Board.gameBoardLength).forEach(i -> board.putMoves(i, Moves.NO_MOVE));

        board.putMoves(0, Moves.CPU_MOVE);
        board.putMoves(1, Moves.CPU_MOVE);
        board.putMoves(2, Moves.USER_MOVE);
        board.putMoves(3, Moves.USER_MOVE);
        board.putMoves(4, Moves.USER_MOVE);
        board.putMoves(5, Moves.CPU_MOVE);
        board.putMoves(6, Moves.CPU_MOVE);
        board.putMoves(7, Moves.USER_MOVE);
        board.putMoves(8, Moves.CPU_MOVE);


        this.assertDraw(board.getGameBoardState(), normalGameLogic);
    }

    /**
     * assertLinesとassertResultを実行するためのメソッド
     *
     * @param board Boardクラスのインスタンス
     * @param moves 列挙型MOVESの要素
     */
    private void callHelper(Board board, Moves moves, NormalGameLogic normalGameLogic) {
        setGameBoard(board, 0, 1, 2, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);

        setGameBoard(board, 3, 4, 5, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);

        setGameBoard(board, 6, 7, 8, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);

        setGameBoard(board, 0, 3, 6, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);

        setGameBoard(board, 2, 5, 8, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);

        setGameBoard(board, 0, 4, 8, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);

        setGameBoard(board, 2, 4, 6, moves, moves, moves);
        assertResult(board, moves, normalGameLogic);
    }

    /**
     * ゲーム盤をセットするためメソッド
     *
     * @param board  Boardクラスのインスタンス
     * @param spot1  ゲーム盤の場所
     * @param spot2  ゲーム盤の場所
     * @param spot3  ゲーム盤の場所
     * @param moves1 列挙型MOVESの要素
     * @param moves2 列挙型MOVESの要素
     * @param moves3 列挙型MOVESの要素
     */
    private void setGameBoard(Board board, int spot1, int spot2, int spot3, Moves moves1, Moves moves2, Moves moves3) {
        board.putMoves(spot1, moves1);
        board.putMoves(spot2, moves2);
        board.putMoves(spot3, moves3);

    }


    /**
     * 勝ち、負け、未決が適切に決定されているかをテストするためのメソッド
     *
     * @param board           Boardクラスのインスタンス
     * @param moves           列挙型MOVESの要素
     * @param normalGameLogic ゲームのロジック
     */
    private void assertResult(Board board, Moves moves, NormalGameLogic normalGameLogic) {
        if (moves == Moves.USER_MOVE) {
            assertThat(normalGameLogic.judgeResult(board.getGameBoardState()), is(Result.WIN));
        } else if (moves == Moves.CPU_MOVE) {
            assertThat(normalGameLogic.judgeResult(board.getGameBoardState()), is(Result.LOSE));
        } else if (moves == Moves.NO_MOVE) {
            assertThat(normalGameLogic.judgeResult(board.getGameBoardState()), is(Result.PENDING));
        }

        IntStream.range(0, Board.gameBoardLength).forEach(i -> board.putMoves(i, Moves.NO_MOVE));
    }

    /**
     * 引き分けが適切に決定されているかをテストするためのメソッド
     *
     * @param gameBoard       ゲーム盤
     * @param normalGameLogic ゲームのロジック
     */
    private void assertDraw(Moves[] gameBoard, NormalGameLogic normalGameLogic) {
        assertThat(normalGameLogic.judgeResult(gameBoard), is(Result.DRAW));
    }


}