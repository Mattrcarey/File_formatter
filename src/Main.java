import java.io.File;

public class Main {

    public static void main(String[] args){
        String filename = args[0];
        System.out.println(filename);
        //File file = new File("test.txt");
        //for(String fileNames : file.list()) System.out.println(fileNames);
        File file = new File(filename);
        Formatter formatter = new Formatter();
        formatter.readfile(file);
    }
}