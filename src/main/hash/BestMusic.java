package main.hash;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * [문제]
 * 	스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
 * 	노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 		- 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 		- 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 		- 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 
 * 	노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 * 	베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * [제한사항]
 * 	1. genres[i]는 고유번호가 i인 노래의 장르입니다.
 *  2. plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 *  3. genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 *  4. 장르 종류는 100개 미만입니다.
 *  5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 *  6. 모든 장르는 재생된 횟수가 다릅니다.
 */
public class BestMusic {
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"}; // 노래 장르
		int[] plays = {500, 600, 150, 800, 2500}; // 재생 횟수
		System.out.println(solutionResult(genres, plays)); // 알고리즘 해결
	}
	
	public static class Music implements Comparable<Music>{

	    private int played;
	    private int id;
	    private String genre;

	    public Music(String genre, int played, int id) {
	      this.genre = genre; 
	      this.played = played;
	      this.id = id;
	    }

	    @Override
	    public int compareTo(Music other) {
	      if(this.played == other.played) return this.id - other.id;
	      return other.played - this.played;
	    }

	    /**
	     * 장르 가져오기
	     * @return
	     */
	    public String getGenre() {return genre;}
	  }

	 public static String solutionResult(String[] genres, int[] plays) {
		 int[] a = solution(genres, plays);
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i<a.length; i++) {
			 sb.append(" no: " + a[i] + " / ");
		 }
		 return sb.toString();
	 }
	
	  public static int[] solution(String[] genres, int[] plays) {
		 /**
		  * 1. IntStream range 으로 반복 스트림 구현 (0부터 노래장르 개수만큼)
		  */
	    return IntStream.range(0, genres.length)
	    	/**
	    	 * 2. 해당 스트림을 그냥 스트림으로 변경 (Music 객체로 변경)
	    	 */
	    .mapToObj(i -> new Music(genres[i], plays[i], i))
	    	/**
	    	 * 3. 2번에서 변경된 Music 객체를 노래장르 별로 그룹핑
	    	 */
	    .collect(Collectors.groupingBy(Music::getGenre))
	    	/**
	    	 * 4. 그룹핑된 정보를 Map 형태로 변경
	    	 */
	    .entrySet().stream()
	    	/**
	    	 * 5. Map 형태로 변경된 Music 객체 정렬 연산 (재생횟수  - 노래장르 )
	    	 */
	    .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
	    	/**
	    	 * 6.
	    	 */
	    .flatMap(x->x.getValue().stream().sorted().limit(2))
	    	/**
	    	 * 7. Map 형태를 다시 Int 형태로 변경 
	    	 */
	    .mapToInt(x->x.id).toArray();
	  }

	  /**
	   * 재생횟수 총합
	   * @param value
	   * @return
	   */
	  private static int sum(List<Music> value) {
	    int answer = 0;
	    for (Music music : value) {
	      answer+=music.played;
	    }
	    return answer;
	  }
}
