import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/20.
 */
public class Permutation3Test {
    @Test
    public void make() throws Exception {
        List<List<Integer>> result = Permutation3.make(Arrays.asList(1, 2, 3));
        System.out.println(result.toString());
    }

}