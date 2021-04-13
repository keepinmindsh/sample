package lines.algorithm.code2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Code2 {
    public static void main(String[] args) {
        int[][] boards = {{0,0,0,0,0}
                         ,{0,0,1,0,3}
                         ,{0,2,5,0,1}
                         ,{4,2,4,4,2}
                         ,{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        // 4 3 1 1 3 2 4

        log.info("vlaue y : {}", boards.length);
        log.info("vlaue x : {}", boards[0].length);
        log.info("moves : {}", moves.length);

        log.info("Result Count : {}", solution(boards, moves));
    }

    public static int solution(int[][] board, int[] moves) {

        int rows = moves.length;

        List<Integer> integerList = new ArrayList<>();

        int returnInts = 0;

        for(int i = 0; i < rows ; i ++ ){
            int target = moves[i] - 1;
            int yrows = board.length;
            for(int y = 0; y < yrows ; y ++ ){
                log.info("y value : {}, target value : {}", y, target + 1);
                if(board[y][target] != 0){
                    log.info("board[y][target] : {}", board[y][target] );
                    integerList.add(board[y][target]);
                    board[y][target] = 0;
                    break;
                }
            }
        }

        return recursiveCount(integerList, 0, integerList.size());
    }

    public static int recursiveCount(List<Integer> integerList, int index, int maxSize){

        if((index + 1) == maxSize){
            return 0;
        }

        if(integerList.get(index).compareTo(integerList.get(index + 1)) == 0){
            integerList.remove(index);
            integerList.remove(index);

            return recursiveCount(integerList, 0 , integerList.size()) + 2;
        }else{
            return recursiveCount(integerList, index + 1 , integerList.size()) + 0;
        }
    }
}
