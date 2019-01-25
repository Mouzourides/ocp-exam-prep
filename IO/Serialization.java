import java.io.*;
import java.util.*;

class Serialization implements Serializable {
    // Good practise to include a serialVersionID and update it whenever the class
    // is modified.
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) {
        // To serialize an object, the class must implement the Serializable interface
        // which has no methods to implement, it just lets java know its Serializable.
        // Nested objects must also implement Serializable, else a
        // NotSerializableException will occur. Yeah, you better be scared.

        // You can use the transient keyword on a field to ignore its serialization.
        // Static members are also ignored.
    }

    public static void serializeAndDeserializeObject(File input, File output)
            throws IOException, ClassNotFoundException {
        List<Serialization> objects = new ArrayList<>();
        // Serialize
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(input)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Serialization) {
                    objects.add((Serialization) object);
                }
            }
        } catch (EOFException e) {
            // End of file
        }

        // Deserialize
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(output)))) {
            for (Serialization s : objects) {
                out.writeObject(s);
            }
        }
    }
}