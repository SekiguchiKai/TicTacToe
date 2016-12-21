
/**
 * 勝敗を判断するためのクラス
 * Created by sekiguchikai on 2016/12/21.
 */
public class JudgeLogic {

    /**
     * 3つの連続する石の値が同値かどうかを確認するためのメソッド
     *
     * @param moves1 3連続の石の一つ
     * @param moves2 3連続の石の一つ
     * @param moves3 3連続の石の一つ
     * @return 3つの連続する石の値が同値かどうかの真偽値
     */
    public boolean isThreeStonesEqual(MOVES moves1, MOVES moves2, MOVES moves3) {
        return (moves1 == moves2 && moves2 == moves3);
    }


    /**
     * 縦のラインで勝敗が決定しているか確認するためのメソッド
     *
     * @param moveArray ゲーム盤
     * @return 縦のラインで勝敗が決定しているかどうかの真偽値
     */
    public boolean isRowWin(MOVES[][] moveArray) {
        for (int i = 0; i < 3; i++) {
            if (isThreeStonesEqual(moveArray[i][0], moveArray[i][1], moveArray[i][2])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 横のラインで勝敗が決定しているか確認するためのメソッド
     *
     * @param moveArray ゲーム盤
     * @return 横のラインで勝敗が決定しているかどうかの真偽値
     */
    public boolean isColumnWin(MOVES[][] moveArray) {
        for (int i = 0; i < 3; i++) {
            if (isThreeStonesEqual(moveArray[0][i], moveArray[1][i], moveArray[2][i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 斜めのラインで勝敗が決定しているか確認するためのメソッド
     *
     * @param moveArray ゲーム盤
     * @return 斜めのラインで勝敗が決定しているかどうかの真偽値
     */
    public boolean isSlantingWin(MOVES[][] moveArray) {

        boolean leftOblique = false;
        boolean rightOblique = false;

        for (int i = 0; i < 3; i++) {
            leftOblique = isThreeStonesEqual(moveArray[i][i], moveArray[i][i], moveArray[i][i]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j--) {
                rightOblique = isThreeStonesEqual(moveArray[i][j], moveArray[i][j], moveArray[i][j]);
            }
        }

        if (!leftOblique && !rightOblique) {
            return false;
        } else {
            return true;
        }
    }
}
