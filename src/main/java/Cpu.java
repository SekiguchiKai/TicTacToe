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
        int spot = super.minMaxLogic.calcMinMax(depth, gameBoard.getGameBoard(), MOVES.CPU_MOVE, Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
        System.out.println("CPUの打ち手は、" + spot);
        gameBoard.addMoves(spot, MOVES.CPU_MOVE);

        terminal.drawBoard(gameBoard.getGameBoard());


    }
}
