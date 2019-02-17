import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class FormattedString {
    public boolean b,u,i;
    public int size;
    public String string;
    public XWPFParagraph paragraph;

    FormattedString(boolean b,boolean i, int size, String string, XWPFParagraph paragraph){
        this.b=b;
        this.i=i;
        this.size=size;
        this.string=string;
        this.paragraph = paragraph;
    }

    public void print(){
        XWPFRun run = paragraph.createRun();
        run.setBold(b);
        run.setItalic(i);
        run.setText(string);
        run.setFontSize(12);
    }


}
