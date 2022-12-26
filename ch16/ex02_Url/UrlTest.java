package ch16.ex02_Url;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.assertj.core.api.Assertions.*;

public class UrlTest {
    @Test
    public void testUrl() throws IOException, URISyntaxException {
        //given
        URL url = new URL("http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1");
        //when
        String authority = url.getAuthority();
//        String content = (String) url.getContent();
        int defaultPort = url.getDefaultPort();
        int port = url.getPort();
        String file = url.getFile();
        String host = url.getHost();
        String path = url.getPath();
        String protocol = url.getProtocol();
        String query = url.getQuery();
        String ref = url.getRef();
        String userInfo = url.getUserInfo();
        String s = url.toExternalForm();
        URI uri = url.toURI();
        //then
        System.out.println(authority);
//        System.out.println(content);
        System.out.println(defaultPort);
        System.out.println(port);
        System.out.println(file);
        System.out.println(host);
        System.out.println(path);
        System.out.println(protocol);
        System.out.println(query);
        System.out.println(ref);
        System.out.println(userInfo);
        System.out.println(s);
        System.out.println(uri);
    }
}
