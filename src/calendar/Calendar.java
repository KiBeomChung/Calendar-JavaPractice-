package calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };

	public int maxDateOfMonthByArray(int month) {
		return MAX_DAYS[month - 1];
	} // 배열을 이용한 달력의 마지막 날 구하기!

	public int maxDateOfMonth(int month) {

		int maxDate = 0;

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			maxDate = 31;
		}

		else if (month == 2) {
			maxDate = 28;
		}

		else if (month == 4 || month == 6 || month == 9 || month == 11) {
			maxDate = 30;
		}
		return maxDate;
	} // 조건문을 이용한 마지막 날 구하기!

	public void printMonthDate() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("================");
		System.out.println("1 2 3 4 5 6 7 ");
		System.out.println("8 9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String PROMPT = "cal> ";
		
		Scanner scanner = new Scanner(System.in);

		Calendar cal = new Calendar();
		int month = 0;

		while(true) {

			System.out.println("달을 입력세요: ");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if(month == -1)	break;
			if(month > 12)	continue;
			
			System.out.printf("%d의 마지막 일은 %d 입니다.\n", month, cal.maxDateOfMonth(month));
		}
		
		System.out.println("==================================================================");

		//cal.printMonthDate();

		scanner.close();

	}

}
