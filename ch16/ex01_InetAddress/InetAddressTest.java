package ch16.ex01_InetAddress;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

    @Test
    public void testGetHostName() throws UnknownHostException {
        //given
        InetAddress ip = InetAddress.getByName("www.naver.com");
        //when
        String actual = ip.getHostName();
        //then
        System.out.println(actual);
    }

    @Test
    public void testGetHostAddress() throws UnknownHostException {
        //given
        InetAddress ip = InetAddress.getByName("www.naver.com");
        //when
        String actual = ip.getHostAddress();
        //then
        System.out.println(actual);
    }

    @Test
    public void testToString() throws UnknownHostException {
        //given
        InetAddress ip = InetAddress.getByName("www.naver.com");
        //when
        String actual = ip.toString();
        //then
        System.out.println(actual);
    }

    @Test
    public void testGetAddress() throws UnknownHostException {
        //given
        InetAddress ip = InetAddress.getByName("www.naver.com");
        //when
        byte[] actual = ip.getAddress();
        //then
        System.out.println(Arrays.toString(actual));
    }

    @Test
    public void testGetAddress_whenByteIsNegative_thenPlus256() throws UnknownHostException {
        //given
        InetAddress ip = InetAddress.getByName("www.naver.com");
        //when
        byte[] bytes = ip.getAddress();
        String actual = "";
        for(byte b : bytes){
            actual += b < 0 ? b + 256 : b;
            actual += ".";
        }
        //then
        System.out.println(actual);
    }
    
    @Test
    public void testGetLocalHost() throws UnknownHostException {
        //given
        InetAddress ip = InetAddress.getLocalHost();
        //when
        String hostName = ip.getHostName();
        String hostAddress = ip.getHostAddress();
        //then
        System.out.println(hostName);
        System.out.println(hostAddress);
    }
    
    @Test
    public void testGetAllByName() throws UnknownHostException {
        //given
        InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
        //when
        Arrays.stream(ipArr).forEach(System.out::println);
        //then
    }

}
