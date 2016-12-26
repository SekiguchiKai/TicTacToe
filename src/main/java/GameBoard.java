import java.util.stream.IntStream;

/**
 * ゲーム番を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class GameBoard {
    /**
     * 打ち手を格納するための配列
     */
    private MOVES[] gameBoard = new MOVES[9];

    /**
     * コンストラクタ
     * initStonesArrayメソッドを呼び出す
     */
    public GameBoard() {
        this.initStonesArray();
    }

    /**
     * stonesArrayを初期化するためのメソッド
     */
    public void initStonesArray() {
        IntStream.range(0, 9).forEach(i -> gameBoard[i] = MOVES.NO_MOVE);
    }

    /**
     * ゲーム盤に打ち手を打つためのメソッド
     *
     * @param spot  ゲーム盤の場所
     * @param MOVES 各プレーヤーの打ち手
     */
    public void addMoves(int spot, MOVES MOVES) {
        gameBoard[spot] = MOVES;
    }

    /**
     * ゲーム盤を取得するためのメソッド
     *
     * @return 打ち手を格納するための配列
     */
    public MOVES[] getGameBoard() {
        return this.gameBoard;
    }

    /**
     * gameBoardに格納されている打ち手を返す
     *
     * @param spot ゲーム盤の場所
     * @return Movesの定数
     */
    public MOVES getMoves(int spot) {
        return gameBoard[spot];
    }
}
