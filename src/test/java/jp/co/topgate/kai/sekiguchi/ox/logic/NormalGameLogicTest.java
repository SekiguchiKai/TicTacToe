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
        Moves[] gameBoard = board.getGameBoardState();
        this.callHelper(gameBoard, Moves.USER_MOVE, normalGameLogic);
        this.callHelper(gameBoard, Moves.CPU_MOVE, normalGameLogic);
        this.callHelper(gameBoard, Moves.NO_MOVE, normalGameLogic);

        IntStream.range(0, 9).forEach(i -> gameBoard[i] = Moves.NO_MOVE);

        gameBoard[0] = Moves.CPU_MOVE;
        gameBoard[1] = Moves.CPU_MOVE;
        gameBoard[2] = Moves.USER_MOVE;
        gameBoard[3] = Moves.USER_MOVE;
        gameBoard[4] = Moves.USER_MOVE;
        gameBoard[5] = Moves.CPU_MOVE;
        gameBoard[6] = Moves.CPU_MOVE;
        gameBoard[7] = Moves.USER_MOVE;
        gameBoard[8] = Moves.CPU_MOVE;


        this.assertDraw(board.getGameBoardState(), normalGameLogic);
    }

    /**
     * assertLinesとassertResultを実行するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     列挙型MOVESの要素
     */
    private void callHelper(Moves[] gameBoard, Moves moves, NormalGameLogic normalGameLogic) {
        setGameBoard(gameBoard, 0, 1, 2, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);

        setGameBoard(gameBoard, 3, 4, 5, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);

        setGameBoard(gameBoard, 6, 7, 8, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);

        setGameBoard(gameBoard, 0, 3, 6, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);

        setGameBoard(gameBoard, 2, 5, 8, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);

        setGameBoard(gameBoard, 0, 4, 8, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);

        setGameBoard(gameBoard, 2, 4, 6, moves, moves, moves);
        assertResult(gameBoard, moves, normalGameLogic);
    }

    /**
     * ゲーム盤をセットするためメソッド
     *
     * @param gameBoard ゲーム盤
     * @param spot1     ゲーム盤の場所
     * @param spot2     ゲーム盤の場所
     * @param spot3     ゲーム盤の場所
     * @param moves1    列挙型MOVESの要素
     * @param moves2    列挙型MOVESの要素
     * @param moves3    列挙型MOVESの要素
     * @return セット後のゲーム盤
     */
    private Moves[] setGameBoard(Moves[] gameBoard, int spot1, int spot2, int spot3, Moves moves1, Moves moves2, Moves moves3) {
        gameBoard[spot1] = moves1;
        gameBoard[spot2] = moves2;
        gameBoard[spot3] = moves3;

        return gameBoard;
    }


    /**
     * 勝ち、負け、未決が適切に決定されているかをテストするためのメソッド
     *
     * @param gameBoard       ゲーム盤
     * @param moves           列挙型MOVESの要素
     * @param normalGameLogic ゲームのロジック
     */
    private void assertResult(Moves[] gameBoard, Moves moves, NormalGameLogic normalGameLogic) {
        if (moves == Moves.USER_MOVE) {
            assertThat(normalGameLogic.judgeResult(gameBoard), is(Result.WIN));
        } else if (moves == Moves.CPU_MOVE) {
            assertThat(normalGameLogic.judgeResult(gameBoard), is(Result.LOSE));
        } else if (moves == Moves.NO_MOVE) {
            assertThat(normalGameLogic.judgeResult(gameBoard), is(Result.PENDING));
        }

        IntStream.range(0, 9).forEach(i -> gameBoard[i] = Moves.NO_MOVE);
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