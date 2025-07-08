import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.ArrayList;

public class FileManipulation {

    public static ArrayList<Character> read(String path) {
        Path file = null;
        try {
            file = Path.of(path);
        } catch (InvalidPathException e) {
            System.out.println("Couldn't find the path to read from.");
            e.printStackTrace();
            return null;
        }
        ArrayList<Character> array = new ArrayList<>();

        try (FileChannel channel = FileChannel.open(file)) {
            ByteBuffer buffer = ByteBuffer.allocate(512);

            while (channel.read(buffer) >= 0) {
                buffer.flip(); // resets the position to 0

                while (buffer.hasRemaining()) {
                    array.add((char) buffer.get());
                }

                buffer.clear();
            }

        } catch (IOException e) {
            System.err.println(e);
        }


        return array;
    }

    public static void write(String path, String data) {
        Path file = null;
        try {
            file = Path.of(path);
        } catch (InvalidPathException e) {
            System.out.println("Couldn't find the path to write to.");
            e.printStackTrace();
        }
        try{
            Files.write(file, data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
