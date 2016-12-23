import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * コマンドラインとのやりとりを行うクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class Terminal {

    /**
     * コマンドライン上にゲーム番を描くためのメソッド
     */
    public void drawBoard(MOVES[][] gameBoard) {


        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[0][0], 1) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[0][1], 2) + " |");
        System.out.println("|" + this.changeMovesToStone(gameBoard[0][2], 3) + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[1][0], 4) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[1][1], 5) + " |");
        System.out.println("|" + this.changeMovesToStone(gameBoard[1][2], 6) + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.print(" ___");
        System.out.print("  ___");
        System.out.println("  ___");
        System.out.print("| " + this.changeMovesToStone(gameBoard[2][0], 7) + " |");
        System.out.print("| " + this.changeMovesToStone(gameBoard[2][1], 8) + " |");
        System.out.println("|" + this.changeMovesToStone(gameBoard[2][2], 9) + "  |");
        System.out.print(" ---");
        System.out.print("  ---");
        System.out.println("  ---");

        System.out.println("表示されている数字を入力してください");
        System.out.println("○や×が表示されている場所は");
    }


    /**
     * MOVESから石の文字に変換するためのメソッド
     *
     * @param moves MOVESのEnumの要素
     * @return 石の文字
     */
    String changeMovesToStone(MOVES moves, int spotNumber) {
        if (moves == MOVES.USER_MOVE) {
            return "○";
        } else if (moves == MOVES.CPU_MOVE) {
            return "×";
        }
        return String.valueOf(spotNumber);

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
    public int[] receiveCommand() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String buf = bufferedReader.readLine();
        int userMove = Integer.parseInt(buf);
        return this.displaySpotParse(userMove);
    }

    /**
     * ディスプレイに表示させているゲーム盤の場所と、システム内部のint[][]の座標との対応関係を保持し、
     * ユーザーが選んだディスプレイ上のゲーム盤の場所に対応したシステム内部のint[][]を返すメソッド
     *
     * @param displaySpot ユーザーによって選択されたディスプレイ上の場所
     * @return システム上のint[][]
     */
    int[] displaySpotParse(int displaySpot) {
        Map<Integer, int[]> spotMap = new HashMap<>();
        spotMap.put(1, new int[]{0, 0});
        spotMap.put(2, new int[]{0, 1});
        spotMap.put(3, new int[]{0, 2});
        spotMap.put(4, new int[]{1, 0});
        spotMap.put(5, new int[]{1, 1});
        spotMap.put(6, new int[]{1, 2});
        spotMap.put(7, new int[]{2, 0});
        spotMap.put(8, new int[]{2, 1});
        spotMap.put(9, new int[]{2, 2});

        return spotMap.get(displaySpot);
    }
}
