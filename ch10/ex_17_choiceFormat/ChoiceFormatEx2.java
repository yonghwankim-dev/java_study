package ch10.ex_17_choiceFormat;

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
 * ChoiceFormat 인스턴스 생성시 생성자 인수로 pattern을 넣을 수 있음
 * # : 점수 포함
 * < : 점수 미포함
 * pattern 형식 : 점수(#|<)등급[|점수(#|<)등급|]...
 *
 */
public class ChoiceFormatEx2 {

	public static void main(String[] args) {
		String pattern = "60#D|70#C|80<B|90#A"; // 80->C, '<'은 정수를 포함시키지 않음
		int[] scores = {100, 95, 88, 70, 52, 60, 70};
		
		ChoiceFormat cf = new ChoiceFormat(pattern);
		
		for(int score : scores) {
			System.out.println(score + ":" + cf.format(score));
		}
		
		
		
	}

}
