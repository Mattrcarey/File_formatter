import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Formatter {
    private boolean title = false;
    private boolean quote = false;
    public XWPFDocument newfile;// = new XWPFDocument();

    public void readfile(File file, String filename) throws IOException {
        newfile = new XWPFDocument();
        String formatted_filename = filename.substring(0,filename.length()-5);
        FileOutputStream out = new FileOutputStream(new File(formatted_filename +"_formatted.docx"));
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        List<XWPFParagraph> paragraphs = doc.getParagraphs();
            for(XWPFParagraph para : paragraphs){
                analyzeParagraph(para);
            }
            newfile.write(out);
            out.close();
    }

    public void analyzeParagraph(XWPFParagraph paragraph){
        XWPFParagraph paragraph1 = newfile.createParagraph();
        if(paragraph.getNumFmt()!=null){
            paragraph1.createRun().setText("    - " + paragraph.getText());
            System.out.println(paragraph.getText());
        }
        else if(paragraph.getText().length()<89){
            if(!title){
                FormattedString t = new Title(paragraph.getText(),paragraph1);
                t.print();
                title = true;
            }
            else{
                FormattedString header = new Header(paragraph.getText(),paragraph1);
                header.print();
            }
        }
        else {
            paragraph1.setSpacingBetween(2);
            for (XWPFRun run : paragraph.getRuns()) {
                analyzeRun(run, paragraph1);
            }
        }
    }

    public void analyzeRun(XWPFRun run, XWPFParagraph para) {
        //check if its a title/quote/Link/header
        String string = run.getText(0);
        if(quote){
            FormattedString quote = new Quote(run.isBold(),run.isItalic(),run.getFontSize(),string,para);
            quote.print();
        }
        else if(string.contains("“")){
            //quote=!quote;
            FormattedString quote = new Quote(run.isBold(),run.isItalic(),run.getFontSize(),string,para);
            quote.print();
        }
        else if(string.contains("www")){
            FormattedString link = new Link(run.isBold(),run.isItalic(),run.getFontSize(),string,para);
            link.print();
        }
        else{
            FormattedString formattedString = new FormattedString(run.isBold(),run.isItalic(),run.getFontSize(),string,para);
            formattedString.print();
        }

        //XWPFRun runtest = para.createRun();
        //runtest.setText(string);
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


