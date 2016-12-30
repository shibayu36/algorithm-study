import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LCPArray1Test {
  @Test
  public void make() throws Exception {
    List<Integer> suffixArray, lcpArray;
    suffixArray = SuffixArray.make("");
    lcpArray = new LCPArray1("", suffixArray).make();
    assertThat(lcpArray).isEqualTo(new ArrayList<>());

    suffixArray = SuffixArray.make("abc");
    lcpArray = new LCPArray1("abc", suffixArray).make();
    assertThat(lcpArray).isEqualTo(Arrays.asList(0, 0, 0));

    suffixArray = SuffixArray.make("banana");
    lcpArray = new LCPArray1("banana", suffixArray).make();
    assertThat(lcpArray).isEqualTo(Arrays.asList(1, 3, 0, 0, 2, 0));

    suffixArray = SuffixArray.make("aaaa");
    lcpArray = new LCPArray1("aaaa", suffixArray).make();
    assertThat(lcpArray).isEqualTo(Arrays.asList(1, 2, 3, 0));
  }
}
