import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Formatter {
    private boolean title = false;
    public XWPFDocument newfile;// = new XWPFDocument();

    public void readfile(File file) throws IOException {
        newfile = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new File("test2.docx"));
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        List<XWPFParagraph> paragraphs = doc.getParagraphs();
        Iterator<IBodyElement> iter = doc.getBodyElementsIterator();
        List<String[]> vararray = new ArrayList<>();
        //while(iter.hasNext()){
            IBodyElement elem = iter.next();
            for(XWPFParagraph para : paragraphs){
                analyzeParagraph(para);
                //System.out.println(para.getText());
                //for(XWPFRun run : para.getRuns()) {
                //    analyzeRun(run);
                //}
            }
            newfile.write(out);
            out.close();
        //}
    }

    public void analyzeParagraph(XWPFParagraph paragraph){
        XWPFParagraph paragraph1 = newfile.createParagraph();
        if(paragraph.getRuns().size()==1){
            if(!title){
                FormattedString title = new Title(paragraph.getText(),paragraph1);
                title.print();
            }
            else{
                FormattedString header = new Header(paragraph.getText(),paragraph1);
                header.print();
            }
        }
        else {
            for (XWPFRun run : paragraph.getRuns()) {
                analyzeRun(run, paragraph1);
            }
        }
    }

    public void analyzeRun(XWPFRun run, XWPFParagraph para) {
        //check if its a title/quote/Link/header
        //System.out.println(run.getText(0));
        String string = run.getText(0);
        //if(string.contains("\"")){
        //    run.setItalic(true);
        //}
        XWPFRun runtest = para.createRun();
        runtest.setText(string);
    }


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


