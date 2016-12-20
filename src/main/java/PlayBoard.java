/**
 * ゲーム番を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class PlayBoard {
    /**
     * 打ち手を格納するための配列
     */
    private Moves[] movesArray = new Moves[9];

    /**
     * ゲーム盤に打ち手を打つためのメソッド
     *
     * @param point ゲーム盤の場所
     * @param moves 各プレーヤーの打ち手
     */
    public void addMoves(int point, Moves moves) {
        movesArray[point] = moves;
    }

    /**
     * ゲーム盤を取得するためのメソッド
     *
     * @return 打ち手を格納するための配列
     */
    public Moves[] getMovesArray() {
        return this.movesArray;
    }

    /**
     * movesArrayに格納されている打ち手を返す
     * @param index moves
     * @return Movesの定数
     */
    public Moves getMoves(int index){
        return movesArray[index];
    }
}
