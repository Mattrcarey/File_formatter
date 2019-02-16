public class Quote extends FormattedString {

    @Override
    public void print() {
        System.out.println("\033[3m" + super.string);
    }
}
