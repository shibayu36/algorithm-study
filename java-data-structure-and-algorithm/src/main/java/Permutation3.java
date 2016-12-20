import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shibayu36 on 2016/12/20.
 */
public class Permutation3 {
    public static List<List<Integer>> make(List<Integer> candidate) {
        if (candidate.size() == 0) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        return candidate.stream().flatMap(i -> {
            List<Integer> rest = new ArrayList<>(candidate);
            rest.remove(i);
            return make(rest).stream().map(list -> {
                list.add(0, i);
                return list;
            });
        }).collect(Collectors.toList());
    }
}
