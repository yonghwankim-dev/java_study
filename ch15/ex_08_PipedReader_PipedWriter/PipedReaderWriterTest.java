package ch15.ex_08_PipedReader_PipedWriter;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;




class InputThread extends Thread{
	PipedReader input = new PipedReader();
	StringWriter sw   = new StringWriter();
	
	public InputThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			int data = 0;
			while((data = input.read()) != -1) {
				sw.write(data);
			}
			System.out.println(getName() + " received : " + sw.toString());
		}catch (IOException e) {
		}
	}
	
	public PipedReader getInput() {
		return input;
	}
	
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		}catch (IOException e) {
		}
	}
}

class OutputThread extends Thread{
	PipedWriter output = new PipedWriter();
	
	public OutputThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			String msg = "Hello";
			System.out.println(getName() + " sent : " + msg);
			output.write(msg);
			output.close();
		}catch (IOException e) {
		}
	}
	
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
		}catch (IOException e) {

		}
	}
}

public class PipedReaderWriterTest {
	/**
	 * title : PipedReader, PipedWriter ���� �׽�Ʈ
	 * �Է°� ��½�Ʈ���� �ϳ��� ��Ʈ������ �����ؼ� �����͸� �ְ����
	 * ������� ��ģ �Ŀ��� ��� ���� ��Ʈ���� �ݾƵ� ������ ��Ʈ���� �ڵ����� ����
	 */
	
	@Test
	void PipedReaderWriterTest() {
		InputThread inThread   = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");
		
		// PipedReader�� PipedWriter�� �����Ѵ�.
		inThread.connect(outThread.getOutput());
		
		inThread.start();
		outThread.start();
	}
}
