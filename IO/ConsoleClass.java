import java.io.Console;

class ConsoleClass {
    public static void main(String args[]) {
        // Console class probices a nice way of interacting with System.in and
        // System.out with convenient methods

        Console console = System.console();
        System.out.println("What's your name?");
        if (console != null) {
            // Flush is used to force any buffered output to be written immedietly, it is
            // recommended that you call the flush method prior to calling any readLine or
            // readPassword methods in order to ensure that no data is pending during the
            // read.
            console.flush();
            // readLine reads a line of text from the user and is terminated by the enter
            // key.
            String name = console.readLine();
            console.writer().println("Your name is: " + name);
            // readLine also supports an overloaded version that prints the text prior to
            // reading a line
            String age = console.readLine("What is your age? ");
            console.writer().println("Your age is: " + age);
            // readPassword disables echoing, password is hidden when typing. It returns a
            // char[] instead of string as String values are added to the String pool which
            // could be recovered by a malicious hacker a.k.a Andrew, if the memory in the
            // application is dumped to disk.
            char[] password = console.readPassword("Give me your password, " + name);

            // immediately clear password from memory
            for (int i = 0; i < password.length; i++) {
                password[i] = 'x';
            }
        }
    }
}