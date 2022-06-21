package calendar;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;

		else
			return false;
	}

	public int maxDateOfMonthByArray(int year, int month) {
		if (isLeapYear(year) == true) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
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

	public void printMonthDate(int year, int month, int weekDay) {

		int maxDay = maxDateOfMonthByArray(year, month);
		int div = 7 - weekDay;
		int count = div;

		if (div < 7) {

		} else if (div == 7) {
			div = 0;
		}

		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("=====================");

		for (int i = 0; i < weekDay; i++) // 공백이 나와야되는 만큼 공백 출력하는 코드
		{
			System.out.printf("   ");
		}

		for (int i = 1; i <= count; i++) // 공백이후에 나오는 첫번째줄 날짜
		{
			System.out.printf("%3d", i);
		}

		System.out.println();

		for (int i = count + 1; i < maxDay; i++) {
			System.out.printf("%3d", i);

			if (i % 7 == div) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();
	}
//	public void printMonthDate(int year, int month, String weekDay) {
//
//		int maxDay = maxDateOfMonthByArray(year, month);
//		String firstDate = weekDay;
//
//		int rep = 0;
//		int div = 0;
//
//		System.out.printf("     <<%4d년%3d월>>\n", year, month);
//		System.out.println(" SU MO TU WE TH FR SA");
//		System.out.println("=====================");
//
//		switch (firstDate) {
//
//		case "SU":
//			for (int i = 1; i <= maxDay; i++) {
//				if ((i % 7) == 0) {
//					System.out.println();
//				}
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//
//		case "MO":
//			rep = 1;
//			for (int j = 0; j < rep; j++) {
//				System.out.printf("   ");
//				div++;
//			}
//			for (int i = 1; i <= maxDay; i++) {
//				if ((div % 7) == 0) {
//					System.out.println();
//				}
//				div++;
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//
//		case "TU":
//			rep = 2;
//			for (int j = 0; j < rep; j++) {
//				System.out.printf("   ");
//				div++;
//			}
//			for (int i = 1; i <= maxDay; i++) {
//				if ((div % 7) == 0) {
//					System.out.println();
//				}
//				div++;
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//
//		case "WE":
//			rep = 3;
//			for (int j = 0; j < rep; j++) {
//				System.out.printf("   ");
//				div++;
//			}
//			for (int i = 1; i <= maxDay; i++) {
//				if ((div % 7) == 0) {
//					System.out.println();
//				}
//				div++;
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//
//		case "TH":
//			rep = 4;
//			for (int j = 0; j < rep; j++) {
//				System.out.printf("   ");
//				div++;
//			}
//			for (int i = 1; i <= maxDay; i++) {
//				if ((div % 7) == 0) {
//					System.out.println();
//				}
//				div++;
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//
//		case "FR":
//			rep = 5;
//			for (int j = 0; j < rep; j++) {
//				System.out.printf("   ");
//				div++;
//			}
//			for (int i = 1; i <= maxDay; i++) {
//				if ((div % 7) == 0) {
//					System.out.println();
//				}
//				div++;
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//
//		case "SA":
//			rep = 6;
//			for (int j = 0; j < rep; j++) {
//				System.out.printf("   ");
//				div++;
//			}
//			for (int i = 1; i <= maxDay; i++) {
//				if ((div % 7) == 0) {
//					System.out.println();
//				}
//				div++;
//				System.out.printf("%3d", i);
//			}
//			System.out.println();
//			break;
//		}
//
//	}
}