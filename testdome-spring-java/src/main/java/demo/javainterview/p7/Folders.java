package demo.javainterview.p7;

import java.util.Collection;

/*
<?xml version="1.0" encoding="UTF-8"?>
<folder name="c">
    <folder name="program files">
        <folder name="uninstall information" />
    </folder>
    <folder name="users" />
</folder>
 */

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        for (int i = 0; i < xml.length(); i++) {
            char currentChar = xml.charAt(i);

        }

        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                "<folder name=\"program files\">" +
                "<folder name=\"uninstall information\" />" +
                "</folder>" +
                "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for (String name : names) { System.out.println(name); }
    }
}