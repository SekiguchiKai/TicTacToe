/**
 * 印
 * Created by sekiguchikai on 2016/12/23.
 */
public enum SIGNAL {
    CIRCLE("○"),
    CROSS("×"),
    EMPTY(" ");

    private final String signal;

    /**
     * コンストラクタ
     * 初期化を行う
     * @param signal
     */
    private SIGNAL(final String signal) {
        this.signal = signal;
    }

    /**
     * 各定数に設定された文字列を返す
     * @return
     */
    public String getSignal() {
        return this.signal;
    }
}
