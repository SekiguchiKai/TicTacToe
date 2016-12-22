/**
 * 各プレーヤーの打ち手を表す抽象クラス
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class Player {

    /**
     * ゲーム盤
     */
    GameBoard gameBoard;
    /**
     * プレーヤーの打ち手の順番
     */
    int order;

    /**
     * プレーヤーの打ち手の石
     */
    MOVES stone;

    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param gameBoard ゲーム盤
     */
    public Player(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * @param point ゲーム盤の場所
     * @param MOVES プレーヤーの打ち手
     */
    public void doMove(int point, MOVES MOVES) {
    }

    /**
     * プレーヤーの打ち手の順番を設定するためのメソッド
     *
     * @param order 打ち手の順番
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * プレーヤーの打ち手の順番を取得するためのメソッド
     */
    public int getOrder() {
        return this.order;
    }

    /**
     * playerのstoneを設定するためのメソッド
     *
     * @param stone playerのstone
     */
    public void setStone(MOVES stone) {
        this.stone = stone;
    }

    /**
     * playerのstoneを返すためのメソッド
     *
     * @return playerのstone
     */
    public MOVES getStone() {
        return this.stone;
    }
}
