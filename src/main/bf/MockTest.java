package main.bf;

import java.util.ArrayList;

/**
 * [문제]
 * 	수포자는 수학을 포기한 사람의 준말입니다. 
 * 	수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
 * 	수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 		- 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 		- 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 		- 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한 조건]
 * 	1. 시험은 최대 10,000 문제로 구성되어있습니다.
 * 	2. 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 	3. 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class MockTest {
	
	public static void main(String[] args) {
		System.out.println("모의고사 문제 ");
		int[] answer = {1,3,2,4,2};
		System.out.println(solutionResult(answer)); // 알고리즘 해결
	}

	 public static String solutionResult(int[] answer) {
		 int[] a = solution(answer);
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i<a.length; i++) {
			 sb.append(" 가장 많은 문제를 맞힌 사람 : " + a[i] + " / ");
		 }
		 return sb.toString();
	 }

	public static int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}