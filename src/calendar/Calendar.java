package calendar;

import java.util.Scanner;

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

	public void printMonthDate(int year, int month) {

		int maxDay = maxDateOfMonthByArray(year, month);

		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("=====================");

		for (int i = 1; i <= maxDay; i++) {
			if ((i % 7) == 0) {
				System.out.println();
			}
			System.out.printf("%3d", i);
		}

		System.out.println();

	}

}
