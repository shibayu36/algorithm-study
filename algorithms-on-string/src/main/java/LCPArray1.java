import java.util.Arrays;
import java.util.List;

// O(n^2) algorithm
public class LCPArray1 {
  static int loopNum = 0;

  public static List<Integer> make(String string, List<Integer> suffixArray) {
    loopNum = 0;
    string += "\0"; // 番兵を入れておく

    int size = suffixArray.size();
    Integer[] lcpArray = new Integer[size];
    Arrays.fill(lcpArray, 0);
    for (int i = 0; i < size - 1; i++) {
      lcpArray[i] = calcLCP(string, suffixArray.get(i), suffixArray.get(i + 1));
    }

    System.out.println("lcp array1 loop: " + loopNum);

    return Arrays.asList(lcpArray);
  }

  private static int calcLCP(String string, int pos1, int pos2) {
    int lcp = 0;
    while (string.charAt(pos1 + lcp) == string.charAt(pos2 + lcp)) {
      lcp++;
      loopNum++;
    }
    return lcp;
  }
}
