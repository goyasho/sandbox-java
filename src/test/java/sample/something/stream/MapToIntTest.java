package sample.something.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MapToIntTest {
  @Test
  public void 合計() {
    var nums = Arrays.asList("1", "100", "10");
    int sum = nums.stream().mapToInt(Integer::parseInt).sum();
    assertEquals(111, sum);
  }
  
  @Test
  public void 条件付き合計() {
    var nums = Arrays.asList("1", "100", "10");
    int sum = nums.stream().mapToInt(Integer::parseInt).filter(i -> i != 1).sum();
    assertEquals(110, sum);
  }
  
  @Test
  public void 最大() {
    var nums = Arrays.asList("1", "100", "10");
    int max = nums.stream().mapToInt(Integer::parseInt).max().orElse(0);
    assertEquals(100, max);
  }
  
  @Test
  public void 積() {
    var nums = Arrays.asList("1", "100", "10");
    int product = nums.stream().mapToInt(Integer::parseInt).reduce(1, ((left, right) -> left * right));
    assertEquals(1000 /* 1 * 10 * 1000 */, product);
  }
}
