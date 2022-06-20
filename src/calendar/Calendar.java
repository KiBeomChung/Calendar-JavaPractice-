package calendar;

import java.util.Scanner;

public class Calendar {
	
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
	}
	
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

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		System.out.println("달을 입력세요: ");
		
		int month = scanner.nextInt();
		
		System.out.printf("%d의 마지막 일은 %d 입니다.", month, cal.maxDateOfMonth(month));
		
		cal.printMonthDate();
		
		scanner.close();
		
	}

}
