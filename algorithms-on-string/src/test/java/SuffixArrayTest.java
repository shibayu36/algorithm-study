import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class SuffixArrayTest {
    @Test
    public void make() throws Exception {
        List<Integer> suffixArray;
        suffixArray = SuffixArray.make("");
        assertThat(suffixArray).isEqualTo(new ArrayList<>());

        suffixArray = SuffixArray.make("abc");
        assertThat(suffixArray).isEqualTo(Arrays.asList(0, 1, 2));

        suffixArray = SuffixArray.make("banana");
        assertThat(suffixArray).isEqualTo(Arrays.asList(5, 3, 1, 0, 4, 2));
    }

}