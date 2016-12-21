/**
 * 各プレーヤーの打ち手を表す抽象クラス
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class Move {

    /**
     * ゲーム盤
     */
    PlayBoard playBoard;
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
     * playBoardを初期化する
     *
     * @param playBoard ゲーム盤
     */
    public Move(PlayBoard playBoard) {
        this.playBoard = playBoard;
    }

    /**
     * @param point  ゲーム盤の場所
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
