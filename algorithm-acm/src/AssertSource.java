import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import chap.basic.TempTry;

/**
 *
 * @GitHub : https://github.com/zacscoding
 */
public class AssertSource {

    public static void main(String[] args) throws Exception {
        String pathValue = "src/chap/basic";
        String sourceName = "TempTry.java";
        String inoutFileName = "inout.txt";

        checkProblem(pathValue, sourceName, inoutFileName);
    }

    static void checkProblem(String pathValue, String sourceName, String inoutFileName) throws Exception {
        Path path = requireFileExist(Paths.get(pathValue));
        Path sourcePath = requireFileExist(path.resolve(sourceName));
        Path inoutPath = requireFileExist(path.resolve(inoutFileName));
        int dotIdx = sourceName.indexOf('.');
        String className = sourceName.substring(0, dotIdx);

        // read input/output
        ProblemContext ctx = convert(path, sourcePath, inoutPath);

        // load class
        URL url = sourcePath.toFile().toURL();
        URL[] urls = new URL[] { url };

        ClassLoader cl = new URLClassLoader(urls);
        Class clazz = cl.loadClass(ctx.packageName + "." + className);

        Method mainMethod = clazz.getDeclaredMethod("main", String[].class);

        String data = "3\n"
                      + "1 2\n"
                      + "1 5\n"
                      + "3 3";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);

        mainMethod.invoke(null, null);
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

        return ctx;
    }

    static Path requireFileExist(Path path) throws Exception {
        if (!Files.exists(path)) {
            throw new Exception(path + " is not exist.");
        }

        return path;
    }

    static class ProblemContext {
        List<String> inputs;
        List<String> outputs;
        String packageName;
        String sourceCode;
    }
}
