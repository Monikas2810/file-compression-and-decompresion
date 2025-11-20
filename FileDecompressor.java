import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileDecompressor {
    public static void decompressFile(File zipFile, File outputDir) throws IOException {
        try (
            FileInputStream fis = new FileInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(fis)
        ) {
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                File newFile = new File(outputDir, entry.getName());
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
                entry = zis.getNextEntry();
            }
        }
    }
}