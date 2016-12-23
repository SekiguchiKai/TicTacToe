
import java.util.HashMap;

import java.util.Map;


/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic implements GameLogic {


    // とりあえず user= ○, cpu= ×


    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    public void playGame() {
        Simulator simulator = new Simulator();
        GameBoard gameBoard = new GameBoard();
        Terminal terminal = new Terminal();
        MinMaxLogic minMaxLogic = new MinMaxLogic();
        Player user = new User(gameBoard, minMaxLogic, terminal);
        Player cpu = new Cpu(gameBoard, minMaxLogic, terminal);

        Player firstPlayer = this.decideOrder(user, cpu).get(1);
        Player secondPlayer = this.decideOrder(user, cpu).get(2);

        terminal.drawBoard(gameBoard.getGameBoard());

        int depthCount = 0;

        while (this.judgeResult(gameBoard.getGameBoard(), simulator) == RESULT.PENDING) {

            firstPlayer.doMove(depthCount);
            depthCount++;

            secondPlayer.doMove(depthCount);
            depthCount++;

        }

        // ここターミナルにすること
        System.out.println(this.judgeResult(gameBoard.getGameBoard(), simulator));


    }


    Map<Integer, Player> decideOrder(Player user, Player cpu) {
        int userOrder = (int) (Math.random() * 2 + 1);
        Map<Integer, Player> orderMap = new HashMap<>();
        if (userOrder == 1) {
            orderMap.put(1, user);
            orderMap.put(2, cpu);
        } else {
            orderMap.put(1, cpu);
            orderMap.put(2, user);
        }

        return orderMap;

    }

    /**
     * 勝敗結果を返すためのメソッド
     *
     * @param gameBoard gameBoardのインスタンス
     * @param simulator simulatorのインスタンス
     * @return 勝敗の結果
     */
    RESULT judgeResult(MOVES[][] gameBoard, Simulator simulator) {
        int score = simulator.calcScore(gameBoard);
        return this.createResult(score);
    }

    /**
     * スコアの点数から勝敗結果を導き出すメソッド
     *
     * @param score 現在のゲーム盤の点数
     * @return 勝敗結果
     */
    RESULT createResult(int score) {
        Map<Integer, RESULT> resultScoreMap = new HashMap<>();
        resultScoreMap.put(100, RESULT.WIN);
        resultScoreMap.put(-100, RESULT.LOSE);
        resultScoreMap.put(50, RESULT.DRAW);
        resultScoreMap.put(0, RESULT.DRAW);

        return resultScoreMap.get(score);
    }


}

