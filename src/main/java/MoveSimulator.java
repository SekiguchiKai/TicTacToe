import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 打ち手をシュミレートするためのクラス
 * Created by sekiguchikai on 2016/12/21.
 */
public class MoveSimulator {


    /**
     * 現在石を置くことが可能なすべての手をリスト化する（EMPTYが存在しているGameBoardの場所）
     *
     * @param gameBoard ゲームの盤
     * @return EMPTYが存在するGameBoard上の場所の一覧を格納したList
     */
    public List<int[]> makeCapableList(MOVES[][] gameBoard) {

        List<int[]> capableMoveList = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> IntStream.range(0, 3).forEach(j -> {
            if (gameBoard[i][j] == MOVES.EMPTY) {
                capableMoveList.add(new int[]{i, j});
            }
        }));

        return capableMoveList;
    }




}

