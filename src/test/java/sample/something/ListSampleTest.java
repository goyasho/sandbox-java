package sample.something;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import something.ListSample;

public class ListSampleTest {
  ListSample listSample;
  
  @BeforeEach
  void setup() {
    listSample = new ListSample();
  }
  
  @Nested
  class FlatMapDistinctLists {
    @Test
    public void 重複をがない場合結合して返す() {
      List<String> list1 = Arrays.asList("hoge", "fuga");
      List<String> list2 = Arrays.asList("piyo", "mogera");
      assertEquals(
          Arrays.asList("hoge", "fuga", "piyo", "mogera"),
          listSample.flatMapDistinctLists(list1, list2)
      );
    }
    
    @Test
    public void 重複を削除して結合して返す() {
      List<String> list1 = Arrays.asList("hoge", "fuga");
      List<String> list2 = Arrays.asList("piyo", "hoge");
      assertEquals(
          Arrays.asList("hoge", "fuga", "piyo"),
          listSample.flatMapDistinctLists(list1, list2)
      );
    }
    
    @Test
    public void 型は気にせずに結合して返す() {
      List<String> list1 = Arrays.asList("hoge", "fuga");
      List<String> list2 = Arrays.asList("piyo", "hoge");
      assertEquals(
          Arrays.asList("hoge", "fuga", "piyo"),
          listSample.flatMapDistinctLists(list1, list2)
      );
      
      List<Integer> intList1 = Arrays.asList(111);
      List<Integer> intList2 = Arrays.asList(222, 333, 444);
      List<Integer> intList3 = Arrays.asList(222, 444, 555);
      assertEquals(
          Arrays.asList(111, 222, 333, 444, 555),
          listSample.flatMapDistinctLists(intList1, intList2, intList3)
      );
    }
  }
  
  @Nested
  class CountNoDuplicate {
    @Test
    public void 重複をがない場合そのままの合計数を返す() {
      List<String> list1 = Arrays.asList("hoge", "fuga");
      List<String> list2 = Arrays.asList("piyo", "mogera");
      assertEquals(4, listSample.countNoDuplicate(list1, list2));
    }
    
    @Test
    public void 重複を除外して合計数を返す() {
      List<String> list1 = Arrays.asList("hoge", "fuga");
      List<String> list2 = Arrays.asList("piyo", "hoge");
      assertEquals(3, listSample.countNoDuplicate(list1, list2));
    }
    
    @Test
    public void 型は気にせずに件数を返す() {
      List<String> list1 = Arrays.asList("hoge", "fuga");
      List<String> list2 = Arrays.asList("piyo", "hoge");
      assertEquals(3, listSample.countNoDuplicate(list1, list2));
      
      List<Integer> intList1 = Arrays.asList(111);
      List<Integer> intList2 = Arrays.asList(222, 333, 444);
      List<Integer> intList3 = Arrays.asList(222, 444, 555);
      assertEquals(5, listSample.countNoDuplicate(intList1, intList2, intList3));
    }
  }
}
