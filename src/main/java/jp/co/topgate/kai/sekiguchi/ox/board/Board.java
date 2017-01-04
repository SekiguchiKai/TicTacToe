package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * ゲーム番を表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Board {
    /**
     * 打ち手を格納するための配列
     */
    private Moves[] gameBoard = new Moves[9];

    public static int gameBoardLength = 9;

    /**
     * コンストラクタ
     * initGameBoardメソッドを呼び出す
     */
    public Board() {
        IntStream.range(0, gameBoardLength).forEach(i -> gameBoard[i] = Moves.NO_MOVE);
    }


    /**
     * ゲーム盤に打ち手を打つためのメソッド
     *
     * @param spot  ゲーム盤の場所
     * @param Moves 各プレーヤーの打ち手
     */
    public void putMoves(int spot, Moves Moves) {
        gameBoard[spot] = Moves;
    }

    /**
     * ゲーム盤を取得するためのメソッド
     *
     * @return 打ち手を格納するための配列
     */
    public Moves[] getGameBoardState() {

        Moves[] copyArray = new Moves[9];
        IntStream.range(0, Board.gameBoardLength).forEach(i -> copyArray[i] = this.gameBoard[i]);

        return copyArray;
    }

}
