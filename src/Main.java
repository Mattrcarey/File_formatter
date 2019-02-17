import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        String filename = args[0];
        File file = new File(filename);
        Formatter formatter = new Formatter();
        formatter.readfile(file, filename);
    }

}
