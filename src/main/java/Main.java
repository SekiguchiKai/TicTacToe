/**
 * Mainのクラス、このアプリケーションのエントリーポイント
 * Created by sekiguchikai on 2016/12/20.
 */
public class Main {
    public static void main(String[] args) {

        PlayBoard playBoard = new PlayBoard();
        playBoard.addMoves(1, Stones.CIRCLE);
        Terminal terminal = new Terminal();
        terminal.drawBoard(playBoard.getStonesArray());

    }
}
