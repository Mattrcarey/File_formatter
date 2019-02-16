import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class FormattedString {
    public boolean b,u,i;
    public float size;
    public String string;
    public XWPFParagraph paragraph;

    FormattedString(){
        b=false;
        u=false;
        i=false;
    }

    FormattedString(boolean b, boolean u, boolean i, float size, String string, XWPFParagraph paragraph){
        this.b=b;
        this.u=u;
        this.i=i;
        this.size=size;
        this.string=string;
        this.paragraph = paragraph;
    }

    public void print(){
        //XWPFRun
        //document.print(string);
    }


}
