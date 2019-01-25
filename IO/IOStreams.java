import java.io.*;
import java.util.*;

class IOStreams {
    public static void main(String args[]) throws IOException {
        // I/O Streams are data streams, unrelated to Java 8's Streams API

        // Streams allow for reading or writing of large files, e.g. 1TB, that could not
        // be loaded into memory entirely via focusing on a small section of the stream
        // at a time

        // ALL STREAMS USE BYTES, even streams that process strings are build upon
        // streams that read or write bytes

        // Difference between Reader/ Writer and Stream classes:
        // Reader/ Writer can onlu output strings or chars whereas Stream can do all
        // types of binary or byte data.

        // Streams need to be closed after usage is complete to stop leaks and file
        // locks. They implement auto closable so try with resources can be used.

        // Flushing ensures changes are written to the OS, ensures if the program
        // unexpectedly fails the data is still writen. Is costly resource wise so
        // should be done intermittently.

        // You can use mark(int) and reset to mark a point with a read ahead value in a
        // stream and then revert
        // back to it. Basically saving in a game. Only some streams support it, you can
        // call markSupported() to find out if the stream near you has it. If the read
        // ahead value is exceeded an exception will be thrown.

        // You can also skip over data using skip(long), it returns a long of the
        // skipped bytes or zero / negative number if no skips happened due to being at
        // the end of the stream.
    }

    // Example of reading and writing byte at a time
    static void readAndWrite(File input, File output) throws IOException {
        try (InputStream in = new FileInputStream(input); OutputStream out = new FileOutputStream(output);) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    // Example of reading and writing chunks of bytes at a time
    // Buffered means it reads or writes chunks of bytes
    static void readAndWriteBuffered(File input, File output) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(input));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    // Example of reading and writing using characters reader/ writer streams
    // Allows us more control as we have access to all string methods when reading /
    // writing text data
    static void readAndWriteCharacters(File input, File output) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(input));
                BufferedWriter out = new BufferedWriter(new FileWriter(output))) {
            String s;
            while ((s = in.readLine()) != null) {
                data.add(s);
            }
            for (String d : data) {
                out.write(d);
            }
        }
    }
}