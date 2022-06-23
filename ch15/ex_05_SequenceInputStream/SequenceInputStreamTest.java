package ch15.ex_05_SequenceInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SequenceInputStreamTest {
	void printMethodName(String methodName) {
		System.out.println("==========" + methodName + "==========");
	}
	
	/**
	 * title : SequenceInputStream�� ����Ͽ� ���� ByteArrayInputStream�� �Ѱ��� ��Ʈ������ ����ϱ�
	 * SequenceInputStream ������
	 * SequenceInputStream(Enumeration e)                  : Enumeration�� ������ ������� �Է½�Ʈ���� �ϳ��� ��Ʈ������ ����
	 * SequenceInputStream(InputStream s1, InputStream s2) : �ΰ��� �Է½�Ʈ���� �ϳ��� ����
	 */
	@Order(1)
	@Test
	void sequenceInputStreamTest() {
		byte[] arr1   = {0, 1, 2};
		byte[] arr2   = {3, 4, 5};
		byte[] arr3   = {6, 7, 8};
		byte[] outSrc = null;
		
		Vector<InputStream> v = new Vector<InputStream>(); 
		v.add(new ByteArrayInputStream(arr1));
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));
		
		SequenceInputStream   input  = new SequenceInputStream(v.elements());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		
		try {
			while((data = input.read()) != -1) {
				output.write(data);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source1 : " + Arrays.toString(arr1));
		System.out.println("Input Source2 : " + Arrays.toString(arr2));
		System.out.println("Input Source3 : " + Arrays.toString(arr3));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
}
