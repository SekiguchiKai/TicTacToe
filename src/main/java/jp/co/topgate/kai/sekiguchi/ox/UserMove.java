package jp.co.topgate.kai.sekiguchi.ox;

import java.util.stream.IntStream;

/**
 * ユーザーの打ち手を表すクラス
 * Created by sekiguchikai on 2016/12/19.
 */
public class UserMove extends Move{

    /**
     * コンストラクタ
     * playBoardを初期化する
     *
     * @param playBoard PlayBoardクラスのインスタンス
     */
    public UserMove(PlayBoard playBoard) {
        super(playBoard);
    }

    /**
     * UserMoveの打ち手を決めるためのメソッド
     */
    public void decideMove() {

    }
}
