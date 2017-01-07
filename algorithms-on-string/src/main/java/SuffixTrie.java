import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// SuffixTrie st = new SuffixTrie(String text)
// st.search(String pattern) -> positionの配列が返るように
public class SuffixTrie {
  public String text;
  public SuffixTrieNode root;

  public SuffixTrie(String text) {
    this.text = text + "\0"; // マッチングしやすいように番兵を入れておく
    this.root = new SuffixTrieNode();
    for (int i = 0; i < this.text.length(); i++) {
      this.insertSuffix(new Suffix(this.text, i));
    }
  }

  // Suffix一つをTrie木に追加する
  private void insertSuffix(Suffix suffix) {
    // rootから辿りながらnodeを作成していく
    SuffixTrieNode node = this.root;
    for (int i = 0; i < suffix.length(); i++) {
      Character c = suffix.charAt(i);
      if (node.children.containsKey(c)) {
        node = node.children.get(c);
      }
      else {
        SuffixTrieNode newNode = new SuffixTrieNode();
        node.children.put(c, newNode);
        node = newNode;
      }
    }

    // 辿った最後にSuffixのpositionを入れておく
    node.position = suffix.index;
  }

  public List<Integer> searchPattern(String pattern) {
    SuffixTrieNode matched = this.searchNode(pattern);
    if (matched != null) {
      return matched.getAllLeafNodes().stream().map(
          node -> node.position
      ).collect(Collectors.toList());
    }
    else {
      return new ArrayList<>();
    }
  }

  private SuffixTrieNode searchNode(String pattern) {
    // patternを辿ったnodeを返す
    // nodeが見つからなければnull
    SuffixTrieNode node = this.root;
    for (int i = 0; i < pattern.length(); i++) {
      Character c = pattern.charAt(i);
      if (!node.children.containsKey(c)) {
        return null;
      }
      else {
        node = node.children.get(c);
      }
    }
    return node;
  }
}

class SuffixTrieNode {
  public int position; // どこからのsuffixの葉なのか
  public Map<Character, SuffixTrieNode> children = new TreeMap<>();

  public SuffixTrieNode() {}

  public boolean isLeaf() {
    return this.children.isEmpty();
  }

  public List<SuffixTrieNode> getAllLeafNodes() {
    if (this.isLeaf()) {
      List<SuffixTrieNode> nodes = new ArrayList<>();
      nodes.add(this);
      return nodes;
    }
    else {
      List<SuffixTrieNode> nodes = new ArrayList<>();
      for (SuffixTrieNode child : this.children.values()) {
        nodes.addAll(child.getAllLeafNodes());
      }
      return nodes;
    }
  }
}