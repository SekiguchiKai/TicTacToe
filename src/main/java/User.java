import java.io.IOException;

/**
 * ユーザーの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class User extends Player {

    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param gameBoard ゲーム盤
     */
    public User(GameBoard gameBoard, MinMaxLogic minMaxLogic, Terminal terminal) {
        super(gameBoard, minMaxLogic, terminal);
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    public void doMove(int depth) {
        try {
            gameBoard.addMoves(terminal.receiveCommand(gameBoard.getGameBoard()), MOVES.USER_MOVE);
        } catch (IOException e) {
            System.err.println("エラー:" + e.getMessage());
            e.printStackTrace();
        }
        terminal.drawBoard(gameBoard.getGameBoard());

    }
}
