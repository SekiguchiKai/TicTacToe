package jp.co.topgate.kai.sekiguchi.ox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;

/**
 * NormalGameLogicをテストするためのクラス
 * Created by sekiguchikai on 2016/12/19.
 */
public class NormalGameLogicTest {

    NormalGameLogic normalGameLogic = new NormalGameLogic();

    /**
     * decideOrderをテストするためのメソッド
     */
    @org.junit.Test
    public void decideOrder() {
        PlayBoard playBoard = new PlayBoard();
        Move userMove = new UserMove(playBoard);
        Move cpuMove = new CpuMove(playBoard);
        List<Integer> userMoveOrderList = new ArrayList<>();
        List<Integer> cpuMoveOrderList = new ArrayList<>();

        IntStream.range(0, 100).forEach(i -> {
            normalGameLogic.decideOrder(userMove, cpuMove);
            userMoveOrderList.add(userMove.getOrder());
            cpuMoveOrderList.add(cpuMove.getOrder());
        });

        assertThat(userMoveOrderList, hasItems(1, 2));
        assertThat(cpuMoveOrderList, hasItems(1, 2));


    }

    @org.junit.Test
    public void judgeResult() throws Exception {


    }

}