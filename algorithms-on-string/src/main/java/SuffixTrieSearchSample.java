import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class SuffixTrieSearchSample {

  public static void main(String[] args) throws Exception {
    String text = "";

    // 指定のファイル URL のファイルをバイト列として読み込む
    try {
      byte[] fileContentBytes = Files.readAllBytes(Paths.get("./blog1.txt"));
      // 読み込んだバイト列を UTF-8 でデコードして文字列にする
      text = new String(fileContentBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {}

    searchAndPrint(text, "基礎技術");
    System.out.println("");
    searchAndPrint(text, "モチベーション");
  }

  private static void searchAndPrint(String text, String pattern) {
    List<Integer> positions = new SuffixTrie(text).searchPattern(pattern);
    positions.sort(Comparator.naturalOrder());
    for (int position : positions) {
      int begin = Math.max(0, position - 5);
      int end = Math.min(text.length(), position + pattern.length() + 5);
      System.out.println(text.substring(begin, end));
    }
  }
}
