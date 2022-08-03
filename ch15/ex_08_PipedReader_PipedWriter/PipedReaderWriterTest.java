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
	 * title : PipedReader, PipedWriter 수행 테스트
	 * 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받음
	 * 입출력을 마친 후에는 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힘
	 */
	
	@Test
	void PipedReaderWriterTest() {
		InputThread inThread   = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");
		
		// PipedReader와 PipedWriter를 연결한다.
		inThread.connect(outThread.getOutput());
		
		inThread.start();
		outThread.start();
	}
}
