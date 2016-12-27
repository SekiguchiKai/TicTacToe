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
    public User(Board board, MinMaxLogic minMaxLogic, CommandLineIO commandLineIO) {
        super(board, minMaxLogic, commandLineIO);
    }

    /**
     * 打ち手を打つメソッド
     *
     * @param depth 深さ
     */
    public void doMove(int depth) {
        try {
            int userInput = commandLineIO.receiveCommand(board.getGameBoard());

            while (userInput == Integer.MAX_VALUE || userInput == Integer.MIN_VALUE) {
                userInput = commandLineIO.receiveCommand(board.getGameBoard());

                if (userInput == Integer.MAX_VALUE) {
                    commandLineIO.drawExistingCaution();
                } else if (userInput == Integer.MIN_VALUE) {
                    commandLineIO.drawInappropriateCaution();
                } else {
                    board.addMoves(userInput, MOVES.USER_MOVE);
                }
            }

        } catch (IOException e) {
            System.err.println("エラー:" + e.getMessage());
            e.printStackTrace();
        }
        commandLineIO.drawBoard(board.getGameBoard());

    }
}
