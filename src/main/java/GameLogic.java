/**
 * 各ゲームロジックの継承元
 * Created by sekiguchikai on 2016/12/20.
 */
public interface GameLogic {

    /**
     * ゲームを進行していくロジックを担当するメソッド
     *
     * @return 勝敗結果
     */
    public abstract void playGame();


}
