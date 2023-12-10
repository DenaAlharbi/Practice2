import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {


        String FILE_NAME = "C:\\Users\\denaa\\JavaProjects231\\practice2\\src\\data.txt", FILE_NAME1 = "C:\\Users\\denaa\\JavaProjects231\\practice2\\src\\output.txt";
        ArrayList<String> lines = new ArrayList<>();
        Map<String, Integer> sortedMap = new TreeMap<>();

        try (Scanner input = new Scanner(new File(FILE_NAME))) {
            while (input.hasNext()) {
                String New = input.next();
                lines.add(New);
            }
            for (String line : lines)
                System.out.println(line);
        } catch (FileNotFoundException e) {
            System.err.format("File not found: %s%n", FILE_NAME);
        }
        for (String line : lines)
            sortedMap.put(line, sortedMap.getOrDefault(line,0)+1);
        PrintWriter write;
        try {
            new FileWriter(FILE_NAME1, false).close();
            write = new PrintWriter(new FileWriter(FILE_NAME1, true));
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                System.out.println(entry.getValue());
                write.print(entry.getKey()+"  ");
                write.println(entry.getValue());
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
