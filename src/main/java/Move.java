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
     * コンストラクタ
     * playBoardを初期化する
     *
     * @param playBoard ゲーム盤
     */
    public Move(PlayBoard playBoard) {
        this.playBoard = playBoard;
    }

    /**
     * 打ち手を決めるためのメソッド
     */
    public abstract void decideMove();

    /**
     * @param moves プレーヤーの打ち手
     * @param point ゲーム盤の場所
     */
    public void doMove(Moves moves, int point) {

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
}
