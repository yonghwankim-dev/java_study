package ch06.ex_30_constructorInit;

import java.util.Arrays;

/**
 * 생성자 초기화 예제
 * - 문서를 생성할때마다 이름을 지정해주지 않으면 일정한 규칙을 적용해서
 * 자동으로 이름을 결정함 (제목없음1, 제목없음2, ...)
 */
public class Document {
	static int count = 0;
	String name;	// 문서명
	
	public Document() {
		this("제목없음" + (++count));
	}
	
	public Document(String name){
		this.name = name;
		System.out.printf("문서 %s가 생성되었습니다.\n", name);
	}
	
	public static void main(String[] args)
	{
		Document d1 = new Document();
		Document d2 = new Document("자바.txt");
		Document d3 = new Document();
		Document d4 = new Document();
		
	}
}
