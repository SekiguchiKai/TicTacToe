package jp.co.topgate.kai.sekiguchi.ox;

import java.util.HashMap;
import java.util.Map;

/**
 * ノーマルモードのゲームのロジックを表すクラス
 * Created by sekiguchikai on 2016/12/19.
 */
public class NormalGameLogic {

//
//    public void processPlay(int[] boardArray) {
//        if (!judgeResult(boardArray).equals("勝負は未定")) {
//            // Template系クラスでの書きこみの指示
//        } else {
//            // Template系クラスでの書きこみの指示（普通の）
//        }
//    }

    /**
     * 打ち手の順番を決定するためのメソッド
     */
    void decideOrder(Move userMove, Move cpuMove) {
        Map<Integer, Move> orders = new HashMap<Integer, Move>();
        int userOrder = (int) (Math.random() * 2) + 1;
        int cpuOrder;

        if (userOrder == 1) {
            userMove.setOrder(1);
            cpuMove.setOrder(2);
        } else {
            userMove.setOrder(2);
            cpuMove.setOrder(1);
        }

    }


    /**
     * 勝敗を決定するメソッド
     *
     * @return 勝敗（勝敗がついていない場合は、「勝負は未定」）
     */
    String judgeResult(int[] boardArray) {

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
}
