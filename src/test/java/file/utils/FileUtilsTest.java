package file.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    private final int NUMBER_OF_FILE_LINES = 2;
    private final String PATH_TO_FILE = this.getClass().getResource("/fileUtils/test.txt").getPath();
    private final String FIRST_LINE = "Ala ma kota, kot ma Ale.";

    @Test
    protected void testIfNumberOfLineAreEquals() {
        System.out.println(PATH_TO_FILE);
        String fileContent = FileTool.getFileContent(PATH_TO_FILE);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(NUMBER_OF_FILE_LINES, split.length);
    }

    @Test
    protected void testFirstLinesAreEquals() {
        String fileContent = FileTool.getFileContent(PATH_TO_FILE);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(FIRST_LINE, split[0]);
    }

    @Test
    protected void howDoesSplitWorks() {
        String textToSplit = "ananas";
        String[] split = textToSplit.split("a");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(split.length);
    }
}
