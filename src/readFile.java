import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readFile {
    public static void main(String[] args){
        String filename = args[0];
        System.out.println(filename);
        //File file = new File("test.txt");
        //for(String fileNames : file.list()) System.out.println(fileNames);
        File file = new File(filename);
        charbychar(file);
    }
//take7
    private static void charbychar(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            char current;
            while (in.available() > 0) {
                current = (char) in.read();
                //do something with the character
            }
        }
        catch (IOException error){
            error.printStackTrace();
        }
    }
}
