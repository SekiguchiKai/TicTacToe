
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
     * 勝敗が決まったかの真偽値
     * @param gameBoard MOVESの要素が格納されているゲーム盤
     * @return 勝敗が決まったかどうかの真偽値
     */
    public boolean judgeResult(MOVES[][] gameBoard) {
        return this.isColumnWin(gameBoard) && this.isRowWin(gameBoard) && this.isSlantingWin(gameBoard);
    }


    /**
     * 縦のラインで勝敗が決定しているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 縦のラインで勝敗が決定しているかどうかの真偽値
     */
    public boolean isRowWin(MOVES[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            if (isThreeStonesEqual(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2])) {
                return true;
            }
        }
        return false;
    }


    /**
     * 横のラインで勝敗が決定しているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 横のラインで勝敗が決定しているかどうかの真偽値
     */
    public boolean isColumnWin(MOVES[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            if (isThreeStonesEqual(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 斜めのラインで勝敗が決定しているか確認するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 斜めのラインで勝敗が決定しているかどうかの真偽値
     */
    public boolean isSlantingWin(MOVES[][] gameBoard) {

        boolean leftOblique = false;
        boolean rightOblique = false;

        for (int i = 0; i < 3; i++) {
            leftOblique = isThreeStonesEqual(gameBoard[i][i], gameBoard[i][i], gameBoard[i][i]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j--) {
                rightOblique = isThreeStonesEqual(gameBoard[i][j], gameBoard[i][j], gameBoard[i][j]);
            }
        }

        if (!leftOblique && !rightOblique) {
            return false;
        } else {
            return true;
        }
    }
}
