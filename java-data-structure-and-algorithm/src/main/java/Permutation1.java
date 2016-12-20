import java.util.ArrayList;
import java.util.List;

/**
 * Created by shibayu36 on 2016/12/19.
 */

// とりあえずSystem.out.printlnするやつ
public class Permutation1 {
    public static void make(List<Integer> data) {
        List<Integer> candidate = new ArrayList<>(data);
        List<Integer> perm = new ArrayList<>();
        _make(candidate, perm);
    }

    private static void _make(List<Integer> candidate, List<Integer> perm) {
        if (candidate.size() == 0) {
            System.out.println(perm.toString());
        }

        for (int i = 0; i < candidate.size(); i++) {
            List<Integer> p = new ArrayList<>(perm);
            List<Integer> c = new ArrayList<>(candidate);
            p.add(c.get(i));
            c.remove(i);
            _make(c, p);
        }
    }
}
