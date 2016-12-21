import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/21.
 */
public class Combination1Test {
    @Test
    public void make() throws Exception {
        List<List<Integer>> result = Combination1.make(Arrays.asList(1, 2, 3, 4), 3);
        System.out.println(result.toString());

        result = Combination1.make(Arrays.asList(1, 2, 3, 4), 1);
        System.out.println(result.toString());
    }
}