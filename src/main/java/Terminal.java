import java.util.HashMap;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Terminal {
    /**
     * コマンドライン上にゲーム番を描くためのメソッド
     */
    public void drawBoard(Stones[] stonesArray) {


        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + stonesArray[0].getStone() + " |");
        System.out.print("| " + stonesArray[1].getStone() + " |");
        System.out.println("|" + stonesArray[2].getStone() + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + stonesArray[3].getStone() + " |");
        System.out.print("| " + stonesArray[4].getStone() + " |");
        System.out.println("|" + stonesArray[5].getStone() + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + stonesArray[6].getStone() + " |");
        System.out.print("| " + stonesArray[7].getStone() + " |");
        System.out.println("|" + stonesArray[8].getStone() + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

    }

    /**
     * 勝敗結果をコマンドライン上に描くためのメソッド
     *
     * @param result 勝敗結果
     */
    public void drawResult(String result) {
        System.out.println(result);
    }

    /**
     * コマンドラインからの入力を受け取る
     *
     * @return 盤の場所を返す
     */
    public int receiveCommand() {
        return 0;

    }
}
