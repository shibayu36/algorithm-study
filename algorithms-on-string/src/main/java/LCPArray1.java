import java.util.Arrays;
import java.util.List;

public class LCPArray1 {
  String string;
  List<Integer> suffixArray;

  public LCPArray1(String string, List<Integer> suffixArray) {
    this.string = string + "\0"; // 最後に番兵を置いておく
    this.suffixArray = suffixArray;
  }

  public List<Integer> make() {
    int size = this.suffixArray.size();
    Integer[] lcpArray = new Integer[size];
    Arrays.fill(lcpArray, 0);
    for (int i = 0; i < size - 1; i++) {
      lcpArray[i] = this.calcLCP(this.suffixArray.get(i), this.suffixArray.get(i + 1));
    }
    return Arrays.asList(lcpArray);
  }

  private int calcLCP(int pos1, int pos2) {
    int lcp = 0;
    while (this.string.charAt(pos1 + lcp) == this.string.charAt(pos2 + lcp)) {
      lcp++;
    }
    return lcp;
  }
}
