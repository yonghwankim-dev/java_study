package ch11.ex12_Properties;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class PropertiesTest {

    private static Properties properties;

    @Before
    public void setup(){
        properties = new Properties();
        properties.put("1", "일용환");
        properties.put("2", "이용환");
        properties.put("3", "삼용환");
    }
    // Properties()
    // Properties(int initialCapacity)
    // Properties(Properties defaults)
    @Test
    public void properties() throws Exception{
        //given

        //when
        Properties properties1 = new Properties();
        Properties properties2 = new Properties(5);
        Properties properties3 = new Properties(properties1);
        //then
    }

    // String getProperty(String key)
    // String getProperty(String key, String defaultValue)
    // 지정된 key의 value를 반환
    @Test
    public void getProperty() throws Exception{
        //given

        //when
        String name1 = properties.getProperty("1");
        String name2 = properties.getProperty("4", "사용환");
        
        //then
        assertThat(name1).isEqualTo("일용환");
        assertThat(name2).isEqualTo("사용환");
    }

    // void list(PrintStream out)
    // void list(PrintWrtier out)
    // 지정된 out에 저장된 목록을 출력한다.
    @Test
    public void list() throws Exception{
        //given

        //when
        properties.list(System.out);
        //then
    }

    // void load(InputStream inputStream) : 지정된 inputStream으로부터 목록을 읽어서 저장한다
    @Test
    public void load() throws Exception{
        //given
        FileInputStream fis = new FileInputStream("./src/ch11/ex12_Properties/note.txt");
        //when
        properties.load(new InputStreamReader(fis));
        properties.list(System.out);
        //then
    }

    // void storeToXML(OutputStream outputStream) : 저장된 목록을 지정된 출력 스트림에 XML문서로 출력한다.
    // void loadToXML(InputStream inputStream)    : 지정된 InputStream으로부터 XML 문서를 읽어서, XML 문서
    // 를 읽어서, XML 문서에 저장된 목록을 읽어다 담는다. (LOAD & STORE)
    @Test
    public void storeToXML_loadFromXml() throws Exception{
        //given
        FileOutputStream fos = new FileOutputStream("./src/ch11/ex12_Properties/note.xml");
        FileInputStream  fis = new FileInputStream("./src/ch11/ex12_Properties/note.xml");
        Properties properties2 = new Properties();
        //when
        properties.storeToXML(fos, "xml 테스트", "UTF-8");
        properties2.loadFromXML(fis);
        //then
        properties2.list(System.out);
    }

    @Test
    public void propertyNames() throws Exception{
        //given
        StringBuilder sb = new StringBuilder();
        //when
        Enumeration<Integer> enumeration = (Enumeration<Integer>) properties.propertyNames();
        while(enumeration.hasMoreElements()){
            sb.append(enumeration.nextElement()+" ");
        }
        //then
        assertThat(sb.toString().trim()).isEqualTo("3 2 1");
    }

    // void store(OutputStream, String comment) : 지정된 출력스트림에 지정된 목록을 저장
    @Test
    public void store() throws Exception{
        //given
        FileOutputStream fos = new FileOutputStream("./src/ch11/ex12_Properties/note.xml");
        FileInputStream  fis = new FileInputStream("./src/ch11/ex12_Properties/note.xml");
        //when
        properties.store(fos, "store 테스트");
        properties.load(fis);
        //then
        properties.list(System.out);
    }

    // Object setProperty(String key, String value) : key에 따른 value를 추가함. 만약 기존 키가 존재하면 반환함
    @Test
    public void setProperty() throws Exception{
        //given

        //when
        properties.setProperty("4","사용환");
        //then
        properties.list(System.out);
        assertThat(properties.size()).isEqualTo(4);
    }

    @Test
    public void stringPropertyNames() throws Exception{
        //given

        //when
        Set<String> set = properties.stringPropertyNames();
        //then
        assertThat(set.toString()).isEqualTo("[1, 2, 3]");
    }



}
