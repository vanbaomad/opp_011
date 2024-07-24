package logic;

import java.io.*;

public class FileUtils {
    public static <T> void writeToFile(String fileName, T[] array) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] readFromFile(String fileName, Class<T[]> clazz) {
        T[] array = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            array = (T[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, initializing new array.");
            try {
                array = (T[]) java.lang.reflect.Array.newInstance(clazz.getComponentType(), 0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}
