import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic {


    // とりあえず user= ○, cpu= ×



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

    }


    /**
     * 勝敗を判断するためのメソッド
     * 勝敗によって返す点数が異なる
     * <p>
     * CPUが勝利した場合 : 100
     * USERが勝利した場合 : -100
     * 引き分けの場合 : 50
     * 未決の場合 : 0
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    int judgeResult(MOVES[][] gameBoard) {


        // 縦

        if ((gameBoard[0][0] == MOVES.USER_MOVE && gameBoard[1][0] == MOVES.USER_MOVE && gameBoard[2][0] == MOVES.USER_MOVE) ||
                (gameBoard[0][1] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[2][1] == MOVES.USER_MOVE) ||
                (gameBoard[0][2] == MOVES.USER_MOVE && gameBoard[1][2] == MOVES.USER_MOVE && gameBoard[2][2] == MOVES.USER_MOVE)) {
            return -100;
        } else if ((
                gameBoard[0][0] == MOVES.CPU_MOVE && gameBoard[1][0] == MOVES.CPU_MOVE && gameBoard[2][0] == MOVES.CPU_MOVE) ||
                (gameBoard[0][1] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[2][1] == MOVES.CPU_MOVE) ||
                (gameBoard[0][2] == MOVES.CPU_MOVE && gameBoard[1][2] == MOVES.CPU_MOVE && gameBoard[2][2] == MOVES.CPU_MOVE)) {
            return 100;
        }


        // 横

        if ((gameBoard[0][0] == MOVES.USER_MOVE && gameBoard[0][1] == MOVES.USER_MOVE && gameBoard[0][2] == MOVES.USER_MOVE) ||
                (gameBoard[1][0] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[1][2] == MOVES.USER_MOVE) ||
                (gameBoard[2][0] == MOVES.USER_MOVE && gameBoard[2][1] == MOVES.USER_MOVE && gameBoard[2][2] == MOVES.USER_MOVE)) {
            return -100;
        } else if ((gameBoard[0][0] == MOVES.CPU_MOVE && gameBoard[0][1] == MOVES.CPU_MOVE && gameBoard[0][2] == MOVES.CPU_MOVE) ||
                (gameBoard[1][0] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[1][2] == MOVES.CPU_MOVE) ||
                (gameBoard[2][0] == MOVES.CPU_MOVE && gameBoard[2][1] == MOVES.CPU_MOVE && gameBoard[2][2] == MOVES.CPU_MOVE)) {
            return 100;
        }


        // 斜め
        if ((gameBoard[0][0] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[2][2] == MOVES.USER_MOVE) ||
                (gameBoard[0][2] == MOVES.USER_MOVE && gameBoard[1][1] == MOVES.USER_MOVE && gameBoard[2][0] == MOVES.USER_MOVE)) {
            return -100;
        } else if ((gameBoard[0][0] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[2][2] == MOVES.CPU_MOVE) ||
                (gameBoard[0][2] == MOVES.CPU_MOVE && gameBoard[1][1] == MOVES.CPU_MOVE && gameBoard[2][0] == MOVES.CPU_MOVE)) {
            return 100;
        }


        // 全部埋まった
        List<MOVES> checkList = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> checkList.add(gameBoard[i][j])));

        if (!checkList.contains(MOVES.EMPTY)) {
            return 50;
        }

        return 0;
    }

}

