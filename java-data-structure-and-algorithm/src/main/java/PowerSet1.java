import java.util.ArrayList;
import java.util.List;

/**
 * Created by shibayu36 on 2016/12/22.
 */
public class PowerSet1 {
    public static List<List<Integer>> make(List<Integer> data) {
        if (data.size() == 0) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, data.size()); i++) {

            List<Integer> set = new ArrayList<>();
            int flags = i;
            for (int j = 0; j < data.size(); j++) {
                int flag = flags % 2;
                if (flag == 1) {
                    set.add(data.get(j));
                }
                flags = flags / 2;
            }
            result.add(set);
        }

        return result;
    }
}
