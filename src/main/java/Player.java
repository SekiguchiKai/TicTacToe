/**
 * 各プレーヤーの打ち手を表す抽象クラス
 * Created by sekiguchikai on 2016/12/20.
 */
public abstract class Player {

    /**
     * ゲーム盤
     */
    Board board;

    /**
     * ミニマックスアルゴリズム
     */
    MinMaxLogic minMaxLogic;

    Terminal terminal;


    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param board ゲーム盤
     */
    public Player(Board board, MinMaxLogic minMaxLogic, Terminal terminal) {
        this.board = board;
        this.minMaxLogic = minMaxLogic;
        this.terminal = terminal;
    }

    /**
     * 打ち手を打つメソッド
     */
    public abstract void doMove(int depth);


}
