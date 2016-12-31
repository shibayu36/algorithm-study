import java.util.Arrays;

public class SuffixArray2 {
  public static Integer[] make(String text) {
    int n = text.length();
    Suffix[] suffixes = new Suffix[n];
    for (int i = 0; i < n; i++) {
      suffixes[i] = new Suffix(text, i);
    }
    Arrays.sort(suffixes);
    return Arrays.stream(suffixes).map(s -> s.index).toArray(size -> new Integer[size]);
  }
}