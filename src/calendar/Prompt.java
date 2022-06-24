package calendar;

import java.util.Scanner;

public class Prompt {

	public int parseDay(String sWeekDay) {
		switch (sWeekDay) { // return 되는 값은 공백이 반복되는 횟수를 의

		case "SU":
			return 0;
		case "MO":
			return 1;
		case "TU":
			return 2;
		case "WE":
			return 3;
		case "TH":
			return 4;
		case "FR":
			return 5;
		case "SA":
			return 6;
		default:
			return 0;

		}
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);

		Calendar cal = new Calendar();
		int month = 0;
		int year = 0;

		while (true) {

			System.out.println("연도를 입력하세요: (-1은 종료)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();

			if (year == -1) {
				break;
			}

			System.out.println("달을 입력세요: ");
			System.out.print("MONTH> ");
			month = scanner.nextInt();

			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다!!");
			}

			cal.printMonthDate(year, month);
			// System.out.printf("%d의 마지막 일은 %d 입니다.\n", month, cal.maxDateOfMonth(month));
		}
		
		System.out.println("==================================================================");
	
		scanner.close();
	}

	public static void main(String[] args) {

		Prompt pmt = new Prompt();
		pmt.runPrompt();
	}

}
