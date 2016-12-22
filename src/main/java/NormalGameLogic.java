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


<<<<<<< HEAD
    /**
     * コンストラクタゲーム盤を設定
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

    /**
     * ゲームを進行していくロジックを担当するメソッド
     *
     * @return 勝敗結果
     */
    public String playGame() {
        return "";
    }

    /**
     * プレーヤーの打ち手の順番を決定するメソッド
     *
     * @return 打ち手の順番を表す数字とそれに紐づけられた各々のプレーヤーを格納するためのMap
     */
    void decideOrder() {
        int userOrder = (int) (Math.random() * 2 + 1);
        if (userOrder == 1) {
            userMove.setOrder(1);
            cpuMove.setOrder(2);
            userMove.setStone(Stones.CIRCLE);
            cpuMove.setStone(Stones.CROSS);
        } else {
            userMove.setOrder(2);
            cpuMove.setOrder(1);
            userMove.setStone(Stones.CROSS);
            cpuMove.setStone(Stones.CIRCLE);
        }
    }


    /**
     * 勝敗を決定するメソッド
     *
     * @return 勝敗（勝敗がついていない場合は、「勝負は未定」）
     */
    String judgeResult() {

        final int CIRCLE = 1;
        final int CROSS = 2;

        // 縦
        for (int i = 0; i < 3; i = i++) {
            if (boardArray[i] == CIRCLE && boardArray[i + 3] == CIRCLE && boardArray[i + 6] == CIRCLE) {
                return "君の勝ちだ";
            } else if (boardArray[i] == CROSS && boardArray[i + 3] == CROSS && boardArray[i + 6] == CROSS) {
                return "君の負けだ";
            }
        }

        // 横
        for (int i = 1; i < 3; i = i + 3) {
            if (boardArray[i] == CIRCLE && boardArray[i + 1] == CIRCLE && boardArray[i + 2] == CIRCLE) {
                return "君の勝ちだ";
            } else if (boardArray[i] == CROSS && boardArray[i + 1] == CROSS && boardArray[i + 2] == CROSS) {
                return "君の負けだ";
            }
        }

        // 斜め
        if (boardArray[0] == CIRCLE && boardArray[4] == CIRCLE && boardArray[8] == CIRCLE) {
            return "君の勝ちだ";
        } else if (boardArray[0] == CROSS && boardArray[4] == CROSS && boardArray[8] == CROSS) {
            return "君の負けだ";
        } else if (boardArray[2] == CIRCLE && boardArray[4] == CIRCLE && boardArray[6] == CIRCLE) {
            return "君の勝ちだ";
        } else if (boardArray[2] == CROSS && boardArray[4] == CROSS && boardArray[6] == CROSS) {
            return "君の負けだ";
        }

        // 全部埋まった
        for (int idx : boardArray) {
            if (idx != 0) {
                return "引き分けです";
            }
        }

        return "勝負は未定";

    }
=======
>>>>>>> 027c6f51ab883c8f58af1937c7e400b39bd444b5
}

