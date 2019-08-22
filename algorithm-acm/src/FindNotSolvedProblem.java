import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @GitHub : https://github.com/zacscoding
 */
public class FindNotSolvedProblem {

    static final Path SOURCE_PATH = new File("src").toPath();
    static PriorityQueue<String> NOT_SOLVED = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Find not solved problem.");
        check(SOURCE_PATH.toFile());

        while (!NOT_SOLVED.isEmpty()) {
            System.out.println(NOT_SOLVED.poll());
        }
    }

    public static void check(File dir) {
        if (!dir.isDirectory()) {
            throw new IllegalStateException(dir.getAbsolutePath() + " is not dir.");
        }

        File[] files = dir.listFiles();

        boolean foundFile = false;
        boolean solved = false;
        Queue<File> visits = new LinkedList<>();

        for (File file : files) {
            if ("..".contains(file.getName())) {
                continue;
            }

            if (file.isDirectory()) {
                visits.offer(file);
                continue;
            }

            if (!file.getName().endsWith("java")) {
                continue;
            }

            if (solved) {
                continue;
            }

            foundFile = true;

            if (file.getName().contains("Main")) {
                solved = true;
            }
        }

        if (foundFile && !solved) {
            NOT_SOLVED.offer("> " + SOURCE_PATH.relativize(dir.toPath()));
        }

        while (!visits.isEmpty()) {
            check(visits.poll());
        }
    }
}
