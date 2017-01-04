package jp.co.topgate.kai.sekiguchi.ox.logic;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.MinMaxCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.MOVES;
import jp.co.topgate.kai.sekiguchi.ox.constantset.RESULT;
import jp.co.topgate.kai.sekiguchi.ox.io.CommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.player.Cpu;
import jp.co.topgate.kai.sekiguchi.ox.player.Player;
import jp.co.topgate.kai.sekiguchi.ox.player.User;

import java.util.*;
import java.util.stream.IntStream;


/**
 * ノーマルモードのゲームを表すクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogic implements GameLogic {

    // とりあえず user= ○, cpu= ×

    /**
     * ゲームを進行していくロジックを担当するメソッド
     */
    @Override
    public void playGame() {
        Board board = new Board();
        CommandLineIO commandLineIO = new CommandLineIO();
        MinMaxCalculator minMaxCalculator = new MinMaxCalculator();
        Player user = new User(board, minMaxCalculator, commandLineIO);
        Player cpu = new Cpu(board, minMaxCalculator, commandLineIO);


        commandLineIO.drawBoard(board.getGameBoard());

        int depthCount = 2;


        while (this.judgeResult(board.getGameBoard()) == RESULT.PENDING) {

            user.doMove(depthCount);


            if (this.judgeResult(board.getGameBoard()) == RESULT.PENDING) {
                cpu.doMove(depthCount);
            }


        }

        commandLineIO.drawResult(this.judgeResult(board.getGameBoard()));


    }


    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return 勝敗の結果
     */
    RESULT judgeResult(MOVES[] gameBoard) {

        if (this.judgeLose(gameBoard)) {
            return RESULT.LOSE;
        } else if (this.judgeWin(gameBoard)) {
            return RESULT.WIN;
        }

        List<MOVES> gameBoardList = Arrays.asList(gameBoard);

        if (!gameBoardList.contains(MOVES.NO_MOVE)) {
            return RESULT.DRAW;
        }

        return RESULT.PENDING;
    }


    /**
     * ユーザーが敗北しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが敗北しているかの真偽値
     */
    boolean judgeLose(MOVES[] gameBoard) {
        return (gameBoard[0] == MOVES.CPU_MOVE && gameBoard[1] == MOVES.CPU_MOVE && gameBoard[2] == MOVES.CPU_MOVE ||
                gameBoard[3] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[5] == MOVES.CPU_MOVE ||
                gameBoard[6] == MOVES.CPU_MOVE && gameBoard[7] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[0] == MOVES.CPU_MOVE && gameBoard[3] == MOVES.CPU_MOVE && gameBoard[6] == MOVES.CPU_MOVE ||
                gameBoard[1] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[7] == MOVES.CPU_MOVE ||
                gameBoard[2] == MOVES.CPU_MOVE && gameBoard[5] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[0] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[8] == MOVES.CPU_MOVE ||
                gameBoard[2] == MOVES.CPU_MOVE && gameBoard[4] == MOVES.CPU_MOVE && gameBoard[6] == MOVES.CPU_MOVE
        );
    }

    /**
     * ユーザーが勝利しているかの真偽値を返すメソッド
     *
     * @param gameBoard ゲーム盤
     * @return ユーザーが勝利しているかの真偽値
     */
    boolean judgeWin(MOVES[] gameBoard) {
        return (gameBoard[0] == MOVES.USER_MOVE && gameBoard[1] == MOVES.USER_MOVE && gameBoard[2] == MOVES.USER_MOVE ||
                gameBoard[3] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[5] == MOVES.USER_MOVE ||
                gameBoard[6] == MOVES.USER_MOVE && gameBoard[7] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[0] == MOVES.USER_MOVE && gameBoard[3] == MOVES.USER_MOVE && gameBoard[6] == MOVES.USER_MOVE ||
                gameBoard[1] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[7] == MOVES.USER_MOVE ||
                gameBoard[2] == MOVES.USER_MOVE && gameBoard[5] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[0] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[8] == MOVES.USER_MOVE ||
                gameBoard[2] == MOVES.USER_MOVE && gameBoard[4] == MOVES.USER_MOVE && gameBoard[6] == MOVES.USER_MOVE
        );

    }


}




