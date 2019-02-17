import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Formatter {
    private boolean title = false;
    private XWPFDocument doc = new XWPFDocument();

    public void readfile(File file) throws IOException {
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        doc.getParagraphs();


//        String filedata;
//        char[] filechars;
//        try{
//            XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
//            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
//            filedata = extractor.getText();
//            filechars = filedata.toCharArray();
//            int length = filechars.length;
//            buildfile(filechars,length);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

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
