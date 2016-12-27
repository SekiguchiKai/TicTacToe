
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
    public Cpu(Board board, MinMaxLogic minMaxLogic, CommandLineIO commandLineIO) {
        super(board, minMaxLogic, commandLineIO);
    }


    /**
     * 打ち手を打つメソッド
     */
    public void doMove(int depth) {
        int spot = super.minMaxLogic.calcMinMax(depth, board.getGameBoard(), MOVES.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
        System.out.println("CPUの打ち手は、" + spot);
        board.addMoves(spot, MOVES.CPU_MOVE);

        commandLineIO.drawBoard(board.getGameBoard());
    }
}
