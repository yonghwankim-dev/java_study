package ch09.ex02_String;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void equalsTest(){
        //given
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        //when
        boolean actual1 = str1 == str2;
        boolean actual2 = str3 == str4;
        boolean actual3 = str1.equals(str2);
        boolean actual4 = str3.equals(str4);
        //then
        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
        assertThat(actual3).isTrue();
        assertThat(actual4).isTrue();

    }

    @Test
    public void stringLterral(){
        //given
        String s1 = "AAA";
        String s2 = "AAA";
        String s3 = "AAA";
        String s4 = "BBB";
        //when

        //then
    }

    @Test
    public void zeroString(){
        //given
        char[] cArr = new char[0];   // char[] cArr = ();와 같다
        String s = new String(cArr); // String s = new String("")와 같다
        //when

        //then
    }

    @Test
    public void joinString(){
        //given
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        StringJoiner sj = new StringJoiner("/","[","]");
        //when
        String actual1 = String.join("-", arr);
        Arrays.stream(arr).forEach(sj::add);
        String actual2 = sj.toString();
        //then
        assertThat(actual1).isEqualTo("dog-cat-bear");
        assertThat(actual2).isEqualTo("[dog/cat/bear]");
    }
    
    @Test
    public void encodingString() throws UnsupportedEncodingException {
        //given
        String str = "가";
        byte[] bArr  = str.getBytes("UTF-8"); // 한글을 3byte로 표현
        byte[] bArr2 = str.getBytes("CP949"); // 한글을 2byte로 표현
        //when
        String actual1 = joinByteArr(bArr);
        String actual2 = joinByteArr(bArr2);
        String actual3 = new String(bArr, "UTF-8");
        String actual4 = new String(bArr2, "CP949");
        //then
        assertThat(actual1).isEqualTo("[EA:B0:80]");
        assertThat(actual2).isEqualTo("[B0:A1]");
        assertThat(actual3).isEqualTo("가");
        assertThat(actual4).isEqualTo("가");
    }

    private static String joinByteArr(byte[] bArr){
        StringJoiner sj = new StringJoiner(":","[","]");
        for(byte b : bArr){
            sj.add(String.format("%02X", b));
        }
        return sj.toString();
    }
    
    @Test
    public void valueOfString(){
        //given
        int iVal = 100;
        double dVal = 200.0;
        //when
        String strVal1 = String.valueOf(iVal);
        String strVal2 = dVal + "";

        //then
        assertThat(strVal1).isEqualTo("100");
        assertThat(strVal2).isEqualTo("200.0");

    }

    @Test
    public void subStringTest(){
        //given
        String fullName = "Hello.java";
        int index = fullName.indexOf("."); // 5
        //when
        String fileName = fullName.substring(0, index);
        String ext      = fullName.substring(index + 1);
        //then
        assertThat(fileName).isEqualTo("Hello");
        assertThat(ext).isEqualTo("java");
    }

    @Test
    public void stringBufferTest(){
        //given
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");
        //when
        boolean actual1 = sb1 == sb2;
        boolean actual2 = sb1.equals(sb2); // StringBuffer는 Object.equals를 오버라이딩하지 않아서 인스턴스 주소만 비교한다.
        boolean actual3 = sb1.toString().equals(sb2.toString());
        //then
        assertThat(actual1).isFalse();
        assertThat(actual2).isFalse();
        assertThat(actual3).isTrue();
    }

    @Test
    public void stringBufferMethodTest(){
        //given
        StringBuffer sb1 = new StringBuffer("01");
        StringBuffer sb2 = sb1.append(23);
        sb1.append(4).append(56);
        StringBuffer sb3 = sb1.append(78);
        sb3.append(9.0);
        //when
        String actual1 = sb1.toString();
        String actual2 = sb2.toString();
        String actual3 = sb3.toString();

        String actual4 = sb1.deleteCharAt(10).toString();
        String actual5 = sb1.delete(3,6).toString();
        String actual6 = sb1.insert(3,"abc").toString();
        String actual7 = sb1.replace(6, sb1.length(), "END").toString();
        int actual8    = sb1.capacity();
        int actual9    = sb1.length();
        //then
        assertThat(actual1).isEqualTo("0123456789.0");
        assertThat(actual2).isEqualTo("0123456789.0");
        assertThat(actual3).isEqualTo("0123456789.0");
        assertThat(actual4).isEqualTo("01234567890");
        assertThat(actual5).isEqualTo("01267890");
        assertThat(actual6).isEqualTo("012abc67890");
        assertThat(actual7).isEqualTo("012abcEND");
        assertThat(actual8).isEqualTo(18);
        assertThat(actual9).isEqualTo(9);
    }

    @Test
    public void stringBuilderMethodTest(){
        //given
        StringBuilder sb1 = new StringBuilder("01");
        StringBuilder sb2 = sb1.append(23);
        sb1.append(4).append(56);
        StringBuilder sb3 = sb1.append(78);
        sb3.append(9.0);
        //when
        String actual1 = sb1.toString();
        String actual2 = sb2.toString();
        String actual3 = sb3.toString();

        String actual4 = sb1.deleteCharAt(10).toString();
        String actual5 = sb1.delete(3,6).toString();
        String actual6 = sb1.insert(3,"abc").toString();
        String actual7 = sb1.replace(6, sb1.length(), "END").toString();
        int actual8    = sb1.capacity();
        int actual9    = sb1.length();
        //then
        assertThat(actual1).isEqualTo("0123456789.0");
        assertThat(actual2).isEqualTo("0123456789.0");
        assertThat(actual3).isEqualTo("0123456789.0");
        assertThat(actual4).isEqualTo("01234567890");
        assertThat(actual5).isEqualTo("01267890");
        assertThat(actual6).isEqualTo("012abc67890");
        assertThat(actual7).isEqualTo("012abcEND");
        assertThat(actual8).isEqualTo(18);
        assertThat(actual9).isEqualTo(9);
    }


}

