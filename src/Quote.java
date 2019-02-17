import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Quote extends FormattedString {

    public Quote(boolean b,boolean i, int size, String string, XWPFParagraph paragraph){
        super(b,i,12, string, paragraph);
    }

    @Override
    public void print() {
        XWPFRun run = paragraph.createRun();
        run.setItalic(true);
        run.setBold(b);
        run.setFontSize(size);
        run.setText(string);
    }
}
