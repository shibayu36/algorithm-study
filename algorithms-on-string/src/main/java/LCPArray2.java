import java.util.Arrays;
import java.util.List;

public class LCPArray2 {
  String string;
  List<Integer> suffixArray;

  public LCPArray2(String string, List<Integer> suffixArray) {
    this.string = string + "\0"; // 最後に番兵を置いておく
    this.suffixArray = suffixArray;
  }

  public List<Integer> make() {
    List<Integer> suffixArray = this.suffixArray;
    int size = suffixArray.size();

    Integer[] rank = new Integer[size];
    for (int i = 0; i < size; i++) {
      rank[suffixArray.get(i)] = i;
    }

    Integer[] lcpArray = new Integer[size];
    Arrays.fill(lcpArray, 0);
    int lcp = 0;
    for (int i = 0; i < size; i++) {
      int index = rank[i];
      int pos1 = suffixArray.get(index);
      if (index == size - 1) {
        lcpArray[index] = lcp = 0;
        continue;
      }

      int pos2 = suffixArray.get(index + 1);
      lcpArray[index] = lcp = this.calcLCP(pos1, pos2, lcp);
      lcp--;
      if (lcp <= 0) lcp = 0;
    }
    return Arrays.asList(lcpArray);
  }

  private int calcLCP(int pos1, int pos2, int lcp) {
    while (this.string.charAt(pos1 + lcp) == this.string.charAt(pos2 + lcp)) {
      lcp++;
    }
    return lcp;
  }
}
