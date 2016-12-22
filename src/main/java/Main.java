/**
 * Mainのクラス、このアプリケーションのエントリーポイント
 * Created by sekiguchikai on 2016/12/20.
 */
public class Main {
    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();
        gameBoard.addMoves(2, 0, MOVES.USER_MOVE);


    }
}
