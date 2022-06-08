package ch08.ex_20_tryWithResource;


/**
 * title : �ڵ� �ڿ� ��ȯ - try-catch-resources��
 * - jdk1.7���� ������
 * - ����°� ���õ� Ŭ������ �ٷ궧 ������
 * - try(){}���� ��ȣ�ȿ� ����� �ν��Ͻ��� �����ϸ� try ������ ������ �ڵ����� ������ �ν��Ͻ���
 * �ڿ��� ȸ����
 * - try-with-resources ���� ���� �ڵ����� ��ü�� close�� ȣ��� �� ��������
 * Ŭ������ AutoCloseable �������̽��� �����ؾ���
 * - ������ try-catch ������ ����ߴٸ� ���� �߻��� WorkException�� ���õǰ� ����������
 * �߻��� CloseException�� ���� ���븸 ��µ�
 *
 */
public class TryWithResourceTest {
	public static void main(String[] args) {
		// CloseableResource �ν��Ͻ��� try������ ����� ���� �ڿ������� (close)
		try(CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(false);
		} catch (WorkException e) {
			e.printStackTrace();
		}catch (CloseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		// �������
		// 1. CloseableResource �ν��Ͻ� ����
		// 2. throw new WorkException �߻�
		// 3. WorkException ����ó��
		// 4. try������ ���𳪼� CloseableResource �ڿ����� (close)
		// 5. CloseableResource.close ����
		// 6. throw new CloseException �߻�
		// 7. CloseException ����ó��
		try(CloseableResource cr = new CloseableResource()){
			cr.exceptionWork(true); // ���ܰ� �߻���
		}catch (WorkException e) {
			e.printStackTrace();
		}catch (CloseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class CloseableResource implements AutoCloseable{

	public void exceptionWork(boolean exception) throws WorkException {
		System.out.printf("exceptionWork(%b)�� ȣ���\n", exception);
		
		if(exception) {
			throw new WorkException("WorkException �߻�!!"); 
		}
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("close()�� ȣ���!");
		throw new CloseException("CloseException �߻�!");
	}
	
}

class WorkException extends Exception{
	public WorkException(String msg) {
		super(msg);
	}
}

class CloseException extends Exception{
	public CloseException(String msg) {
		super(msg);
	}
}