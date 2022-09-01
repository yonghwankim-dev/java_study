package ch11.ex10_HashMap;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class HashMapTest {
    @Test
    public void put() throws Exception{
        //given
        HashMap<String,String> map = new HashMap();
        //when
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        //then
        assertThat(map.get("a")).isEqualTo("1");
        assertThat(map.get("b")).isEqualTo("2");
        assertThat(map.get("c")).isEqualTo("3");
    }

    @Test
    public void containsKey() throws Exception{
        //given
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        //when
        boolean actual  = map.containsKey("a");
        boolean actual2 = map.containsValue("3");

        //then
        assertThat(actual).isTrue();
        assertThat(actual2).isTrue();
    }

    @Test
    public void keySet() throws Exception{
        //given
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        //when
        Set<String> set = map.keySet();
        //then
        assertThat(set).isEqualTo(new HashSet<>(Arrays.asList("a","b","c")));
    }

    @Test
    public void cloneTest() throws Exception{
        //given
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        //when
        HashMap<String,String> copy = (HashMap<String, String>) map.clone();
        copy.put("d","4");
        //then
        assertThat(map).isNotEqualTo(copy);
    }

    @Test
    public void replace() throws Exception{
        //given
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        //when
        map.replace("a","4");
        map.replace("b","2","5"); // key와 oldValue가 모두 동일해야만 변경됨
        //then
        assertThat(map.get("a")).isEqualTo("4");
        assertThat(map.get("b")).isEqualTo("5");
    }
    
    @Test
    public void remove() throws Exception{
        //given
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        //when
        String actual = map.remove("a");
        //then
        assertThat(actual).isEqualTo("1");
    }



}
