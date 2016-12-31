import java.util.Arrays;
import java.util.List;

public class LCPArray2 {
  static int loopNum = 0;

  public static List<Integer> make(String string, List<Integer> suffixArray) {
    loopNum = 0;

    string += "\0"; // 番兵を入れておく

    // 文字の長さ順にLCPを計算できるように、
    // suffixArray内のどこに位置するか、
    // 文字列長さ順に並べた配列を用意する
    int size = suffixArray.size();
    Integer[] rank = new Integer[size];
    for (int i = 0; i < size; i++) {
      rank[suffixArray.get(i)] = i;
    }

    Integer[] lcpArray = new Integer[size];
    Arrays.fill(lcpArray, 0);
    int lcp = 0;
    for (int i = 0; i < size; i++) {
      // suffixArray中のindex番目のLCPを計算する
      int index = rank[i];
      int pos1 = suffixArray.get(index);
      // indexが最後なら、次の比較するものはないので、lcpは0で終わり
      if (index == size - 1) {
        lcpArray[index] = lcp = 0;
        continue;
      }

      int pos2 = suffixArray.get(index + 1);
      lcpArray[index] = lcp = calcLCP(string, pos1, pos2, lcp);

      // 次は一文字削ったものなので、lcpは1減らす
      lcp--;
      if (lcp <= 0) lcp = 0;
    }

    out.println("lcp array2 loop: " + loopNum);
    return Arrays.asList(lcpArray);
  }

  private static int calcLCP(String string, int pos1, int pos2, int lcp) {
    while (string.charAt(pos1 + lcp) == string.charAt(pos2 + lcp)) {
      lcp++;
      loopNum++;
    }
    return lcp;
  }
}
