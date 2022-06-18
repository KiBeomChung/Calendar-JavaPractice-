package calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("================");
//		System.out.println("1 2 3 4 5 6 7 ");
//		System.out.println("8 9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	
//		int n = 1;
//		
//		for(int j = 0;j < 4; j++)
//		{
//			for(int i = 0;i < 7; i++)
//			{
//				System.out.printf("%2d", n++);
//			}
//			System.out.println("");
//		}

	Scanner scanner = new Scanner(System.in);
	System.out.println("달을 입력세요: ");
	
	int month = scanner.nextInt();
	
	if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
	{
		System.out.println("31");
	}else if(month == 2)
	{
		System.out.println("28");	
	}else if(month == 4 || month == 6 || month == 9 || month ==11)
	{
		System.out.println("30");
	}
		
	}

}
