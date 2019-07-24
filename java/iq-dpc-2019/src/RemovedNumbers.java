import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        List<long[]> result = new ArrayList<>();
        long sum = n * (n + 1) / 2;
        for (long id1 = 2; id1 < n/2; id1++) {
            long id2 = (sum - id1) / (id1 + 1);
            if (id2 <= n && id1 * id2 == (sum - id1 - id2)) {
                result.add(new long[]{id1, id2});
            }
        }

        return result;
    }
}