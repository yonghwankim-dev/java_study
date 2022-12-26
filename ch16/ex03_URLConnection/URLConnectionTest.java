package ch16.ex03_URLConnection;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectionTest {
    @Test
    public void testURLConnection() throws IOException {
        //given
        String address = "http://www.codechobo.com/sample/hello.html";
        URLConnection conn = new URL(address).openConnection();
        //when
        String connToString = conn.toString();
        boolean allowUserInteraction = conn.getAllowUserInteraction();
        int connectTimeout = conn.getConnectTimeout();
//        String content = String.valueOf(conn.getContent());
        String contentEncoding = conn.getContentEncoding();
        String contentType = conn.getContentType();
        long date = conn.getDate();
        boolean defaultUseCaches = conn.getDefaultUseCaches();
        boolean doInput = conn.getDoInput();
        boolean doOutput = conn.getDoOutput();
        long expiration = conn.getExpiration();
        Map<String, List<String>> headerFields = conn.getHeaderFields();
        long ifModifiedSince = conn.getIfModifiedSince();
        long lastModified = conn.getLastModified();
        int readTimeout = conn.getReadTimeout();
        URL url = conn.getURL();
        boolean useCaches = conn.getUseCaches();
        //then
        System.out.println(connToString);
        System.out.println(allowUserInteraction);
        System.out.println(connectTimeout);
//        System.out.println(content);
        System.out.println(contentEncoding);
        System.out.println(contentType);
        System.out.println(date);
        System.out.println(defaultUseCaches);
        System.out.println(doInput);
        System.out.println(doOutput);
        System.out.println(expiration);
        System.out.println(headerFields);
        System.out.println(ifModifiedSince);
        System.out.println(lastModified);
        System.out.println(readTimeout);
        System.out.println(url);
        System.out.println(useCaches);
    }
}
