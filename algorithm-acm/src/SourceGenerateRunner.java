import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

/**
 *
 */
public class SourceGenerateRunner {

    public static final String BASIC = "chap/basic";
    public static final String BRUTE_FORCE = BASIC + "/bruteforce";
    public static final String GREEDY = BASIC + "/greedy";
    public static final String TWO_POINT = BASIC + "/twopoint";
    public static final String DP = "chap08/dp";
    public static final String BITMASK = "chap16/bitmask";
    public static final String PARTIALSUM = "chap17/partialsum";
    public static final String QUEUESTACKDEQUE = "chap19/questackdeque";
    public static final String DISJOINTSET = "chap25/disjointset";
    public static final String GRAPH = "chap27/graph";

    public static void main(String[] args) {
        try {
            args = new String[] {
                    DISJOINTSET
                    , "1976"
            };

            if (args == null || args.length != 2) {
                printHelp();
                System.exit(1);
            }

            writeDefaultJavaFile(args);
        } catch (Exception e) {
            System.out.println("Failed to create file. reason : " + e.getMessage());
        }
    }

    private static void writeDefaultJavaFile(String[] args) throws Exception {
        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new Exception("Problem must be integer but \"" + args[1] + "\"");
        }
        String packageValue = args[0] + "/p" + args[1];
        System.out.println("## Try to create package " + packageValue);

        Path sourcePath = Paths.get("src");
        Path packagePath = sourcePath.resolve(packageValue);
        Path inoutPath = packagePath.resolve("inout.txt");

        // create package
        Files.createDirectories(packagePath, new FileAttribute[0]);

        // create inout.txt
        if (!Files.exists(inoutPath)) {
            Files.createFile(inoutPath);
        }

        // read default java
        File defaultSourceFile = new File("defaultMainReader.txt");
        File writeSourceFile = packagePath.resolve("Try1.java").toFile();
        writeSourceFile.createNewFile();
        System.out.println("## Try to write Try1 java file : " + writeSourceFile.getAbsolutePath());

        try (FileInputStream fis = new FileInputStream(defaultSourceFile);
             FileOutputStream fos = new FileOutputStream(writeSourceFile)) {

            StringBuilder sb = new StringBuilder();
            sb.append("package ")
              .append(packageValue.replace("/", "."))
              .append(";\n\n");

            int availableLen = fis.available();
            byte[] buf = new byte[availableLen];
            fis.read(buf);

            sb.append(new String(buf));

            String gitComment = "https://www.acmicpc.net/problem/";
            String source = sb.toString()
                              .replace(
                                      gitComment,
                                      gitComment + args[1]
                              );

            fos.write(source.getBytes());
        }
    }

    private static void printHelp() {
        System.out.println("-------------------------------------------------");
        System.out.println("java CommandLineRunner [package] [problem]");
        System.out.println("-------------------------------------------------");
        System.out.printf("e.g) java %s chap/basic/ 1023", SourceGenerateRunner.class.getSimpleName());
    }
}
