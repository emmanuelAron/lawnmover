package lawnmover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/***
 * Read and stock the differents lines of the file
 */
public class Read {

    private static List<String> lines;
    private static String pathToFile = "file.txt";

    public static void main(String[] args) {
        lines = stockFile(pathToFile);
        for (String s : lines) {
            System.out.println(s);
        }
        System.out.println("grassSize: "+grassSize("file.txt"));
    }

    /***
     * Stock the different lines readed from the file in a list.
     * @param pathToFile pathToFile
     * @return lines
     */
    static List<String> stockFile(String pathToFile) {
        List<String> lines = null;
        try {
            lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception ex) {
            System.err.println("Error. " + ex.getMessage());
        }
        return lines;
    }

    /***
     * get the grass size
     * We add one , because we start at zero.
     * @param pathToFile
     * @return the grass size
     */
     static int grassSize(String pathToFile){
        return stockFile(pathToFile).size()+1;
    }
}