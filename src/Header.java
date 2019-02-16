import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Header extends FormattedString {

    Header(String string, XWPFParagraph paragraph){
        super(true, false, false, 12, string, paragraph);
    }

    @Override
    public void print(){
        XWPFRun headerRun = paragraph.createRun();
        headerRun.setBold(this.b);
        headerRun.setItalic(this.i);
        headerRun.setFontSize(this.size);
        headerRun.setText(this.string);
        headerRun.addBreak();
    }

}
