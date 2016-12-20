package jp.co.topgate.kai.sekiguchi.ox;

/**
 * ゲーム盤を表すクラス
 * Created by sekiguchikai on 2016/12/19.
 */
public class PlayBoard {
    private Moves[] moveAraay;

    /**
     * moveArrayにMoveを追加するためのメソッド
     *
     * @param moves  moveArrayに格納されているUserMove及び、CpuMoveのインスタンス
     * @param point ゲーム盤の場所
     */
    public void addMove(Moves moves, int point) {
        this.moveAraay[point] = moves;
    }

    /**
     * UserMove及び、CpuMoveのインスタンスが格納されている配列を返すメソッド
     *
     * @return UserMove及び、CpuMoveのインスタンスが格納されている配列
     */
    public Moves[] getMoveAraay() {
        return this.moveAraay;
    }
}
