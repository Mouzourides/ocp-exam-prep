import java.util.Locale;
import java.util.ResourceBundle;

class ResourceBundles {
    public static void main(String args[]) {
        printProperties(Locale.getDefault());
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Test", locale);
        System.out.println(rb.getString("greeting"));
    }
}