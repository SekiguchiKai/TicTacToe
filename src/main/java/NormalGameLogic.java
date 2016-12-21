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


    /**
     * ゲーム版
     */
    PlayBoard playBoard;

    private Move userMove;
    private Move cpuMove;


    /**
     * コンストラクタ
     * ゲーム盤を設定
     *
     * @param playBoard ゲーム盤
     * @param userMove  ユーザーの打ち手
     * @param cpuMove   cpuの打ち手
     */
    public NormalGameLogic(PlayBoard playBoard, Move userMove, Move cpuMove) {
        this.playBoard = playBoard;
        this.userMove = userMove;
        this.cpuMove = cpuMove;
    }


//    /**
//     * プレーヤーの打ち手の順番を決定するメソッド
//     *
//     * @return 打ち手の順番を表す数字とそれに紐づけられた各々のプレーヤーを格納するためのMap
//     */
//    void decideOrder() {
//        int userOrder = (int) (Math.random() * 2 + 1);
//        if (userOrder == 1) {
//            userMove.setOrder(1);
//            cpuMove.setOrder(2);
//            userMove.setStone(MOVES.CIRCLE);
//            cpuMove.setStone(MOVES.CROSS);
//        } else {
//            userMove.setOrder(2);
//            cpuMove.setOrder(1);
//            userMove.setStone(MOVES.CROSS);
//            cpuMove.setStone(MOVES.CIRCLE);
//        }
//    }


}

