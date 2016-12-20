import java.util.stream.IntStream;

/**
 * ゲーム番を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class PlayBoard {
    /**
     * 打ち手を格納するための配列
     */
    private Stones[] stonesArray = new Stones[9];

    /**
     * コンストラクタ
     * initStonesArrayメソッドを呼び出す
     */
    public PlayBoard(){
        this.initStonesArray();
    }

    /**
     * stonesArrayを初期化するためのメソッド
     */
    public void initStonesArray() {
        IntStream.range(0, 9).forEach(i -> stonesArray[i] = Stones.EMPTY);
    }

    /**
     * ゲーム盤に打ち手を打つためのメソッド
     *
     * @param point  ゲーム盤の場所
     * @param stones 各プレーヤーの打ち手
     */
    public void addMoves(int point, Stones stones) {
        stonesArray[point] = stones;
    }

    /**
     * ゲーム盤を取得するためのメソッド
     *
     * @return 打ち手を格納するための配列
     */
    public Stones[] getStonesArray() {
        return this.stonesArray;
    }

    /**
     * movesArrayに格納されている打ち手を返す
     *
     * @param index moves
     * @return Movesの定数
     */
    public Stones getMoves(int index) {
        return stonesArray[index];
    }
}
