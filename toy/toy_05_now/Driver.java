package toy.toy_05_now;

import java.time.LocalDateTime;

// title : now
// content : ���� ��¥(��,��,��,��,��,��)�� 1�� �������� �����

public class Driver {

	
	public static void main(String[] args) {
		Now now = new Now("yyyy�� MM�� dd�� EEEE hh�� mm�� ss��");
		
		NowThread t1 = new NowThread(now);
		
		t1.run();	// ex) 2022�� 01�� 10�� ������ 05�� 54�� 26��
	}

}
