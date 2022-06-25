package calendar;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };

	public HashMap<Date, PlanItem> CalMap;

	public Calendar() {
		CalMap = new HashMap<Date, PlanItem>();

		File file = new File("/Users/chung-kibeom/file.txt");

		if (!file.exists())
			return;
		
		try {
			Scanner s = new Scanner(file);
		
			while(s.hasNext()) {
				String str = s.nextLine();
				String[] words = str.split(",");
				String date = words[0];
				String detail = words[1];
				PlanItem p = new PlanItem(date, detail);
				
				CalMap.put(p.getDate(), p);
				
				System.out.println(p.getDate());
			}
			
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public boolean isLeapYear(int year) { // 윤년 확인 메소드
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;

		else
			return false;
	}

	public int maxDateOfMonthByArray(int year, int month) {
		if (isLeapYear(year) == true) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
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

		int weekDay = getWeekDay(year, month, 1);
		int maxDay = maxDateOfMonthByArray(year, month);
		int div = 7 - weekDay;
		int count = div;

		if (div < 7) {

		} else if (div == 7) {
			div = 0;
		}

		System.out.printf("     <<%d년 %d월>>\n", year, month);
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

	public int getWeekDay(int year, int month, int day) {
		int sYear = 1970;
		int sMonth = 1;
		int sDay = 1;
		final int STANDARD_WEEKDAY = 4;
		// 기준 연도의 정보

		int count = 0; // 기준 날짜에서 내가 알고싶은 달이 얼마나 차이가 나는지 알아내는 변

		for (int i = sYear; i < year; i++) // 연도 차이가 얼마나 나는지
		{
			if (isLeapYear(i))
				count = count + 366;

			else
				count = count + 365;

		}

		for (int i = sMonth; i < month; i++) // 몇달이나 차이가 나는
		{
			count = count + maxDateOfMonthByArray(year, i);
		}

		count = count + day - sDay;

		int weekDay = (STANDARD_WEEKDAY + count) % 7;
		return weekDay;
	}

	public void registerCalendar(String strDate, String plan) {

		PlanItem pi = new PlanItem(strDate, plan);
		Date date = pi.getDate();

		CalMap.put(date, pi);

		if (CalMap.containsKey(date))
			System.out.println("일정이 등록되었습니다.");
		else
			System.out.println("등록실패");

		File file = new File("/Users/chung-kibeom/file.txt");

		if (!file.exists()) {
			System.out.println("file created!");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FileWriter fw;
		try {
			fw = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(pi.SaveToString());

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchCalendar(String strDate) throws ParseException {

		Date date = PlanItem.StringToDate(strDate);

		if (CalMap.containsKey(date)) {
			PlanItem planItem = CalMap.get(date);
			System.out.println("검색결과 찾음!");
			System.out.println(planItem.detail);
		}
	}
}