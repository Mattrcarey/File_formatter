public class Link extends FormattedString {

    @Override
    public void print() {
        super.print();
        //System.out.print("\033[0;1m" + super.string);
        System.out.println("\u001B34;1m" + super.string);
    }

}
