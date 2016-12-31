import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class SuffixArray1Test {
    @Test
    public void make() throws Exception {
        List<Integer> suffixArray;
        suffixArray = SuffixArray1.make("");
        assertThat(suffixArray).isEqualTo(new ArrayList<>());

        suffixArray = SuffixArray1.make("abc");
        assertThat(suffixArray).isEqualTo(Arrays.asList(0, 1, 2));

        suffixArray = SuffixArray1.make("banana");
        assertThat(suffixArray).isEqualTo(Arrays.asList(5, 3, 1, 0, 4, 2));
    }

}