import static java.lang.System.currentTimeMillis;

import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class LCPArrayBenchmark {
  @Test
  public void make() throws Exception {
    List<Integer> suffixArray, lcpArray;
    String text = StringUtils.repeat("bananapanama", 10000);
    suffixArray = SuffixArray2.make(text);

    // warmup
    LCPArray1.make(text, suffixArray);
    LCPArray2.make(text, suffixArray);

    long begin = currentTimeMillis();
    LCPArray1.make(text, suffixArray);
    System.out.println("lcp array1: " + (currentTimeMillis() - begin));

    begin = currentTimeMillis();
    LCPArray2.make(text, suffixArray);
    System.out.println("lcp array2: " + (currentTimeMillis() - begin));

    text = RandomStringUtils.randomAlphabetic(100000);
    suffixArray = SuffixArray2.make(text);

    begin = currentTimeMillis();
    LCPArray1.make(text, suffixArray);
    System.out.println("lcp array1: " + (currentTimeMillis() - begin));

    begin = currentTimeMillis();
    LCPArray2.make(text, suffixArray);
    System.out.println("lcp array2: " + (currentTimeMillis() - begin));
  }
}
