package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);

		Calendar cal = new Calendar();
		int month = 0;
		int year = 0;

		while (true) {

			System.out.println("연도를 입력하세요: ");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			
			System.out.println("달을 입력세요: ");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			if (month == -1)
				break;
			if (month > 12)
				continue;

			cal.printMonthDate(year
					, month);
			//System.out.printf("%d의 마지막 일은 %d 입니다.\n", month, cal.maxDateOfMonth(month));
		}
		System.out.println("==================================================================");
	}

	public static void main(String[] args) {

		Prompt pmt = new Prompt();
		pmt.runPrompt();
	}

}
