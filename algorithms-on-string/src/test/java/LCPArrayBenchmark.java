import static java.lang.System.currentTimeMillis;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class LCPArrayBenchmark {
  @Test
  public void make() throws Exception {
    long begin;
    Integer[] suffixArray, lcpArray;
    String text = StringUtils.repeat("bananapanama", 1000);
    suffixArray = SuffixArray2.make(text);

    // warmup
    LCPArray1.make(text, suffixArray);
    LCPArray2.make(text, suffixArray);

    System.out.println("---- bananapanama ----");
    begin = currentTimeMillis();
    lcpArray = LCPArray1.make(text, suffixArray);
    System.out.println("lcp array1: " + (currentTimeMillis() - begin) + "ms");

    begin = currentTimeMillis();
    lcpArray = LCPArray2.make(text, suffixArray);
    System.out.println("lcp array2: " + (currentTimeMillis() - begin) + "ms");

    System.out.println("---- random ----");
    text = RandomStringUtils.randomAlphabetic(100000);
    suffixArray = SuffixArray2.make(text);

    begin = currentTimeMillis();
    lcpArray = LCPArray1.make(text, suffixArray);
    System.out.println("lcp array1: " + (currentTimeMillis() - begin) + "ms");

    begin = currentTimeMillis();
    lcpArray = LCPArray2.make(text, suffixArray);
    System.out.println("lcp array2: " + (currentTimeMillis() - begin) + "ms");

    // 指定のファイル URL のファイルをバイト列として読み込む
    // sample.txtにhttps://ja.wikipedia.org/wiki/%E6%94%BF%E6%95%99%E5%88%86%E9%9B%A2%E3%81%AE%E6%AD%B4%E5%8F%B2 がコピペされているとする
    try {
      byte[] fileContentBytes = Files.readAllBytes(Paths.get("./sample.txt"));
// 読み込んだバイト列を UTF-8 でデコードして文字列にする
      text = new String(fileContentBytes, StandardCharsets.UTF_8);
    }
    catch (Exception e) {}
    suffixArray = SuffixArray2.make(text);

    System.out.println("---- Wikipedia ----");
    begin = currentTimeMillis();
    lcpArray = LCPArray1.make(text, suffixArray);
    System.out.println("lcp array1: " + (currentTimeMillis() - begin) + "ms");

    begin = currentTimeMillis();
    lcpArray = LCPArray2.make(text, suffixArray);
    System.out.println("lcp array2: " + (currentTimeMillis() - begin) + "ms");

    text = text + text;
    suffixArray = SuffixArray2.make(text);

    System.out.println("---- Wikipedia x 2 ----");
    begin = currentTimeMillis();
    lcpArray = LCPArray1.make(text, suffixArray);
    System.out.println("lcp array1: " + (currentTimeMillis() - begin) + "ms");

    System.out.println("---------------");
    begin = currentTimeMillis();
    lcpArray = LCPArray2.make(text, suffixArray);
    System.out.println("lcp array2: " + (currentTimeMillis() - begin) + "ms");
  }
}
