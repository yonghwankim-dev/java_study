package ch16.ex05_URL_openStream_file;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLOpenStreamTest {
    @Test
    public void testOpenStream() throws IOException {
        //given
        int ch;
        URL url = new URL("https://www.naver.com");
        //when
        InputStream in = url.openStream();
        FileOutputStream out = new FileOutputStream("javajunsuk3_src.txt");

        while((ch = in.read()) != -1){
            out.write(ch);
        }
        in.close();
        out.close();
        //then
    }
}
