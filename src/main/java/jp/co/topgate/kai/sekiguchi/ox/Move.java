package jp.co.topgate.kai.sekiguchi.ox;

/**
 * UserMove及び、CpuMoveのインスタンスの継承元である抽象クラス
 * Created by sekiguchikai on 2016/12/19.
 */
public abstract class Move {
    /**
     * ゲームの盤
     * PlayBoardクラスのインスタンス
     */
    PlayBoard playBoard;

    /**
     * 打ち手を打つ順番
     */
    int order;

    /**
     * このクラスを継承したクラスのインスタンスの順番を設定するメソッド
     * @param order 順番
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * 順番を取得するためのメソッド
     * @return 順番
     */
    public int getOrder(){
        return this.order;
    }



    /**
     * コンストラクタ
     * playBoardを初期化する
     *
     * @param playBoard PlayBoardクラスのインスタンス
     */
     Move(PlayBoard playBoard) {
        this.playBoard = playBoard;
    }

    /**
     * 打ち手を決定するメソッド
     */
    public void decideMove() {

    }

    /**
     * 打ち手を登録するためのメソッド
     *
     * @param moves 打ち手を打つ主体
     * @param point 打ち手を打つ盤の場所
     */
    public void doMove(Moves moves, int point) {

    }


}
