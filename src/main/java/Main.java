/**
 * Mainのクラス、このアプリケーションのエントリーポイント
 * Created by sekiguchikai on 2016/12/20.
 */
public class Main {
    /**
     * メインメソッド
     * @param args
     */
    public static void main(String[] args) {
        GameLogic normalGameLogic = new NormalGameLogic();
        normalGameLogic.playGame();
    }
}
