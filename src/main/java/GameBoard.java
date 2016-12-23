import java.util.stream.IntStream;

/**
 * ゲーム番を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class GameBoard {
    /**
     * 打ち手を格納するための配列
     */
    private MOVES[][] gameBoard = new MOVES[3][3];

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
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> gameBoard[i][j] = MOVES.EMPTY));
    }

    /**
     * ゲーム盤に打ち手を打つためのメソッド
     *
     * @param y      ゲーム盤のy座標
     * @param x      ゲーム盤のx座標
     * @param MOVES 各プレーヤーの打ち手
     */
    public void addMoves(int y, int x, MOVES MOVES) {
        gameBoard[y][x] = MOVES;
    }

    /**
     * ゲーム盤を取得するためのメソッド
     *
     * @return 打ち手を格納するための配列
     */
    public MOVES[][] getGameBoard() {
        return this.gameBoard;
    }

    /**
     * gameBoardに格納されている打ち手を返す
     *
     * @param y ゲーム盤のy座標
     * @param x ゲーム盤のx座標
     * @return Movesの定数
     */
    public MOVES getMoves(int y, int x) {
        return gameBoard[y][x];
    }
}
