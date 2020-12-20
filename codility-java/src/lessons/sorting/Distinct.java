package lessons.sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        return set.size();
    }
}
