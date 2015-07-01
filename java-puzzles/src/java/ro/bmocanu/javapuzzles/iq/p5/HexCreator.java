package ro.bmocanu.javapuzzles.iq.p5;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by Bogdan on 7/1/2015.
 */
public class HexCreator {

    public static void main(String[] args) throws IOException {
        byte[] fileBytes = getFileContent("D:\\Projects\\Github\\tryouts\\java-puzzles\\src\\c\\iq_p5\\x64\\Debug\\IqP5.dll");
        byte[] archivedBytes = zipBytes(fileBytes);
        System.out.println(toHex(archivedBytes));

        fileBytes = getFileContent("D:\\Projects\\Github\\tryouts\\java-puzzles\\src\\c\\iq_p5\\Debug\\IqP5.dll");
        archivedBytes = zipBytes(fileBytes);
        System.out.println(toHex(archivedBytes));
    }



    public static void main3(String[] args) throws DataFormatException, IOException, ClassNotFoundException {
//        byte[] zippedAmBytes = DatatypeConverter.parseHexBinary(ARCHIVED_AM);
//        byte[] unzippedAmBytes = unzip(zippedAmBytes);
//
//        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(unzippedAmBytes));
//        AccountManager manager = (AccountManager) ois.readObject();
//        ois.close();
//
//        manager.check();
    }

    public static String toHex(byte[] bytes) {
        return DatatypeConverter.printHexBinary(bytes); //String.format("%040x", new BigInteger(1, bytes));
    }

    public static byte[] zipBytes(byte[] bytes) throws IOException {
        ByteArrayOutputStream baos = null;
        Deflater dfl = new Deflater();
        dfl.setLevel(Deflater.BEST_COMPRESSION);
        dfl.setInput(bytes);
        dfl.finish();
        baos = new ByteArrayOutputStream();
        byte[] tmp = new byte[4 * 1024];
        try {
            while (!dfl.finished()) {
                int size = dfl.deflate(tmp);
                baos.write(tmp, 0, size);
            }
        } finally {
            baos.close();
        }

        return baos.toByteArray();
    }

    public static byte[] unzipBytes(byte[] bytes) throws DataFormatException, IOException {
        Inflater decompressor = new Inflater();
        decompressor.setInput(bytes);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length);
        byte[] buf = new byte[1024];
        while (!decompressor.finished()) {
            int count = decompressor.inflate(buf);
            baos.write(buf, 0, count);

        }
        baos.close();
        return baos.toByteArray();
    }

    public static byte[] getFileContent(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

}
