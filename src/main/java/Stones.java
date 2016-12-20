/**
 * 各打ち手の定数を表すメソッド
 * Created by sekiguchikai on 2016/12/20.
 */
public enum Stones {
    CIRCLE("◯"),
    CROSS("×"),
    EMPTY(" ");

    /**
     * 石の文字列
     */
    private final String stone;

    /**
     * コンストラクタ
     *
     * @param stone 石の定数
     */
    private Stones(final String stone) {
        this.stone = stone;
    }

    /**
     * 指定されたenumの定数を石を文字で返すメソッド
     *
     * @return 石を文字で返す
     */
    public String getStone() {
        return stone;
    }
}
