import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuffixArray1 {
    public static Integer[] make(String string) {
        // 部分文字列とindexの集合を作る
        List<SuffixArrayItem> items = new ArrayList<>();
        for (int position = 0; position < string.length(); position++) {
            items.add(new SuffixArrayItem(position, string.substring(position)));
        }

        // 部分文字列でsortする
        items.sort( Comparator.comparing(SuffixArrayItem::getString) );

        // indexにmapして返す
        return items.stream().map(x -> x.getPosition()).toArray(size -> new Integer[size]);
    }
}

class SuffixArrayItem {
    private int position;
    private String string;

    public SuffixArrayItem(int position, String string) {
        this.position = position;
        this.string = string;
    }

    public int getPosition() {
        return this.position;
    }

    public String getString() {
        return this.string;
    }
}