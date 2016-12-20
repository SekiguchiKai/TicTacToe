
import org.hamcrest.CoreMatchers;
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


        Arrays.stream(oddArray).forEach(i -> playBoard.addMoves(i, Stones.CIRCLE));
        Arrays.stream(evenArray).forEach(i -> playBoard.addMoves(i, Stones.CROSS));

        Stones[] stonesArray = playBoard.getStonesArray();

        List<Stones> userStonesList = new ArrayList<>();
        List<Stones> cpuStonesList = new ArrayList<>();


        Arrays.stream(oddArray).forEach(i -> userStonesList.add(stonesArray[i]));
        Arrays.stream(evenArray).forEach(i -> cpuStonesList.add(stonesArray[i]));

        IntStream.range(0, oddArray.length).filter(i -> i % 2 == 1).forEach(v -> assertThat(userStonesList.get(v), is(Stones.CIRCLE)));
        IntStream.range(0, evenArray.length).filter(i -> i % 2 == 0).forEach(v -> assertThat(cpuStonesList.get(v), is(Stones.CROSS)));

    }

    /**
     * getMoveArrayメソッドをテストするためのメソッド
     */
    @Test
    public void getMoveArray() {
        PlayBoard playBoard = new PlayBoard();
        IntStream.range(0, 9).forEach(i -> playBoard.addMoves(i, Stones.CIRCLE));
        IntStream.range(0, 9).forEach(i -> assertThat(playBoard.getMoves(i), is(Stones.CIRCLE)));
    }

}