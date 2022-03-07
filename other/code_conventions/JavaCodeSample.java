/**
 * Classname (Ŭ���� �̸�)
 * 
 * Version Information (���� ����)
 * 
 * Date (��¥)
 * 
 * Copyright Notice (���۱� ǥ��)
 */

// ��Ű�� ����
package other.code_conventions;

// import ����
import java.math.*;

/**
 * Class Description (Ŭ���� ����)
 * 
 * @author Firstname Lastname
 * @version 1.0.0
 */
public class JavaCodeSample {
	/* Ŭ���� ���� �ڸ�Ʈ �ּ� */
	// static ������ ���� ����Ǿ�� ��. ������ ������ ��� public -> protected -> default -> private ����
	/**
	 * classVariable1 documentation comment
	 */
	public static int classVariable1;
	
	protected static int classVariable2;	// or single line comment
	
	static int classVariable3;
	
	private static int classVariable4;
	
	/**
	 * InstanceVariable1 documentation comment
	 */
	public int instanceVariable1;
	
	protected int instanceVariable2;
	
	int instanceVariable3;
	
	private int instanceVariable4;

	/**
	 * ������ ���� �ڸ�Ʈ (Constructor documentation comment)
	 */
	public JavaCodeSample() {
		
	}
	
	/**
	 * �޼��� ���� �ڸ�Ʈ (Method documentation comment)
	 */
	public void method1() {
		// ������ (implementations)
	}
	
	/**
	 * �޼��� ���� �ڸ�Ʈ (Method documentation comment)
	 * 
	 * @param param1 description
	 * @param param2 description
	 */
	public void method2(int param1, Object param2) {
		// ������ (implementations)
	}
}
