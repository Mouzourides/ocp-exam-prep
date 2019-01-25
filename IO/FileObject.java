import java.io.File;

class FileObject {
    public static void main(String args[]) {
        // Relative path
        File sampleFile = new File("sampleFile");
        System.out.println(sampleFile.exists());

        // Absolute path
        File parent = new File("/home/mouzourides/Projects/ocp-exam-prep/IO/");
        File child = new File(parent, "sampleFile");
        if (child.exists()) {
            System.out.println("Exists: " + child.exists());
            System.out.println("Name: " + child.getName());
            System.out.println("Parent: " + child.getParent());
            System.out.println("Last modified: " + child.lastModified());
            System.out.println("Is dircetory: " + child.isDirectory());
            System.out.println("Is file: " + child.isFile());
        }
    }
}