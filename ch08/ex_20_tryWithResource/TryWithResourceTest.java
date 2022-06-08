package ch08.ex_20_tryWithResource;


/**
 * title : 자동 자원 반환 - try-catch-resources문
 * - jdk1.7부터 지원됨
 * - 입출력과 관련된 클래스를 다룰때 유용함
 * - try(){}에서 괄호안에 사용할 인스턴스를 정의하면 try 구문이 끝나면 자동으로 생성한 인스턴스의
 * 자원을 회수함
 * - try-with-resources 문에 의해 자동으로 객체의 close가 호출될 수 있으려면
 * 클래스가 AutoCloseable 인터페이스를 구현해야함
 * - 기존의 try-catch 구문을 사용했다면 먼저 발생한 WorkException은 무시되고 마지막으로
 * 발생한 CloseException에 대한 내용만 출력됨
 *
 */
public class TryWithResourceTest {
	public static void main(String[] args) {
		// CloseableResource 인스턴스는 try구문을 벗어나는 순간 자원해제됨 (close)
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
		
		// 수행순서
		// 1. CloseableResource 인스턴스 생성
		// 2. throw new WorkException 발생
		// 3. WorkException 예외처리
		// 4. try구문을 벗언나서 CloseableResource 자원해제 (close)
		// 5. CloseableResource.close 수행
		// 6. throw new CloseException 발생
		// 7. CloseException 예외처리
		try(CloseableResource cr = new CloseableResource()){
			cr.exceptionWork(true); // 예외가 발생됨
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
		System.out.printf("exceptionWork(%b)가 호출됨\n", exception);
		
		if(exception) {
			throw new WorkException("WorkException 발생!!"); 
		}
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("close()가 호출됨!");
		throw new CloseException("CloseException 발생!");
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