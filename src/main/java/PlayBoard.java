/**
 * ゲーム番を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class PlayBoard {
    /**
     * 打ち手を格納するための配列
     */
    private Moves[] moveArray = new Moves[9];

    /**
     * ゲーム盤に打ち手を打つためのメソッド
     * @param moves 各プレーヤーの打ち手
     * @param point ゲーム盤の場所
     */
    public void addMove(Moves moves, int point){

    }

    /**
     * ゲーム盤を取得するためのメソッド
     * @return 打ち手を格納するための配列
     */
    public Moves[] getMoveArray() {
       return this.moveArray;

    }
}
