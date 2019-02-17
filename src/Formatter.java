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
    private boolean link = false;
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
        link = false;
        quote = false;
        if(paragraph.getNumFmt()!=null){
            paragraph1.createRun().setText("    - " + paragraph.getText());
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
        String string = run.getText(0);
        if(string == null ){
            FormattedString formattedString = new FormattedString(run.isBold(),run.isItalic(),run.getFontSize(),string,para);
            formattedString.print();
        }
        else if(link){
            String[] runs = string.split(" ");
            FormattedString link2 = new Link(run.isBold(),run.isItalic(),run.getFontSize(),runs[0],para);
            link2.print();
            for(int i = 1; i<runs.length; i++){
                FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), " " + runs[i], para);
                formattedString.print();
            }
            if(runs.length==1){
                link = true;
            }
            else{
                link = false;
            }
        }
        else if(quote){
            String[] runs = string.split("”");
            if(runs.length==2) {
                FormattedString quote2 = new Quote(run.isBold(), run.isItalic(), run.getFontSize(), runs[0] + "” ", para);
                quote2.print();
                FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), runs[1], para);
                formattedString.print();
                quote = false;
            }
            else{
                FormattedString quote2 = new Quote(run.isBold(), run.isItalic(), run.getFontSize(), runs[0], para);
                quote2.print();
            }
        }
        else if(string.contains("“")){
            //quote=!quote;
            String[] runs = string.split("“");
            if(runs[0].contains("”")){
                String[] runs2 = runs[0].split("”");
                FormattedString quote = new Quote(run.isBold(),run.isItalic(),run.getFontSize()," “"+runs2[0]+"” ",para);
                quote.print();
                FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), runs2[1] + runs[1], para);
                formattedString.print();
            }
            else {
                FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), runs[0], para);
                formattedString.print();
                String[] runs2 = runs[1].split("”");
                if(runs2.length==2) {
                    FormattedString quote2 = new Quote(run.isBold(), run.isItalic(), run.getFontSize(), " “"+runs2[0]+"” ", para);
                    quote2.print();
                    formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), runs2[1], para);
                    formattedString.print();
                }
                else{
                    if(runs[1].charAt(runs[1].length()-1)=='”'){
                        FormattedString quote2 = new Quote(run.isBold(), run.isItalic(), run.getFontSize(), " “" + runs2[0] + "” " , para);
                        quote2.print();
                    }
                    else {
                        FormattedString quote2 = new Quote(run.isBold(), run.isItalic(), run.getFontSize(), " “" + runs2[0], para);
                        quote2.print();
                        quote = true;
                    }
                }
            }
        }
        else if(string.contains("http://")){
            String[] runs = string.split("http:");
            if(runs[0].contains("//")){
                String[] runs2 = runs[0].split(" ");
                FormattedString link = new Link(run.isBold(), run.isItalic(), run.getFontSize(), "http:" + runs2[0], para);
                link.print();
                for(int i = 1; i<runs2.length; i++){
                    FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), " " + runs2[i], para);
                    formattedString.print();
                }
                if(runs.length==2){
                    FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), runs[1], para);
                    formattedString.print();
                }
            }
            else if(runs[1].contains("//")){
                FormattedString formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), runs[0], para);
                formattedString.print();
                String[] runs2 = runs[1].split(" ");
                FormattedString link2 = new Link(run.isBold(), run.isItalic(), run.getFontSize(), "http:" + runs2[0], para);
                link2.print();
                for(int i = 1; i<runs2.length; i++){
                    formattedString = new FormattedString(run.isBold(), run.isItalic(), run.getFontSize(), " " + runs2[i], para);
                    formattedString.print();
                }
                if(runs2.length==1){
                    link = true;
                }
            }
        }
        else{
            FormattedString formattedString = new FormattedString(run.isBold(),run.isItalic(),run.getFontSize(),string,para);
            formattedString.print();
        }

    }
}