package ch16.ex04_URL_openStream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlOpenStreamTest {
    @Test
    public void testOpenStream() throws IOException {
        //given
        URL url = new URL("https://www.naver.com");
        //when
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        //then
        String line = "";
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

    }
}
