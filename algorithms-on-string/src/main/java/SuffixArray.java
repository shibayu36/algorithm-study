import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SuffixArray {

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

class Suffix implements Comparable<Suffix> {
    public String text;
    public int index;

    public Suffix(String text, int index) {
        this.text = text;
        this.index = index;
    }
    public int length() {
        return text.length() - index;
    }
    public char charAt(int i) {
        return text.charAt(index + i);
    }

    public int compareTo(Suffix that) {
        if (this == that) return 0;  // optimization
        int n = Math.min(this.length(), that.length());
        for (int i = 0; i < n; i++) {
            if (this.charAt(i) < that.charAt(i)) return -1;
            if (this.charAt(i) > that.charAt(i)) return +1;
        }
        return this.length() - that.length();
    }
}