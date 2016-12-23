import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/22.
 */
public class PowerSet1Test {
    @Test
    public void make() throws Exception {
        List<List<Integer>> result = PowerSet1.make(Arrays.asList());
        System.out.println(result.toString());

        result = PowerSet1.make(Arrays.asList(1, 2, 3));
        System.out.println(result.toString());
    }

}