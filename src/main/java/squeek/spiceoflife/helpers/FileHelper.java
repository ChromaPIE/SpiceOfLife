package squeek.spiceoflife.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileHelper {
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        copyFile(sourceFile, destFile, false);
    }

    public static void copyFile(File sourceFile, File destFile, final boolean overwrite) throws IOException {
        try (InputStream sourceInput = new FileInputStream(sourceFile)) {
            copyFile(sourceInput, destFile, overwrite);
        }

    }

    public static void copyFile(InputStream sourceInput, File destFile, final boolean overwrite) throws IOException {
        if (destFile.exists()) {
            if (overwrite)
                assert destFile.delete();
            else
                return;
        } else {
            assert destFile.createNewFile();
        }

        try (FileOutputStream destOutput = new FileOutputStream(destFile)) {
            int readBytes = 0;
            byte[] buffer = new byte[4096];
            while ((readBytes = sourceInput.read(buffer)) > 0) {
                destOutput.write(buffer, 0, readBytes);
            }
        }
    }
}
