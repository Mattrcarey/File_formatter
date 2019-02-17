import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;

public class Formatter {
    private boolean title = false;
    private XWPFDocument doc = new XWPFDocument();

    public void readfile(File file){
        String filedata;
        char[] filechars;
        try{
            XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            filedata = extractor.getText();
            filechars = filedata.toCharArray();
            int length = filechars.length;

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void buildfile(String[] chars, int length){
        for(int i = 0 ; i<length; i++){

        }

    }

    //private static void charbychar(File file) {
    //    try {
    //        FileInputStream in = new FileInputStream(file);
    //        char current;
    //        while (in.available() > 0) {
    //            current = (char) in.read();
    //            //do something with the character
    //        }
    //    }
    //    catch (IOException error){
    //        error.printStackTrace();
    //    }
    //}

    private static void analyzeString(String line){

    }
}
