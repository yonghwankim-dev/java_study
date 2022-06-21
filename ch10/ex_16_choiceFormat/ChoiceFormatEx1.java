package ch10.ex_16_choiceFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 화면으로부터 날짜를 입력받아서 금일(today)과의 시간차이를 구하는 예제
 *
 */
public class ChoiceFormatEx1 {

	public static void main(String[] args) {
		double[] limits = {60, 70, 80, 90};	// 오름차순이어야 함
		// limits 배열과 grades간의 순서와 개수가 일치해야함
		String[] grades = {"D", "C", "B", "A"};
		
		int[] scores = {100, 95, 88, 70, 52, 60, 70};
		
		ChoiceFormat cf = new ChoiceFormat(limits, grades);
		
		for(int score : scores) {
			System.out.println(score + ":" + cf.format(score));
		}
	}

}
