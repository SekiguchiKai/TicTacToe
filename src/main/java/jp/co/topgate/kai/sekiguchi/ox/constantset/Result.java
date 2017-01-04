package jp.co.topgate.kai.sekiguchi.ox.constantset;

/**
 * 結果の要素の集合体である列挙型
 * Created by sekiguchikai on 2016/12/23.
 */
public enum Result {
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
    Result(String result) {
        this.result = result;
    }

    /**
     * 各定数に設定された文字列を返すメソッド
     * @return 列挙型の要素
     */
    public String getResult() {
        return this.result;
    }





}
