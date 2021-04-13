package lines.algorithm.code2;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class Code2_1 {
    public static void main(String[] args) {
        int[][] boards = {{0,0,0,0,0}
                ,{0,0,1,0,3}
                ,{0,2,5,0,1}
                ,{4,2,4,4,2}
                ,{3,5,1,3,1}};

        int[][] boards2 = {{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}};

        int[] moves = {1,5,3,5,1,2,1,4};
        int[] moves2 = {1, 2, 3, 3, 2, 3, 1};

        // 4 3 1 1 3 2 4

        log.info("vlaue y : {}", boards.length);
        log.info("vlaue x : {}", boards[0].length);
        log.info("moves : {}", moves.length);

        log.info("Result Count : {}", solution(boards, moves));
    }

    public static int solution(int[][] board, int[] moves) {

        int rows = moves.length;

        Stack<Integer> integerStack = new Stack<>();
        int lastValue = 0;
        int answer = 0;


        for(int i = 0; i < rows ; i ++ ){
            int target = moves[i] - 1;
            int yrows = board.length;
            for(int y = 0; y < yrows ; y ++ ){
                log.info("y value : {}, target value : {}", y, target + 1);
                if(board[y][target] != 0){
                    log.info("board[y][target] : {}", board[y][target] );

                    integerStack.push(board[y][target]);

                    if(lastValue == board[y][target]){
                        if(!integerStack.isEmpty()) integerStack.pop();
                        if(!integerStack.isEmpty()) integerStack.pop();
                        answer += 2;
                        lastValue =integerStack.peek();
                    }else{
                        lastValue = board[y][target];
                    }
                    board[y][target] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
