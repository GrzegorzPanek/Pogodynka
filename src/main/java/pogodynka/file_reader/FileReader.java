package pogodynka.file_reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    public String readKeyFromFile() {
        String key = null;
        try {
            java.io.FileReader fileReader = new java.io.FileReader("myKey.txt");
            Scanner scanner = new Scanner(fileReader);
            key = scanner.nextLine();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }
}


