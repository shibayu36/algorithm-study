import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LCPArray2Test {

  @Test
  public void make() throws Exception {
    List<Integer> suffixArray, lcpArray;
    suffixArray = SuffixArray.make("");
    lcpArray = new LCPArray2("", suffixArray).make();
    assertThat(lcpArray).isEqualTo(new ArrayList<>());

    suffixArray = SuffixArray.make("abc");
    lcpArray = new LCPArray2("abc", suffixArray).make();
    assertThat(lcpArray).isEqualTo(Arrays.asList(0, 0, 0));

    suffixArray = SuffixArray.make("banana");
    lcpArray = new LCPArray2("banana", suffixArray).make();
    assertThat(lcpArray).isEqualTo(Arrays.asList(1, 3, 0, 0, 2, 0));

    suffixArray = SuffixArray.make("aaaa");
    lcpArray = new LCPArray2("aaaa", suffixArray).make();
    assertThat(lcpArray).isEqualTo(Arrays.asList(1, 2, 3, 0));
  }

}