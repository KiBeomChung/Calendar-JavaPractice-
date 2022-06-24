package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록  ");
		System.out.println("| 2. 일정 검색  ");
		System.out.println("| 3. 달력 보기  ");
		System.out.println("| h. 도움말 q. 종료  ");
		System.out.println("+----------------------+");
	}

	public void calCalendar(Scanner s, Calendar c) {

		int month = 0;
		int year = 0;

		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.print("MONTH> ");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다!!");
			return;
		}

		c.printMonthDate(year, month);
	}

	public void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.printf("> ");
		String date = s.next();

		System.out.println("일정을 입력하세요.");
		System.out.printf("> ");
		String plan = s.next();

		c.registerCalendar(date, plan);
	}

	public void searchPlan(Scanner s, Calendar c) throws ParseException {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.printf("> ");
		String date = s.next();
		
		c.searchCalendar(date);
	}

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

	public void runPrompt() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		Calendar cal = new Calendar();
		boolean end = true;

		printMenu();

		while (end) {

			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.printf("> ");

			String cmd = scanner.next();

			switch (cmd) {

			case "1":
				cmdRegister(scanner, cal);
				break;

			case "2":
				searchPlan(scanner, cal);
				break;

			case "3":
				calCalendar(scanner, cal);
				break;

			case "h":
				printMenu();
				break;

			case "q":
				end = false;
				break;
			}
			// System.out.printf("%d의 마지막 일은 %d 입니다.\n", month, cal.maxDateOfMonth(month));
		}
		System.out.println("Thank You, Bye~");
		// scanner.close();
	}

	public static void main(String[] args) throws ParseException {

		Prompt pmt = new Prompt();
		pmt.runPrompt();
	}

}
