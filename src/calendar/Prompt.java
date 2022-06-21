package calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);

		Calendar cal = new Calendar();
		int month = 0;
		int year = 0;
		String weekDay = "";

		while (true) {

			System.out.println("연도를 입력하세요: ");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			
			System.out.println("달을 입력세요: ");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			
			System.out.println("첫째날 요일을 입력하세요: (SU, MO, WE, TH, FR, SA) ");
			System.out.print("WEEKDAY> ");
			weekDay = scanner.next();
			
			if (month == -1)
				break;
			if (month > 12)
				continue;

			cal.printMonthDate(year, month, weekDay);
			//System.out.printf("%d의 마지막 일은 %d 입니다.\n", month, cal.maxDateOfMonth(month));
		}
		System.out.println("==================================================================");
	}

	public static void main(String[] args) {

		Prompt pmt = new Prompt();
		pmt.runPrompt();
	}

}
