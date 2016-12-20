
import org.junit.Test;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * NormalGameLogicクラスをテストするためのクラス
 * Created by sekiguchikai on 2016/12/20.
 */
public class NormalGameLogicTest {

    private PlayBoard playBoard = new PlayBoard();

    Move userMove = new UserMove(playBoard);
    Move cpuMove = new CpuMove(playBoard);
    private NormalGameLogic normalGameLogic = new NormalGameLogic(playBoard, userMove, cpuMove);

    /**
     * playGameをテストするためのメソッド
     *
     * @throws Exception
     */
    @Test
    public void playGame() {

    }

    /**
     * decideOrderクラスをテストするためのメソッド
     */
    @Test
    public void decideOrder() {
        List<Integer> userOrderList = new ArrayList<>();
        List<Integer> cpuOrderList = new ArrayList<>();

        IntStream.range(0, 100).forEach(i -> {
            normalGameLogic.decideOrder();
            userOrderList.add(userMove.getOrder());
            cpuOrderList.add(cpuMove.getOrder());
        });

        assertThat(userOrderList, hasItem(1));
        assertThat(cpuOrderList, hasItem(1));

    }

    /**
     * judgeResultクラスをテストするためのメソッド
     */
    @Test
    public void judgeResult() {

    }

}