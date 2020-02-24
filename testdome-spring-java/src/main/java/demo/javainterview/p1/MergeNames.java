package demo.javainterview.p1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://www.testdome.com/d/java-interview-questions/4
 */
public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        if (names1 == null) {
            return names2;
        }

        if (names2 == null) {
            return names1;
        }

        Set<String> uniqueNameSet = new LinkedHashSet<>(Arrays.asList(names1));
        uniqueNameSet.addAll(Arrays.asList(names2));

        if (uniqueNameSet.isEmpty()) {
            return new String[0];
        }

        String[] ret = new String[uniqueNameSet.size()];
        uniqueNameSet.toArray(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
        String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
        // should print Ava, Emma, Olivia, Sophia
        System.out.println(String.join(", ", MergeNames
                .uniqueNames(names1, names2)));
    }
}
