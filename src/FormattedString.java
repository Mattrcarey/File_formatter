import java.io.PrintWriter;

public class FormattedString {
    public boolean b,u,i;
    public float size;
    public String string;
    public PrintWriter printer;

    FormattedString(){
        b=false;
        u=false;
        i=false;
    }

    FormattedString(boolean b, boolean u, boolean i, float size, String string, PrintWriter printer){
        this.b=b;
        this.u=u;
        this.i=i;
        this.size=size;
        this.string=string;
        this.printer = printer;
    }

    public void print(){
        printer.print(string);
    }


}
