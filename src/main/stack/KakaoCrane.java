package main.stack;
import java.util.Stack;

/**
 * [문제]
 * 	게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 
 * 	담긴 배열 moves가 매개변수로 주어질 때, 크레인을 모두 작동시킨 후 터트려져 
 * 	사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * [제한사항]
 * 	1. board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
 *  2. board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
 *  3. 0은 빈 칸을 나타냅니다.
 *  4. 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
 *  5. moves 배열의 크기는 1 이상 1,000 이하입니다.
 *  6. moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
 */
public class KakaoCrane {

	public static void main(String[] args) {
		System.out.println("크레인 문제 ");
		int[][] board = 
			{
					{0,0,0,0,0},
					{0,0,1,0,3},
					{0,2,5,0,1},
					{4,2,4,4,2},
					{3,5,1,3,1}
			}; // 보드 배열 5*5

		int[] moves = {1,5,3,5,1,2,1,4}; // 크레인 작동 위치
		System.out.println(solution(board, moves)); // 알고리즘 해결
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0; // 사라진 인형의 개수 카운트
		/**
		 * 1. 인형을 담을 스택 생성
		 */
		Stack<Integer> stack = new Stack<>();
		/**
		 * 2. 크레인 작동 위치배열 반복
		 */
		for (int move : moves) {
			/**
			 * 3. 2번으로 움직인 위치의 인형보드 배열 읽기
			 */
			for (int j = 0; j < board.length; j++) {
				/**
				 * 4. 첫번째 움직인 위치에서(2번), 크레인 작동위치 실행
				 * 		(단, 0이 아니여야 함)
				 */
				if (board[j][move - 1] != 0) {
					/**
					 * 5. 0이 아닌 상태에서, 아직 인형을 담은 스택에 인형이 담겨있지 않은경우 
					 */
					if (stack.isEmpty()) {
						/**
						 * 5-1. 해당 인형보드의 값을 인형을 담을 스택에 푸쉬
						 */
						stack.push(board[j][move - 1]);
						/**
						 * 5-2. 담은 보드의 위치를 빈값 (0)으로 처리
						 */
						board[j][move - 1] = 0;
						break;
					}
					/**
					 * 6. 0이 아닌 상태에서, 현재 인형보드의 인형과 인형이 담길 스택의 값이 같은 경우
					 */
					if (board[j][move - 1] == stack.peek()) {
						/**
						 * 6-1. 인형이 담긴 스택에서 pop으로 빼내기
						 */
						stack.pop();
						/**
						 * 6-2. 사라진 인형의 개수 업데이트 (2개가 없어졌으니, 2를 업데이트 한다.)
						 */
						answer += 2;
					} else {
						/**
						 * 7. 0이 아닌 상태에서, 현재 인형보드의 인형과 인형이 담길 스택의 값이 다른 경우
						 */
						/**
						 * 7-1. 인형이 담긴 스택에 푸쉬
						 */
						stack.push(board[j][move - 1]);
					}
					/**
					 * 8. 담은 보드의 위치를 빈값 (0)으로 처리
					 */
					board[j][move - 1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}