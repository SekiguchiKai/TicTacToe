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
        MOVES[] gameBoard = board.getGameBoard();
        this.callHelper(gameBoard, MOVES.USER_MOVE, normalGameLogic);
        this.callHelper(gameBoard, MOVES.CPU_MOVE, normalGameLogic);
        this.callHelper(gameBoard, MOVES.NO_MOVE, normalGameLogic);

        IntStream.range(0, 9).forEach(i -> gameBoard[i] = MOVES.NO_MOVE);

        gameBoard[0] = MOVES.CPU_MOVE;
        gameBoard[1] = MOVES.CPU_MOVE;
        gameBoard[2] = MOVES.USER_MOVE;
        gameBoard[3] = MOVES.USER_MOVE;
        gameBoard[4] = MOVES.USER_MOVE;
        gameBoard[5] = MOVES.CPU_MOVE;
        gameBoard[6] = MOVES.CPU_MOVE;
        gameBoard[7] = MOVES.USER_MOVE;
        gameBoard[8] = MOVES.CPU_MOVE;


        this.assertDraw(board.getGameBoard(), normalGameLogic);
    }

    /**
     * assertLinesとassertResultを実行するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @param moves     列挙型MOVESの要素
     */
    private void callHelper(MOVES[] gameBoard, MOVES moves, NormalGameLogic normalGameLogic) {
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
    private MOVES[] setGameBoard(MOVES[] gameBoard, int spot1, int spot2, int spot3, MOVES moves1, MOVES moves2, MOVES moves3) {
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
    private void assertResult(MOVES[] gameBoard, MOVES moves, NormalGameLogic normalGameLogic) {
        if (moves == MOVES.USER_MOVE) {
            assertThat(normalGameLogic.judgeResult(gameBoard), is(RESULT.WIN));
        } else if (moves == MOVES.CPU_MOVE) {
            assertThat(normalGameLogic.judgeResult(gameBoard), is(RESULT.LOSE));
        } else if (moves == MOVES.NO_MOVE) {
            assertThat(normalGameLogic.judgeResult(gameBoard), is(RESULT.PENDING));
        }

        IntStream.range(0, 9).forEach(i -> gameBoard[i] = MOVES.NO_MOVE);
    }

    /**
     * 引き分けが適切に決定されているかをテストするためのメソッド
     *
     * @param gameBoard       ゲーム盤
     * @param normalGameLogic ゲームのロジック
     */
    private void assertDraw(MOVES[] gameBoard, NormalGameLogic normalGameLogic) {
        assertThat(normalGameLogic.judgeResult(gameBoard), is(RESULT.DRAW));
    }


}