package ch11.ex07_Comparator_Comparable;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ComparatorComparableTest {
    @Test
    public void comparator() throws Exception{
        //given
        String[] strArr1 = {"cat", "Dog", "lion", "tiger"};
        String[] strArr2 = {"cat", "Dog", "lion", "tiger"};
        String[] strArr3 = {"cat", "Dog", "lion", "tiger"};
        //when
        Arrays.sort(strArr1);
        Arrays.sort(strArr2, String.CASE_INSENSITIVE_ORDER); // 대소문자 무시
        Arrays.sort(strArr3, new Descending());
        //then
        assertThat(strArr1).isEqualTo(new String[]{"Dog", "cat", "lion", "tiger"});
        assertThat(strArr2).isEqualTo(new String[]{"cat", "Dog", "lion", "tiger"});
        assertThat(strArr3).isEqualTo(new String[]{"tiger", "lion", "cat", "Dog"});
    }
}
