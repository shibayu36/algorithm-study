import java.util.ArrayList;
import java.util.List;

/**
 * Created by shibayu36 on 2016/12/20.
 */
public class Permutation2 {
    public static List<List<Integer>> make(List<Integer> data) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>(data);
        List<Integer> perm = new ArrayList<>();
        return _make(result, candidate, perm);
    }

    private static List<List<Integer>> _make(List<List<Integer>> result, List<Integer> candidate, List<Integer> perm) {
        if (candidate.size() == 0) {
            result.add(perm);
        }
        else {
            for (int i = 0; i < candidate.size(); i++) {
                List<Integer> p = new ArrayList<>(perm);
                List<Integer> c = new ArrayList<>(candidate);
                p.add(c.get(i));
                c.remove(i);
                _make(result, c, p);
            }
        }

        return result;
    }
}
