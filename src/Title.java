import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class Title extends FormattedString {

    Title(String string, XWPFParagraph paragraph){
        super(true, false, 18, string, paragraph);
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
