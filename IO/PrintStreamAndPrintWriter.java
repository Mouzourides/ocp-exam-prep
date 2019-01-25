import java.io.FileNotFoundException;
import java.io.PrintWriter;

class PrintStreamAndPrintWriter {
    public static void main(String args[]) throws FileNotFoundException {
        // PrintStream operates on OutputStream instances and writes data as bytes
        // PrintWriter operates on Writer instances and writes data as characters

        // System.out and System.err and PrintStream objects! wtf

        PrintWriter out = new PrintWriter("zoo.log");
        out.print(5);
        out.printf("5" + 3); // printf and format() are identical
        out.format("5" + 3); // printf and format() are identical
        out.println(2.0);
    }
}