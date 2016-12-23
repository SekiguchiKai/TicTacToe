import java.util.*;

/**
 * CPUの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Cpu extends Player {

    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param gameBoard ゲーム盤
     */
    public Cpu(GameBoard gameBoard, MinMaxLogic minMaxLogic, Terminal terminal) {
        super(gameBoard, minMaxLogic, terminal);
    }


    /**
     * 打ち手を打つメソッド
     */
    public void doMove(int depth) {
        int row = super.minMaxLogic.calcMinMax(depth, gameBoard.getGameBoard(), MOVES.CPU_MOVE)[1];
        int column = super.minMaxLogic.calcMinMax(depth, gameBoard.getGameBoard(), MOVES.CPU_MOVE)[2];
        gameBoard.addMoves(row, column, MOVES.CPU_MOVE);

        terminal.drawBoard(gameBoard.getGameBoard());


    }
}
