import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;


public class Title extends FormattedString {

    Title(boolean b, boolean u, boolean i, String string, XWPFParagraph paragraph){
        super(true, false, false, 18, string, paragraph);
    }

    @Override
    public void print(){
        XWPFRun titleRun = paragraph.createRun();
        titleRun.setBold(this.b);
        titleRun.setItalic(this.i);
        titleRun.setFontSize(this.size);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        titleRun.setText(this.string);
        titleRun.addBreak();


    }
}
