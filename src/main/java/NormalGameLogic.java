

import java.util.*;


/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic implements GameLogic {


    // とりあえず user= ○, cpu= ×


    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    public void playGame() {
        GameBoard gameBoard = new GameBoard();
        Terminal terminal = new Terminal();
        MinMaxLogic minMaxLogic = new MinMaxLogic();
        Player user = new User(gameBoard, minMaxLogic, terminal);
        Player cpu = new Cpu(gameBoard, minMaxLogic, terminal);


        terminal.drawBoard(gameBoard.getGameBoard());

        int depthCount = 2;


        while (this.judgeResult(gameBoard.getGameBoard()) == RESULT.PENDING) {

            user.doMove(depthCount);


            if (this.judgeResult(gameBoard.getGameBoard()) == RESULT.PENDING) {
                cpu.doMove(depthCount);
            }


        }

        // ここターミナルにすること
        System.out.println(this.judgeResult(gameBoard.getGameBoard()));


    }


    Map<Integer, Player> decideOrder(Player user, Player cpu) {
        int userOrder = (int) (Math.random() * 2 + 1);
        Map<Integer, Player> orderMap = new HashMap<>();
        if (userOrder == 1) {
            orderMap.put(1, user);
            orderMap.put(2, cpu);
        } else {
            orderMap.put(1, cpu);
            orderMap.put(2, user);
        }

        return orderMap;

    }

    RESULT judgeResult(MOVES[] gameBoard) {

        if (gameBoard[0] == MOVES.CPU_MOVE && gameBoard[1] == MOVES.CPU_MOVE && gameBoard[2] == MOVES.CPU_MOVE ||
                gameBoard[3] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[5] == MOVES.CPU_MOVE ||
                gameBoard[6] == MOVES.CPU_MOVE && gameBoard[7] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[0] == MOVES.CPU_MOVE && gameBoard[3] == MOVES.CPU_MOVE && gameBoard[6] == MOVES.CPU_MOVE ||
                gameBoard[1] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[7] == MOVES.CPU_MOVE ||
                gameBoard[2] == MOVES.CPU_MOVE && gameBoard[5] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[0] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[2] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[6] == MOVES.CPU_MOVE
                ) {
            return RESULT.LOSE;
        } else if (gameBoard[0] == MOVES.USER_MOVE && gameBoard[1] == MOVES.USER_MOVE && gameBoard[2] == MOVES.USER_MOVE ||
                gameBoard[3] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[5] == MOVES.USER_MOVE ||
                gameBoard[6] == MOVES.USER_MOVE && gameBoard[7] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[0] == MOVES.USER_MOVE && gameBoard[3] == MOVES.USER_MOVE && gameBoard[6] == MOVES.USER_MOVE ||
                gameBoard[1] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[7] == MOVES.USER_MOVE ||
                gameBoard[2] == MOVES.USER_MOVE && gameBoard[5] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[0] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[2] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[6] == MOVES.USER_MOVE
                ) {
            return RESULT.WIN;
        }

        List<MOVES> gameBoardList = Arrays.asList(gameBoard);

        if (!gameBoardList.contains(MOVES.NO_MOVE)) {
            return RESULT.DRAW;
        }

        return RESULT.PENDING;
    }
}




