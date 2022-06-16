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
 * ChoiceFormat �ν��Ͻ� ������ ������ �μ��� pattern�� ���� �� ����
 * # : ���� ����
 * < : ���� ������
 * pattern ���� : ����(#|<)���[|����(#|<)���|]...
 *
 */
public class ChoiceFormatEx2 {

	public static void main(String[] args) {
		String pattern = "60#D|70#C|80<B|90#A"; // 80->C, '<'�� ������ ���Խ�Ű�� ����
		int[] scores = {100, 95, 88, 70, 52, 60, 70};
		
		ChoiceFormat cf = new ChoiceFormat(pattern);
		
		for(int score : scores) {
			System.out.println(score + ":" + cf.format(score));
		}
		
		
		
	}

}
