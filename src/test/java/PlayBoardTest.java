
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * クラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class PlayBoardTest {

    /**
     * addMoveメソッドをテストするためのメソッド
     */
    @Test
    public void addMove() {
        PlayBoard playBoard = new PlayBoard();

        int oddArray[] = {1, 3, 5, 7};
        int evenArray[] = {0, 2, 4, 6, 8};


        Arrays.stream(oddArray).forEach(i -> playBoard.addMoves(i, Moves.USERMOVE));
        Arrays.stream(evenArray).forEach(i -> playBoard.addMoves(i, Moves.CPUMOVE));

        Moves[] movesArray = playBoard.getMovesArray();

        List<Moves> userMovesList = new ArrayList<>();
        List<Moves> cpuMovesList = new ArrayList<>();


        Arrays.stream(oddArray).forEach(i -> userMovesList.add(movesArray[i]));
        Arrays.stream(evenArray).forEach(i -> cpuMovesList.add(movesArray[i]));

        IntStream.range(0, oddArray.length).filter(i -> i % 2 == 1).forEach(v -> assertThat(userMovesList.get(v), is(Moves.USERMOVE)));
        IntStream.range(0, evenArray.length).filter(i -> i % 2 == 0).forEach(v -> assertThat(cpuMovesList.get(v), is(Moves.CPUMOVE)));

    }

    /**
     * getMoveArrayメソッドをテストするためのメソッド
     */
    @Test
    public void getMoveArray() {
        PlayBoard playBoard = new PlayBoard();
        IntStream.range(0, 9).forEach(i -> playBoard.addMoves(i, Moves.CPUMOVE));
        IntStream.range(0, 9).forEach(i -> assertThat(playBoard.getMoves(i), is(Moves.CPUMOVE)));
    }

}