package jp.co.topgate.kai.sekiguchi.ox;

/**
 * ゲームの汎用的なロジックを表したクラス
 * Created by sekiguchikai on 2016/12/19.
 */
public abstract class GameLogic {

    /**
     * ゲーム盤
     * PlayBoardのインスタンス
     */
    private PlayBoard playBoard;


    /**
     * ゲームを進めていくためのメソッド
     */
    public abstract void playGame();



}
