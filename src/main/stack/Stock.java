package main.stack;

import java.util.Stack;

/**
 * [문제]
 * 	초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 * 	가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 
 * [제한사항]
 * 	1. prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * 	2. prices의 길이는 2 이상 100,000 이하입니다.
 */
public class Stock {

	public static void main(String[] args) {
		System.out.println("주식가격 문제 ");
		int[] answer = {1, 2, 3, 2, 3};
		System.out.println(solutionResult(answer)); // 알고리즘 해결
	}
	
	 public static String solutionResult(int[] answer) {
		 int[] a = solution(answer);
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i<a.length; i++) {
			 sb.append(" 가격이 떨어지지 않은 기간 : " + a[i] + " / ");
		 }
		 return sb.toString();
	 }

	 /**
		 * [예시]
		 * 	 - prices {1, 2, 3, 2, 3}: 초 단위로 기록된 주식가격이 담긴 배열
		 * 	 - return {4, 3, 1, 1, 0}: 가격이 떨어지지 않은 기간
		 * 
		 * 	1) prices 배열의 1을 기준으로 배열 끝까지 1보다 작은 수는 나오지 않는다.
		 * 		즉, 주식가격이 떨어지지 않은것으로 2,3,2,3의 개수 총 4개를 return 배열에 입력한다.
		 * 
		 *  2) 2를 기준으로 배열 끝까지 2보다 작은 수는 나오지 않는다.
		 *  	즉, 주식가격이 떨어지지 않은 것으로 3,2,3의 개수 총 3개를 return 배열에 입력한다.
		 *  
		 *  3) 3을 기준으로 바로 다음에 3보다 작은수인 2가 나온다.
		 *  	즉, 주식가격이 떨어진 것으로 1을 return배열에 입력한다.
		 *  
		 *  4) 2를 기준으로 배열 끝까지 2보다 작은 수는 나오지 않는다.
		 *  	즉, 주식가격이 떨어지지 않은 것으로 총 1을 return 배열에 입력한다.
		 *  
		 *  5) 마지막 숫자인 3은 비교할 수 없으므로 무조건 마지막은 0을 입력한다.
		 * 
		 */
	public static int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>(); // 주식가격 스택
        int i=0;
        int[] terms = new int[prices.length]; // 가격이 떨어지지 않은 기간 배열

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
        	// 전 가격이 현재가격보다 큰 경우 (가격이 떨어진 경우)
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                System.out.println(beginIdx + " / prices[i]: " + prices[i] + " / idx: " + (i+1) + " 번째");
                terms[beginIdx] = i - beginIdx; // 현재부터 시작점까지의 차이
            }
            
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
           // System.out.println(beginIdx);
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}