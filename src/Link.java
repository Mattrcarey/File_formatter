import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Link extends FormattedString {

    public Link(boolean b, boolean u, boolean i, int size, String string, XWPFParagraph paragraph){
        super(b,u,i, size, string, paragraph);
    }

    @Override
    public void print() {
        XWPFRun run = paragraph.createRun();
        run.setColor("#0000EE");
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.addBreak();
    }

    //https://www.baeldung.com/java-microsoft-word-with-apache-poi

    //https://blog.webnersolutions.com/read-word-document-using-apache-poi-java
}
