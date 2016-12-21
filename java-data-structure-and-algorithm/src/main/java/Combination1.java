import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shibayu36 on 2016/12/21.
 */
public class Combination1 {
    // 候補となるリストと、何個ピックアップするかを渡す
    public static List<List<Integer>> make (List<Integer> candidate, int r) {
        if (candidate.size() < r || candidate.size() <= 0 || r <= 0) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        List<List<Integer>> combination = new ArrayList<>();
        for (int i = 0; i <= candidate.size() - r; i++) {
            Integer picked = candidate.get(i);
            List<Integer> rest = new ArrayList<>(candidate);
            rest.subList(0, i + 1).clear();
            combination.addAll(make(rest, r - 1).stream().map(list -> {
                list.add(0, picked);
                return list;
            }).collect(Collectors.toList()));
        }
        return combination;
    }
}
