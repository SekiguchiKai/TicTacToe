package jp.co.topgate.kai.sekiguchi.ox.player;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.MOVES;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;

/**
 * CPUの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Cpu extends Player {

    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param board ゲーム盤
     */
    public Cpu(Board board, MinMaxCalculator minMaxCalculator, CommandLineIO commandLineIO) {
        super(board, minMaxCalculator, commandLineIO);
    }


    /**
     * 打ち手を打つメソッド
     * @param depth 深さ
     */
    @Override
    public void doMove(int depth) {
        int spot = super.minMaxCalculator.calcMinMax(depth, board.getGameBoard(), MOVES.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
        System.out.println("CPUの打ち手は、" + spot);
        board.addMoves(spot, MOVES.CPU_MOVE);

        commandLineIO.drawBoard(board.getGameBoard());
    }
}
