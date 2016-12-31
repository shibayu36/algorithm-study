import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class SuffixArray2Test {

  @Test
  public void make() throws Exception {
    Integer[] suffixArray;
    suffixArray = SuffixArray2.make("");
    assertThat(suffixArray).isEqualTo(new Integer[0]);

    suffixArray = SuffixArray2.make("abc");
    assertThat(suffixArray).isEqualTo(new Integer[] { 0, 1, 2 });

    suffixArray = SuffixArray2.make("banana");
    assertThat(suffixArray).isEqualTo(new Integer[] { 5, 3, 1, 0, 4, 2 });
  }

}