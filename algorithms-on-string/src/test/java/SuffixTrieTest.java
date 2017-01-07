import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

public class SuffixTrieTest {

  @Test
  public void testBuildSuffixTrie() throws Exception {
    SuffixTrie st = new SuffixTrie("banana");
//    System.out.println(st.root.children.toString());
//    System.out.println(st.root.children.get('a').children.toString());
    printSuffixTrieNode(st.root, "");
    System.out.println(st.root.getAllLeafNodes().stream().map(n -> n.position).collect(Collectors.toList()));
  }

  @Test
  public void testSearchPattern() throws Exception {
    SuffixTrie st = new SuffixTrie("banana");
    List<Integer> positions;

    positions = st.searchPattern("a");
    assertThat(positions).containsExactlyInAnyOrder(1, 3, 5);

    positions = st.searchPattern("na");
    assertThat(positions).containsExactlyInAnyOrder(2, 4);

    positions = st.searchPattern("ana");
    assertThat(positions).containsExactlyInAnyOrder(1, 3);

    positions = st.searchPattern("banana");
    assertThat(positions).containsExactlyInAnyOrder(0);

    positions = st.searchPattern("bananana");
    assertThat(positions).isEmpty();
  }

  // SuffixTrieNodeを深さ優先でprintしていく関数
  public void printSuffixTrieNode(SuffixTrieNode node, String prefix) {

    for (Map.Entry<Character, SuffixTrieNode> entry : node.children.entrySet()) {
      System.out.print(prefix + entry.getKey());
      if (entry.getValue().isLeaf()) {
        System.out.print("(" + entry.getValue().position + ")");
      }
      System.out.println("");

      printSuffixTrieNode(entry.getValue(), prefix + "    ");
    }
  }
}