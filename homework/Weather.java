// 날씨 뉴스 프로그램

import java.util.Scanner;

public class Weather {

	public static void main(String[] args) {
		Scanner shigh = new Scanner(System.in);
		System.out.print("최고 기온 : ");
		String high = shigh.next();
		Scanner slow = new Scanner(System.in);
		System.out.print("최저 기온 : ");
		String low = slow.next();
		Scanner sfineDust = new Scanner(System.in);
		System.out.print("미세먼지 농도 : ");
		String fineDust = sfineDust.next();
		Scanner sultraDust = new Scanner(System.in);
		System.out.print("초미세먼지 농도 : ");
		String ultraDust = sultraDust.next();
		
		System.out.print("오늘 최고 기온은 "+high+"℃이고 최저 기온은 " + low + "℃입니다. ");
		System.out.print("미세먼지 농도는 " + fineDust + "㎍/m^3이고, 초미세먼지 농도는 " + ultraDust + "㎍/m^3입니다.");
		
	}

}
