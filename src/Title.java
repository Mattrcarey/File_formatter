import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;


public class Title extends FormattedString {

    Title(String string, XWPFParagraph paragraph){
        super(true, false, false, 18, string, paragraph);
    }

    @Override
    public void print(){
        XWPFRun titleRun = paragraph.createRun();
        titleRun.setBold(this.b);
        titleRun.setItalic(this.i);
        titleRun.setFontSize(this.size);
        titleRun.setText(this.string);
        titleRun.addBreak();
    }
}
