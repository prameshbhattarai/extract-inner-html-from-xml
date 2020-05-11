package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pramesh-bhattarai
 */
public abstract class TestFileReader {

    protected InputStream getResource(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return new FileInputStream(file);
    }
}
