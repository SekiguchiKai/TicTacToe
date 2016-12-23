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
     * ミニマックスアルゴリズム
     */
    MinMaxLogic minMaxLogic;

    Terminal terminal;


    /**
     * コンストラクタ
     * gameBoardを初期化する
     *
     * @param gameBoard ゲーム盤
     */
    public Player(GameBoard gameBoard, MinMaxLogic minMaxLogic, Terminal terminal) {
        this.gameBoard = gameBoard;
        this.minMaxLogic = minMaxLogic;
        this.terminal = terminal;
    }

    /**
     * 打ち手を打つメソッド
     */
    public abstract void doMove(int depth);


}
