import java.util.HashMap;
import java.util.Map;

/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic {

    /**
     * ゲーム版
     */
    PlayBoard playBoard;

    private Move userMove;
    private Move cpuMove;


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

