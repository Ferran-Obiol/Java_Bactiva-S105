package n1exercici5;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        SerializableClass serializableClass = new SerializableClass("nom", 7);
        System.out.println("Object to be serialized: " + serializableClass.toString());

        try (FileOutputStream fout = new FileOutputStream("test.ser", false);
             ObjectOutputStream oos = new ObjectOutputStream(fout))
        {
            oos.writeObject(serializableClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("test.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);)
        {
            SerializableClass deserializedObject = (SerializableClass) ois.readObject();
            System.out.println("Object to be deserialized: " + deserializedObject.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
