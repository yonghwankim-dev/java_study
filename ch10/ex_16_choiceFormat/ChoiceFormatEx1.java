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
 * ȭ�����κ��� ��¥�� �Է¹޾Ƽ� ����(today)���� �ð����̸� ���ϴ� ����
 *
 */
public class ChoiceFormatEx1 {

	public static void main(String[] args) {
		double[] limits = {60, 70, 80, 90};	// ���������̾�� ��
		// limits �迭�� grades���� ������ ������ ��ġ�ؾ���
		String[] grades = {"D", "C", "B", "A"};
		
		int[] scores = {100, 95, 88, 70, 52, 60, 70};
		
		ChoiceFormat cf = new ChoiceFormat(limits, grades);
		
		for(int score : scores) {
			System.out.println(score + ":" + cf.format(score));
		}
	}

}
