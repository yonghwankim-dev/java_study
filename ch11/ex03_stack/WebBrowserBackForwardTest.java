package ch11.ex03_stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class WebBrowserBackForwardTest {
    @Test
    public void test() throws Exception{
        WebBrowserBackForward.goURL("1. 네이트");
        WebBrowserBackForward.goURL("2. 야후");
        WebBrowserBackForward.goURL("3. 네이버");
        WebBrowserBackForward.goURL("4. 다음");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goBack();
        System.out.println("= 뒤로 버튼을 누른 후 =");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goBack();
        System.out.println("= 뒤로 버튼을 누른 후 =");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goForward();
        System.out.println("= 앞으로 버튼을 누른 후 =");
        WebBrowserBackForward.printStatus();

        WebBrowserBackForward.goURL("codechobo.com");
        System.out.println("= 새로운주소로 이동 후 =");
        WebBrowserBackForward.printStatus();
    }
}