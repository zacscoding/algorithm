import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @GitHub : https://github.com/zacscoding
 */
public class SolutionAssert {

    public static final String BASIC = "chap/basic";
    public static final String BRUTE_FORCE = BASIC + "/bruteforce";
    public static final String DP = "chap08/dp";
    public static final String BITMASK = "chap16/bitmask";
    public static final String PARTIALSUM = "chap17/partialsum";
    public static final String QUEUESTACKDEQUE = "chap19/questackdeque";
    public static final String GRAPH = "chap27/graph";

    public static void main(String[] args) throws Exception {
        String pack = GRAPH + "/p" + 16929;
        String sourceName = "Try1.java";
        String inoutFileName = "inout.txt";

        String pathValue = "src/" + pack;
        checkProblem(pathValue, sourceName, inoutFileName);
        System.out.println(">>> Complete!");
    }

    static void checkProblem(String pathValue, String sourceName, String inoutFileName) throws Exception {
        System.out.printf(">> Start to assert. %s/%s with %s\n", pathValue, sourceName, inoutFileName);
        Path path = requireFileExist(Paths.get(pathValue));
        Path sourcePath = requireFileExist(path.resolve(sourceName));
        Path inoutPath = requireFileExist(path.resolve(inoutFileName));
        int dotIdx = sourceName.indexOf('.');
        String className = sourceName.substring(0, dotIdx);

        // read input/output
        ProblemContext ctx = convert(path, sourcePath, inoutPath);

        // settings in / out
        final PrintStream originOut = System.out;
        for (int i = 0; i < ctx.inputs.size(); i++) {
            String input = ctx.inputs.get(i);
            String expectedOutput = ctx.outputs.get(i);

            InputStream stream = new ByteArrayInputStream(input.getBytes());
            System.setIn(stream);
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
                System.setOut(ps);
                // invoke class
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                Class clazz = cl.loadClass(ctx.packageName + "." + className);
                Method mainMethod = clazz.getDeclaredMethod("main", String[].class);
                String[] p = null;
                mainMethod.invoke(null, (Object) p);
            } finally {
                System.setOut(originOut);
            }

            String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
            boolean result = assertOutput(expectedOutput, output);
            if (!result) {
                System.out.println("###### Found wrong output!");
                System.out.println(">> Inputs");
                System.out.println(input);
                System.out.println("-------------");
                System.out.println(">> Expected:");
                System.out.println(expectedOutput);
                System.out.println("-------------");
                System.out.println(">> Output:");
                System.out.println(output);
                System.out.println("#########################################################");
            }

        }
    }

    static ProblemContext convert(Path path, Path sourcePath, Path inoutPath) throws Exception {

        ProblemContext ctx = new ProblemContext();

        // read source code
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath.toFile()))) {
            StringBuilder builder = new StringBuilder();
            String readLine;

            while ((readLine = reader.readLine()) != null) {
                if (readLine.startsWith("package")) {
                    String packageName = readLine.substring("package ".length(), readLine.length() - 1);
                    ctx.packageName = packageName;
                    continue;
                }

                builder.append(readLine).append("\n");
            }

            ctx.sourceCode = builder.toString();
        }

        // read input output
        ctx.inputs = new ArrayList<>();
        ctx.outputs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inoutPath.toFile()))) {
            StringBuilder builder = new StringBuilder();
            String readLine;
            boolean isInput = true;

            while ((readLine = reader.readLine()) != null) {
                String trim = readLine.trim();

                if (trim.isEmpty()) {
                    continue;
                }

                if (trim.charAt(0) == '#') {
                    continue;
                }

                if (!trim.equals("---")) {
                    builder.append(readLine).append("\n");
                    continue;
                }

                if (isInput) {
                    ctx.inputs.add(builder.toString());
                } else {
                    ctx.outputs.add(builder.toString());
                }

                isInput = !isInput;
                builder.delete(0, builder.length());
            }

            if (builder.length() != 0) {
                if (isInput) {
                    ctx.inputs.add(builder.toString());
                } else {
                    ctx.outputs.add(builder.toString());
                }
            }

            ctx.sourceCode = builder.toString();
        }

        if (ctx.inputs.size() != ctx.outputs.size()) {
            throw new Exception("Different in/out size. input : " + ctx.inputs.size()
                                + ", output : " + ctx.outputs.size());
        }

        return ctx;
    }

    static Path requireFileExist(Path path) throws Exception {
        if (!Files.exists(path)) {
            throw new Exception(path + " is not exist.");
        }

        return path;
    }

    static boolean assertOutput(String expected, String output) {
        StringTokenizer expectedSt = new StringTokenizer(expected, "\n");
        StringTokenizer outputSt = new StringTokenizer(output, "\n");

        while (expectedSt.hasMoreTokens()) {
            String ex = expectedSt.nextToken().trim();

            if (ex.isEmpty()) {
                continue;
            }

            boolean success = false;

            while (outputSt.hasMoreTokens()) {
                String out = outputSt.nextToken().trim();
                if (out.isEmpty()) {
                    continue;
                }

                if (ex.equals(out)) {
                    success = true;
                    break;
                }

                break;
            }

            if (!success) {
                return false;
            }
        }

        while (outputSt.hasMoreTokens()) {
            String out = outputSt.nextToken().trim();
            if (!out.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    static class ProblemContext {
        List<String> inputs;
        List<String> outputs;
        String packageName;
        String sourceCode;
    }
}
