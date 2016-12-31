import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SuffixArray2 {
  public static List<Integer> make(String text) {
    int n = text.length();
    Suffix[] suffixes = new Suffix[n];
    for (int i = 0; i < n; i++) {
      suffixes[i] = new Suffix(text, i);
    }
    Arrays.sort(suffixes);
    return Arrays.stream(suffixes).map(s -> s.index).collect(Collectors.toList());
  }
}