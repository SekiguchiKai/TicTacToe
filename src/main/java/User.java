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
     * @param board ゲーム盤
     */
    public User(Board board, MinMaxLogic minMaxLogic, Terminal terminal) {
        super(board, minMaxLogic, terminal);
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    public void doMove(int depth) {
        try {
            board.addMoves(terminal.receiveCommand(board.getGameBoard()), MOVES.USER_MOVE);
        } catch (IOException e) {
            System.err.println("エラー:" + e.getMessage());
            e.printStackTrace();
        }
        terminal.drawBoard(board.getGameBoard());

    }
}
