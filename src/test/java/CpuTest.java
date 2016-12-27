import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Cpuクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/27.
 */
public class CpuTest {
    private Board board = new Board();
    private MinMaxLogic minMaxLogic = new MinMaxLogic();
    private CommandLineIO commandLineIO = new CommandLineIO();
    private Cpu cpu = new Cpu(board, minMaxLogic, commandLineIO);

    /**
     * doMoveメソッドをテストするためのメソッド
     */
    @Test
    public void doMove() {
        // ユーザーが四隅においた際
        List<Integer> cornerList = Arrays.asList(0, 2, 6, 8);
        cornerList.forEach(i -> {
            board.addMoves(0, MOVES.USER_MOVE);
            this.assertDoMOve(2, 4, MOVES.CPU_MOVE);
        });

        this.initGameBoard(board);

        // 勝つ時の一手
        board.addMoves(0, MOVES.CPU_MOVE);
        board.addMoves(1, MOVES.CPU_MOVE);
        this.assertDoMOve(2, 2, MOVES.CPU_MOVE);

        this.initGameBoard(board);

        board.addMoves(0, MOVES.CPU_MOVE);
        board.addMoves(4, MOVES.CPU_MOVE);
        this.assertDoMOve(2, 8, MOVES.CPU_MOVE);

        this.initGameBoard(board);

        board.addMoves(1, MOVES.CPU_MOVE);
        board.addMoves(4, MOVES.CPU_MOVE);
        this.assertDoMOve(2, 7, MOVES.CPU_MOVE);


        this.initGameBoard(board);
        // 負けないための一手
        board.addMoves(0, MOVES.USER_MOVE);
        board.addMoves(1, MOVES.USER_MOVE);
        this.assertDoMOve(2, 2, MOVES.CPU_MOVE);

        this.initGameBoard(board);

        board.addMoves(0, MOVES.USER_MOVE);
        board.addMoves(4, MOVES.USER_MOVE);
        this.assertDoMOve(2, 8, MOVES.CPU_MOVE);

        this.initGameBoard(board);

        board.addMoves(1, MOVES.USER_MOVE);
        board.addMoves(4, MOVES.USER_MOVE);
        this.assertDoMOve(2, 7, MOVES.CPU_MOVE);

        this.initGameBoard(board);


    }

    /**
     * 引数で受け取ったBoarクラスのインスタンスを初期化するためのメソッド
     *
     * @param board
     */
    private void initGameBoard(Board board) {
        IntStream.range(0, 9).forEach(i -> board.addMoves(i, MOVES.NO_MOVE));
    }

    /**
     * doMoveメソッドが適切に実行されているかテストするためのメソッド
     *
     * @param depth    探索の深さ
     * @param spot     ゲーム版の場所
     * @param expected 期待する値
     */
    private void assertDoMOve(int depth, int spot, MOVES expected) {
        cpu.doMove(depth);
        assertThat(board.getGameBoard()[spot], is(expected));
    }

}