/**
 * 結果の要素の集合体である列挙型
 * Created by sekiguchikai on 2016/12/23.
 */
public enum RESULT {
     WIN("君の勝ちだ"),
    LOSE("君の負けだ"),
    DRAW("引き分けだ"),
    PENDING("未決");

    private final String result;

    /**
     * コンストラクタ
     * 初期化する
     * @param result 勝敗結果
     */
    RESULT(String result) {
        this.result = result;
    }

    /**
     * 列挙型の要素を取得するためのメソッド
     * @return 列挙型の要素
     */
    public String getResult() {
        return this.result;
    }





}
