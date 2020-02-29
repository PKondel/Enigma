package file.utils;

import java.io.*;

public class FileTool {
    public static String getFileContent(String pathToFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file : " + pathToFile);
        } catch (IOException e) {
            System.out.println("Some problem with file ... : " + e);
        }
        return stringBuilder.toString();
    }

    public static void writeFileContent(String absolutePath, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePath))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Could not write in file " + absolutePath);
        }
    }
}
