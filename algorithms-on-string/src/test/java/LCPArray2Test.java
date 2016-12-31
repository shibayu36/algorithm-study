import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LCPArray2Test {

  @Test
  public void make() throws Exception {
    List<Integer> suffixArray, lcpArray;
    suffixArray = SuffixArray1.make("");
    lcpArray = LCPArray2.make("", suffixArray);
    assertThat(lcpArray).isEqualTo(new ArrayList<>());

    suffixArray = SuffixArray1.make("abc");
    lcpArray = LCPArray2.make("abc", suffixArray);
    assertThat(lcpArray).isEqualTo(Arrays.asList(0, 0, 0));

    suffixArray = SuffixArray1.make("banana");
    lcpArray = LCPArray2.make("banana", suffixArray);
    assertThat(lcpArray).isEqualTo(Arrays.asList(1, 3, 0, 0, 2, 0));

    suffixArray = SuffixArray1.make("aaaa");
    lcpArray = LCPArray2.make("aaaa", suffixArray);
    assertThat(lcpArray).isEqualTo(Arrays.asList(1, 2, 3, 0));
  }

}
