package ch11.ex03_stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class WebBrowserBackForwardTest {
    @Test
    public void test() throws Exception{
        WebBrowserBackForward.goURL("1. ����Ʈ");
        WebBrowserBackForward.goURL("2. ����");
        WebBrowserBackForward.goURL("3. ���̹�");
        WebBrowserBackForward.goURL("4. ����");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goBack();
        System.out.println("= �ڷ� ��ư�� ���� �� =");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goBack();
        System.out.println("= �ڷ� ��ư�� ���� �� =");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goForward();
        System.out.println("= ������ ��ư�� ���� �� =");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goURL("codechobo.com");
        System.out.println("= ���ο��ּҷ� �̵� �� =");
        WebBrowserBackForward.printStatus();
    }
}