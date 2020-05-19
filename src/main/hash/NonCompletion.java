package main.hash;

import java.util.HashMap;

/**
 * [문제]
 * 	수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
 * 	단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한사항]
 * 	1. 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * 	2. completion의 길이는 participant의 길이보다 1 작습니다.
 * 	3. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 	4. 참가자 중에는 동명이인이 있을 수 있습니다.
 */
public class NonCompletion {
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"}; // 참가자
		String[] completion = {"eden", "kiki"}; // 완주자
		solution(participant, completion); // 알고리즘 해결
	}

	public static String solution(String[] participant, String[] completion) {
        String answer = ""; // 미완주자 정보
        
        /**
         * 1. 완주결과 해시맵 생성
         */
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        /**
         * 2. 참가자 전체 해시맵 put ("01")
         */
        for (String player : participant) {
        	System.out.println("participant player: " + player + " / hm: " + hm.getOrDefault(player, 0) + 1);
        	hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        /**
         * 3. 참가자 정도 기반하에 완주자 체크 
         * 	 - 완주자의 경우: 01 - 1 = 0
         *   - 미완주자의 경우: "01" = 1
         */
        for (String player : completion) {
        	System.out.println("completion player: " + player + " / hm: " + (hm.get(player) - 1));
        	hm.put(player, hm.get(player) - 1);
        }

        /**
         * 4. 미완주자 체크 (key가 1인 경우)
         */
        for (String key : hm.keySet()) {
        	System.out.println("key: " + key + " / hm.get(key) : "  + hm.get(key));
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        System.out.println(answer);
        return answer;
    }
}