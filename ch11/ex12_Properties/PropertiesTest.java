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
        properties.put("1", "�Ͽ�ȯ");
        properties.put("2", "�̿�ȯ");
        properties.put("3", "���ȯ");
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
    // ������ key�� value�� ��ȯ
    @Test
    public void getProperty() throws Exception{
        //given

        //when
        String name1 = properties.getProperty("1");
        String name2 = properties.getProperty("4", "���ȯ");
        
        //then
        assertThat(name1).isEqualTo("�Ͽ�ȯ");
        assertThat(name2).isEqualTo("���ȯ");
    }

    // void list(PrintStream out)
    // void list(PrintWrtier out)
    // ������ out�� ����� ����� ����Ѵ�.
    @Test
    public void list() throws Exception{
        //given

        //when
        properties.list(System.out);
        //then
    }

    // void load(InputStream inputStream) : ������ inputStream���κ��� ����� �о �����Ѵ�
    @Test
    public void load() throws Exception{
        //given
        FileInputStream fis = new FileInputStream("./src/ch11/ex12_Properties/note.txt");
        //when
        properties.load(new InputStreamReader(fis));
        properties.list(System.out);
        //then
    }

    // void storeToXML(OutputStream outputStream) : ����� ����� ������ ��� ��Ʈ���� XML������ ����Ѵ�.
    // void loadToXML(InputStream inputStream)    : ������ InputStream���κ��� XML ������ �о, XML ����
    // �� �о, XML ������ ����� ����� �о�� ��´�. (LOAD & STORE)
    @Test
    public void storeToXML_loadFromXml() throws Exception{
        //given
        FileOutputStream fos = new FileOutputStream("./src/ch11/ex12_Properties/note.xml");
        FileInputStream  fis = new FileInputStream("./src/ch11/ex12_Properties/note.xml");
        Properties properties2 = new Properties();
        //when
        properties.storeToXML(fos, "xml �׽�Ʈ", "UTF-8");
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

    // void store(OutputStream, String comment) : ������ ��½�Ʈ���� ������ ����� ����
    @Test
    public void store() throws Exception{
        //given
        FileOutputStream fos = new FileOutputStream("./src/ch11/ex12_Properties/note.xml");
        FileInputStream  fis = new FileInputStream("./src/ch11/ex12_Properties/note.xml");
        //when
        properties.store(fos, "store �׽�Ʈ");
        properties.load(fis);
        //then
        properties.list(System.out);
    }

    // Object setProperty(String key, String value) : key�� ���� value�� �߰���. ���� ���� Ű�� �����ϸ� ��ȯ��
    @Test
    public void setProperty() throws Exception{
        //given

        //when
        properties.setProperty("4","���ȯ");
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
