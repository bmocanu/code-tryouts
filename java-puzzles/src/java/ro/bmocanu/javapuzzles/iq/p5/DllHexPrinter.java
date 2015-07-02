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

public class DllHexPrinter {

    public static void main(String[] args) throws IOException {
        byte[] fileBytes = getFileContent("./src/c/iq_p5/Release/IqP5.dll");
        byte[] archivedBytes = zipBytes(fileBytes);
        System.out.println("32: " + toHex(archivedBytes));

        fileBytes = getFileContent("./src/c/iq_p5/x64/Release/IqP5.dll");
        archivedBytes = zipBytes(fileBytes);
        System.out.println("64: " + toHex(archivedBytes));
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

    public static byte[] getFileContent(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
}
