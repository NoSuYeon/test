package main.hash;

/**
 * [문제]
 * 	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 		- 구조대 : 119
 * 		- 박준영 : 97 674 223
 * 		- 지영석 : 11 9552 4421
 * 	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
 * 	어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 
 * 	그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한 사항]
 * 	1. phone_book의 길이는 1 이상 1,000,000 이하입니다.
 *  2. 각 전화번호의 길이는 1 이상 20 이하입니다.
 */
public class TelBook {
	public static void main(String[] args) {
		System.out.println("오잇 ");
		String[] phone_book = {"119", "97674223", "1195524421"}; // 전화번호 부
		//String[] phone_book = {"123", "456", "789"}; // 전화번호 부
		//String[] phone_book = {"12","123","1235","567","88"}; // 전화번호 부
		solution(phone_book); // 알고리즘 해결
	}

	public static boolean solution(String[] phone_book) {
		/**
		 * 1. 첫번째 전화번호 추출 
		 */
        for(int i=0; i<phone_book.length-1; i++) {
        	System.out.println("phone_book i:" + phone_book[i]);
        	
        	/**
        	 * 2. 비교할 두번째 전화번호 추출 
        	 */
            for(int j=i+1; j<phone_book.length; j++) {
            	System.out.println("phone_book j:" + phone_book[j]);
            	/**
            	 * 3. 1번이 2번 전화번호의 접두사 인지 체크
            	 */
                if(phone_book[i].startsWith(phone_book[j])) {
                	return false;
                }
                /**
                 * 4. 2번이 1번 전화번호의 접두사 인지 체크 
                 */
                if(phone_book[j].startsWith(phone_book[i])) {
                	return false;
                }
            }
        }
        return true;
    }
}