import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompressor {
    public static void compressFile(File fileToCompress, File destinationZip) throws IOException {
        try (
            FileOutputStream fos = new FileOutputStream(destinationZip);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            FileInputStream fis = new FileInputStream(fileToCompress)
        ) {
            ZipEntry zipEntry = new ZipEntry(fileToCompress.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }
}