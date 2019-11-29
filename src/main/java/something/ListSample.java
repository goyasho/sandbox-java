package something;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSample {
  /**
   * リストの重複をなくして結合する.
   *
   * @param lists
   * @return
   */
  public <T> List<T> flatMapDistinctLists(List<T>... lists) {
    return Stream.of(lists).flatMap(l -> l.stream()).distinct().collect(Collectors.toList());
  }
  
  /**
   * 重複なしでリスト同士の件数を返す.
   *
   * @param lists
   * @return
   */
  public <T> int countNoDuplicate(List<T>... lists) {
    return flatMapDistinctLists(lists).size();
  }
}
