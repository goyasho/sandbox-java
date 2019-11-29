package sample.version11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class NewFeaturesTest {
  @Test
  void var() {
    var str = "hoge";
    var list = new ArrayList<String>();
    assertTrue(str instanceof String);
    assertTrue(list instanceof ArrayList);
  }
  
  @Test
  void strintRepeat() {
    var str = "hoge".repeat(3);
    assertEquals("hogehogehoge", str);
  }
}
