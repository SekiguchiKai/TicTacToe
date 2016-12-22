import java.io.*;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Terminal {
    /**
     * コマンドライン上にゲーム番を描くためのメソッド
     */
    public void drawBoard(MOVES[][] gameBoard, int userOrder, int cpuOrder) {


        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[0][0]) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[0][1]) + " |");
        System.out.println("|" + this.changeMovesToStone(gameBoard[0][2]) + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[1][0]) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[1][1]) + " |");
        System.out.println("|" + this.changeMovesToStone(gameBoard[1][2]) + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[2][0]) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[2][1]) + " |");
        System.out.println("|" + this.changeMovesToStone(gameBoard[2][2]) + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

    }


    /**
     * MOVESから石の文字に変換するためのメソッド
     *
     * @param moves MOVESのEnumの要素
     * @return 石の文字
     */
    String changeMovesToStone(MOVES moves) {
        if (moves == MOVES.USER_MOVE) {
            return "○";
        } else if (moves == MOVES.CPU_MOVE) {
            return "×";
        } else {
            return " ";
        }
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
     * @throws java.io.IOException コンソールからの入力を正常に受けてれませんでした
     */
    public int receiveCommand() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String buf = bufferedReader.readLine();
        return Integer.parseInt(buf);
    }
}
