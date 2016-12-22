import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic {


    // とりあえず user= ○, cpu= ×とする


//    /**
//     * ゲーム版
//     */
//    GameBoard gameBoard;
//
//    private Move USER_MOVE;
//    private Move CPU_MOVE;
//
//
//    /**
//     * コンストラクタ
//     * ゲーム盤を設定
//     *
//     * @param gameBoard ゲーム盤
//     * @param USER_MOVE  ユーザーの打ち手
//     * @param CPU_MOVE   cpuの打ち手
//     */
//    public NormalGameLogic(GameBoard gameBoard, Move USER_MOVE, Move CPU_MOVE) {
//        this.gameBoard = gameBoard;
//        this.USER_MOVE = USER_MOVE;
//        this.CPU_MOVE = CPU_MOVE;
//    }


//    /**
//     * プレーヤーの打ち手の順番を決定するメソッド
//     *
//     * @return 打ち手の順番を表す数字とそれに紐づけられた各々のプレーヤーを格納するためのMap
//     */
//    void decideOrder() {
//        int userOrder = (int) (Math.random() * 2 + 1);
//        if (userOrder == 1) {
//            USER_MOVE.setOrder(1);
//            CPU_MOVE.setOrder(2);
//            USER_MOVE.setStone(MOVES.CIRCLE);
//            CPU_MOVE.setStone(MOVES.CROSS);
//        } else {
//            USER_MOVE.setOrder(2);
//            CPU_MOVE.setOrder(1);
//            USER_MOVE.setStone(MOVES.CROSS);
//            CPU_MOVE.setStone(MOVES.CIRCLE);
//        }
//    }


}

